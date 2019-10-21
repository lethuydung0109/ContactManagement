package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.sql.DataSource;

import java.sql.Statement;

import entities.Address;
import entities.Contact;
import entities.PhoneNumber;
import services.AddressService;
import services.ContactService;
import services.PhoneNumberService;

/**
 * Servlet implementation class contactServlet
 */
public class contactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public contactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter( "email" );
		request.setAttribute( "email",paramId);

		this.getServletContext().getRequestDispatcher( "../../../WebContent/updateContact.jsp" ).forward( request, response );
		
		DataSource ds = null;
		Connection cn =null;
		Statement stmt = null;
		ResultSet rs;
		//List <Contact> contacts;
		
		try
		{
			Context ctx = new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/jdbc/jee");
			cn=ds.getConnection();
						
			 stmt = (Statement) cn.createStatement();
			 
			 //Récupération des contact dans la bd
	            ResultSet resultat =stmt.executeQuery("SELECT * from Contact");
	            
	             //contacts = new ArrayList();
	             
	            Map<String, String> contacts = new HashMap<String, String>();

	            int id =0;
	            String firstname="";
	            String lastname="";
	            String email="";
	            String address="";

	            while (resultat.next()) {
	            	 id=resultat.getInt("idContact");
	                 firstname=resultat.getString("firstname");
	                 lastname=resultat.getString("lastname");
	                 email=resultat.getString("email");
	                 address=resultat.getString("adresse"); 
	                 
	                 //Contact ctct = new Contact(id,firstname,lastname,email); //rajouter address après
	                 contacts.put(firstname,lastname);	 
	                 
	            }
	             
	            /* Stockage du résultat et des messages d'erreur dans l'objet request */
	            
                request.setAttribute( "contacts", contacts);
	            	            
	            resultat.close();
	            stmt.close();
	            cn.close();                              
	            stmt = null;
	            resultat = null;
		}catch ( SQLException | NamingException e ) {             
	            System.out.println("erreur dans la requete !");	             
	    }finally {
				try { if (cn != null) cn.close(); }
				catch (SQLException e) { e.printStackTrace(); }
		}	         	     	       
	    
		this.getServletContext().getRequestDispatcher( "WebContent/listeContacts.jsp" ).forward( request, response );

//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//this.getServletContext().getRequestDispatcher( "../../WebContent/listeContacts.jsp" ).forward( request, response );
		
		//int id = Integer.parseInt(request.getParameter("id")); //mettre en "" exactement les mm données que ceux du formulaire dans l'index
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");		
		String email = request.getParameter("email");
		String street= request.getParameter("street");
		String city = request.getParameter("city");
		String zip = request.getParameter("zip");		
		String country = request.getParameter("country");
		String portable= request.getParameter("portable");
		String fixe= request.getParameter("fixe");
		
		Address address = new Address(street,city,zip,country);
		AddressService adService= new AddressService();
		
		PhoneNumber ptb = new PhoneNumber("portable",portable);			
		PhoneNumber fxPhone = new PhoneNumber("fixe",fixe);
		PhoneNumberService phoneService = new PhoneNumberService();		
		
		Set<PhoneNumber> listPhone = new HashSet<>();
		listPhone.add(ptb);
		listPhone.add(fxPhone);
				
		Contact contact = new Contact(firstname,lastname,email,address,listPhone);
		ContactService contactService = new ContactService();
		
		
		//create address first to take idaddress 
		int idAddress = adService.createAddress(address);
		try {
			contactService.createContact(contact, idAddress);
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//			phoneService.createPhoneNumber(ptb);
//			phoneService.createPhoneNumber(fxPhone); // mettre un attribut contact
		
	}

}
