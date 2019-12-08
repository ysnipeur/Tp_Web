package Controlleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Projet;
import Models.ProjetDAO;
import Models.Tache;
import Models.TacheDAO;
import Models.UserDAO;
import Models.Utilisateur;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDAO dao = new UserDAO();
	private ProjetDAO projetDAO = new ProjetDAO();
	private TacheDAO tacheDAO = new TacheDAO();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
        String pwd = request.getParameter("mdp");
        String error_message = null;
        
        Utilisateur user = dao.authentificate(login, pwd);

        if (user != null) {
        	
        	int role = user.isRole();
        	
        	 request.setAttribute("user", user);
        	 
        	 if(!user.isStatut())
        	 {
        		 
        		 error_message = "Votre compte n'est plus actif, veillez contacter votre Administrateur";
        		 
        		 request.setAttribute("error_message", error_message);
        		 
        		 RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
     			
     			 dispatcher.forward(request, response); 
        		
        	 }
        	 else if(user.isFirstConnection())
        	 {
        		 error_message = "C'est votre première connexion";
        		 
        		 request.setAttribute("error_message", error_message);
        		 
        		 RequestDispatcher dispatcher = request.getRequestDispatcher("changepwd.jsp");
     			
     			dispatcher.forward(request, response);
        		
        	 }
        	 else
        	 {
	        	switch(role)
	        	{
	        		case 0 : 
	        		
	        		System.out.println("Je suis le super admin");
	        		List<Utilisateur> listUserSuper = dao.selectAllUsersCreatedByAdmin(user.getId());
	        		
	        		System.out.println("id user : " + user.getId());
	        		
	        		List<Projet> listProjetAffecter = projetDAO.selectAllProjetsAffecter();
	        		
	        		listProjetAffecter = loadProjetResponsable(listProjetAffecter);
	        		
	        		List<Projet> listProjetNonAffecter = projetDAO.selectAllProjetsNonAffecter();
	        		
	        		request.setAttribute("user", user);
	        		request.setAttribute("listProjetAffecter", listProjetAffecter);
	        		request.setAttribute("listProjetNonAffecter", listProjetNonAffecter);
	        		
	        		if(listUserSuper.isEmpty())
	        			System.out.println("No Data");
	    			request.setAttribute("listUser", listUserSuper);
	        		
	        		RequestDispatcher dispatcher0 = request.getRequestDispatcher("vueSuper.jsp");
	        		dispatcher0.forward(request, response);
	    			break;
	    			
	        		case 1 : 
	        		
	        		System.out.println("Je suis un admin");
	        		
	        		
	        		List<Utilisateur> listUser = dao.selectAllUsersCreatedByAdmin(user.getId());
	        		
	        		System.out.println("id user : " + user.getId());
	        		
	        		List<Projet> listProjet = projetDAO.selectAllProjetsOfAdmin(user.getId());
	        		
	        		listProjet = loadTachesProjet(listProjet);
	        		
	        		request.setAttribute("user", user);
	        		request.setAttribute("listProjet", listProjet);
	        		
	        		if(listUser.isEmpty())
	        			System.out.println("No Data");
	    			request.setAttribute("listUser", listUser);
	    			
	        		
	        		RequestDispatcher dispatcher = request.getRequestDispatcher("vueAdmin.jsp");
	        		dispatcher.forward(request, response);
	        		
	    			break;
	    			
	        		case 2 : 
	              		 
	            		System.out.println("Je suis un simple utilisateur");
	            		List<Tache> listTache = tacheDAO.selectAllTachesOfAdmin(user.getId());
	            		
	            		request.setAttribute("user", user);
		        		request.setAttribute("listTache", listTache);
	            		
	            		RequestDispatcher dispatcher2 = request.getRequestDispatcher("vueUser.jsp");
	            		dispatcher2.forward(request, response);
	        			break;
	        	}
        	 }
        	
        }
        else {
        	
        	error_message = "Authentification Echouée";
        	
        	request.setAttribute("error_message", error_message);
        	
        	RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			
			dispatcher.forward(request, response);
        }
				
	}
	
	private List<Projet> loadProjetResponsable(List<Projet> listProjet)
	{
		List<Projet> listProjet1 = new ArrayList<Projet>();
		
		listProjet1 = listProjet;
		
		for(Projet projet : listProjet1)
		{
			
			Utilisateur userResponsable = dao.selectUser(projet.getIdResponsable());
			projet.setResponsable(userResponsable);
			if(projet != null)
				System.out.println("chef projet : " + projet.getResponsable().getNom());
			else
				System.out.println("Chef vide!!!!");
		}
		
		return listProjet1;
	}
	private List<Projet> loadTachesProjet(List<Projet> listProjet)
	{
		
		List<Projet> listProjet1 = new ArrayList<Projet>();
		
		listProjet1 = listProjet;
		
		System.out.println("Nombre projet : " + listProjet1.size());
		
		for(Projet projet : listProjet1)
		{
			projet.setListeTachesAffecter(tacheDAO.selectAlltachesDeProjetAffecter(projet.getCode_projet()));
			projet.setListeTachesNonAffecter(tacheDAO.selectAlltachesDeProjetNonAffecter(projet.getCode_projet()));
		}
		
		for(Projet projet : listProjet1)
		{
			System.out.println("projet actuel" + projet.getCode_projet());
			if(projet.getListeTachesAffecter().size() > 0)
				System.out.println("Sa marche");
			else
				System.out.println("Problem");
			
			for(Tache tache : projet.getListeTachesAffecter())
			{
				
				Utilisateur userResponsable = dao.selectUser(tache.getIdResponsable());
				tache.setResponsable(userResponsable);
				if(tache != null)
					System.out.println("cout tache : " + tache.getCoutunit_tc());
				else
					System.out.println("Tache vide!!!!");
			}
		}
		
		return listProjet1;
	}

}
