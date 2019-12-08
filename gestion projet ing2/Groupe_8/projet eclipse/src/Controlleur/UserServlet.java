package Controlleur;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import Models.Utilisateur;
import Models.Projet;
import Models.ProjetDAO;
import Models.Tache;
import Models.TacheDAO;
import Models.UserDAO;


/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UserDAO userDAO;
	private ProjetDAO projetDAO;
	private TacheDAO tacheDAO;
		
	public void init()
	{
		userDAO = new UserDAO();
		projetDAO = new ProjetDAO();
		tacheDAO = new TacheDAO();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		
		try
		{
			switch (action) {
			
			case "/changepwd":
				changepwd(request, response);
				break;
			
			case "/login":
				login(request, response);
				break;
				
			case "/insertUser":
				insertUser(request, response);
				break;
				
			case "/activer":
				activerUser(request, response);
				break;
			
			case "/desactiver":
				desactiverUser(request, response);
				break;
			
			case "/edit":
				showEditForm(request, response);
				break;
				
			case "/update":
				updateUser(request, response);
				break;
				
			case "/insertTache":
				insertTache(request, response);
				break;
				
			case "/insertProjet":
				insertProjet(request, response);
				break;
			case "/updateProjet":
				updateProjet(request, response);
				break;
			case "/updateTache":
				updateTache(request, response);
				break;	
			case "/annulerTache":
				annulerTache(request, response);
				break;
			case "/annulerProjet":
				annulerProjet(request, response);
				break;
			case "/suspendreTache":
				suspendreTache(request, response);
				break;	
				
			case "/suspendreProjet":
				suspendreProjet(request, response);
				break;	
			case "/demarerTache":
				demarerTache(request, response);
				break;
				
			case "/demarerProjet":
				demarerProjet(request, response);
				break;
				
			case "/affecterTache":
				affecterTache(request, response);
				break;
				
			case "/affecterProjet":
				affecterProjet(request, response);
				break;
				
			case "/retirerTache":
				retirerTache(request, response);
				break;
				
			case "/terminerTache":
				terminerTache(request, response);
				break;
				
			case "/terminerProjet":
				terminerProjet(request, response);
				break;
			case "/retirerProjet":
				retirerProjet(request, response);
				break;
				
			case "/cvYvan":
				cvYvan(request, response);
				break;
			case "/cvKOUEMOU":
				cvKOUEMOU(request, response);
				break;
			case "/cvMOUTEKE":
				cvMOUTEKE(request, response);
				break;
				
			default :
				System.out.println("Rien ne passe!!!!");
				break;

			
			}
		}
		catch(SQLException ex)
		{
			throw new ServletException(ex);
		}
		
	}
	
	private void showAdminDashBoard(int id, HttpServletRequest request, HttpServletResponse response)
	
			throws SQLException, IOException, ServletException
	{
		
		// Id est celui de l'administrateur connecter
		
		System.out.println("vue de l'admin");
		
		Utilisateur existingUser = userDAO.selectUser(id);
		
		request.setAttribute("user", existingUser);
		
		
		List<Utilisateur> listUser = userDAO.selectAllUsersCreatedByAdmin(id);
		
		List<Projet> listProjet = projetDAO.selectAllProjetsOfAdmin(existingUser.getId());
		
		listProjet = loadTachesProjet(listProjet);
		
		
		request.setAttribute("listProjet", listProjet);
		
		if(listUser.isEmpty())
			System.out.println("No Data");
		request.setAttribute("listUser", listUser);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("vueAdmin.jsp");
		
		dispatcher.forward(request, response);
		
	}
	
private void showSuperAdminDashBoard(int id, HttpServletRequest request, HttpServletResponse response)
	
			throws SQLException, IOException, ServletException
	{
		
	System.out.println("Je suis le super admin");
	
	Utilisateur existingUser = userDAO.selectUser(id);
	List<Utilisateur> listUserSuper = userDAO.selectAllUsersCreatedByAdmin(existingUser.getId());
	
	System.out.println("id user : " + existingUser.getId());
	
	List<Projet> listProjetAffecter = projetDAO.selectAllProjetsAffecter();
	
	listProjetAffecter = loadProjetResponsable(listProjetAffecter);
	
	List<Projet> listProjetNonAffecter = projetDAO.selectAllProjetsNonAffecter();
	
	request.setAttribute("user", existingUser);
	request.setAttribute("listProjetAffecter", listProjetAffecter);
	request.setAttribute("listProjetNonAffecter", listProjetNonAffecter);
	
	if(listUserSuper.isEmpty())
		System.out.println("No Data");
	request.setAttribute("listUser", listUserSuper);
	
	RequestDispatcher dispatcher0 = request.getRequestDispatcher("vueSuper.jsp");
	dispatcher0.forward(request, response);
		
	}

// Méthode pour charger les responsable de chaque projet

private List<Projet> loadProjetResponsable(List<Projet> listProjet)
{
	List<Projet> listProjet1 = new ArrayList<Projet>();
	
	listProjet1 = listProjet;
	
	for(Projet projet : listProjet1)
	{
		
		Utilisateur userResponsable = userDAO.selectUser(projet.getIdResponsable());
		projet.setResponsable(userResponsable);
		if(projet != null)
			System.out.println("chef projet : " + projet.getResponsable().getNom());
		else
			System.out.println("Chef vide!!!!");
	}
	
	return listProjet1;
}
	private void changepwd(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		
		String ancienmdp = request.getParameter("ancienmdp");
        String nouveaumdp = request.getParameter("nouveaumdp");
        String error_message = null;
        
        boolean operationSuccess = false;
        
        if(ancienmdp.contentEquals(nouveaumdp))
        {
        	error_message = "Le nouveau mot de passe doit être différent de l'ancien";
        	
        	request.setAttribute("error_message", error_message);
        	
        	Utilisateur existingUser = userDAO.selectUser(id);
    		
    		request.setAttribute("user", existingUser);
        	
        	RequestDispatcher dispatcher = request.getRequestDispatcher("changepwd.jsp");
			
			dispatcher.forward(request, response);
        }
        else
        {
        	RequestDispatcher dispatcher = null;
        	
        	operationSuccess = userDAO.updateUserPassword(id, nouveaumdp);
        	
        	Utilisateur existingUser = userDAO.selectUser(id);
    		
    		request.setAttribute("user", existingUser);
    		
    		int role = existingUser.isRole();
    		
    		System.out.println("Son role : " + role);
    		
    		switch(role)
        	{
        		case 1 : 
        		
        		System.out.println("vue de l'admin");
        		
        		List<Utilisateur> listUser = userDAO.selectAllUsersCreatedByAdmin(id);
        		
        		if(listUser.isEmpty())
        			System.out.println("No Data");
        		
        		List<Projet> listProjet = projetDAO.selectAllProjetsOfAdmin(existingUser.getId());
        		
        		listProjet = loadTachesProjet(listProjet);
        		
        		request.setAttribute("listProjet", listProjet);
        		
    			request.setAttribute("listUser", listUser);
    			
        		dispatcher = request.getRequestDispatcher("vueAdmin.jsp");
        		
    			break;
    			
        		case 2 :
        			
        			System.out.println("vue de l'utilisateur");
        			
        			List<Tache> listTache = tacheDAO.selectAllTachesOfAdmin(existingUser.getId());
            		
	        		request.setAttribute("listTache", listTache);
	        		request.setAttribute("user", existingUser);
            		
            		RequestDispatcher dispatcher2 = request.getRequestDispatcher("vueUser.jsp");
            		dispatcher2.forward(request, response);
        			
            		
        			break;
    			
        	}
    		
    		dispatcher.forward(request, response);
        }
		
		
		
	}
	
	// Méthode qui permet de charger les différentes taches de chaque projet d'une liste de projet prise en parmaètre
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
				System.out.println("Nous avons des tac");
			else
				System.out.println("Aucune tache affecter");
			
			for(Tache tache : projet.getListeTachesAffecter())
			{
				
				Utilisateur userResponsable = userDAO.selectUser(tache.getIdResponsable());
				tache.setResponsable(userResponsable);
				if(tache != null)
					System.out.println("cout tache : " + tache.getCoutunit_tc());
				else
					System.out.println("Tache vide!!!!");
			}
		}
		
		return listProjet1;
	}

	private void login(HttpServletRequest request, HttpServletResponse response) 
		throws SQLException, IOException, ServletException
		{
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			
			dispatcher.forward(request, response);
		
		}
	
	public void listUser(HttpServletRequest request, HttpServletResponse response) 
		throws SQLException, IOException, ServletException
		{
			
			List<Utilisateur> listUser = userDAO.selectAllUsers();
			
			request.setAttribute("listUser", listUser);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("userList.jsp");
			
			dispatcher.forward(request, response);
			
		}
	

	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException
	{
		
	}
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException
	{
		
		int adminId = Integer.parseInt(request.getParameter("idAdmin"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String fonction = request.getParameter("fonction");
		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");
		int role = 2;
		boolean isFirstCon = true;
		boolean statut = true;
		
		
		
		Utilisateur newUser = new Utilisateur(nom, prenom, fonction, login, pwd, role, statut, isFirstCon, adminId);
		
		userDAO.insertUser(newUser);
		
		Utilisateur userActuel = userDAO.selectUser(adminId);
		request.setAttribute("id", adminId);
		
		if(userActuel.isRole() == 1)
		{
			try {
				showAdminDashBoard(adminId, request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			try {
				showSuperAdminDashBoard(adminId, request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	private void insertTache(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException
	{
		
		Date dateDeb = null;
		Date dateFin = null;
		
		int adminId = Integer.parseInt(request.getParameter("idAdmin"));
		String code_tache = request.getParameter("code_tc");
		String lib_tc = request.getParameter("design_tc");
		int prixU = Integer.parseInt(request.getParameter("prixUnitaire"));
		int codeResponsable = Integer.parseInt(request.getParameter("codeResponsable"));
		int avancement = Integer.parseInt(request.getParameter("avancement"));
		String codeProjet = request.getParameter("codeProjet");
		
		Timestamp dateDebut;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		
		try {
			
			dateDeb = format.parse(request.getParameter("dateDebut"));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			
			dateFin = format.parse(request.getParameter("dateFin"));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 long time = dateDeb.getTime();
		 
		  Timestamp startDate = new Timestamp(time);
		  
		  System.out.println("Date Debut : " + startDate);
		  
		  
		  time = dateFin.getTime();
		  
		  Timestamp endDate=new Timestamp(time); 
		  
		boolean etat = true;
		
		String statut = "Non Debuter";
		
		Tache nouvelTache = new Tache(code_tache, lib_tc, prixU, avancement, statut, etat, startDate, endDate);
		tacheDAO.insertTache(nouvelTache, codeResponsable, codeProjet);
		
		
		request.setAttribute("id", adminId);
		
		try {
			showAdminDashBoard(adminId, request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void insertProjet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException
	{
		
		Date dateDeb = null;
		Date dateFin = null;
		
		int adminId = Integer.parseInt(request.getParameter("idAdmin"));
		String code_projet = request.getParameter("code_tc");
		String type = request.getParameter("typeProjet");
		String intitule = request.getParameter("design_tc");
		int budget = Integer.parseInt(request.getParameter("prixUnitaire"));
		int codeResponsable = Integer.parseInt(request.getParameter("codeResponsable"));
		int avancement = Integer.parseInt(request.getParameter("avancement"));
		String codeProjet = request.getParameter("codeProjet");
		
		Timestamp dateDebut;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		
		try {
			
			dateDeb = format.parse(request.getParameter("dateDebut"));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			
			dateFin = format.parse(request.getParameter("dateFin"));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 long time = dateDeb.getTime();
		 
		  Timestamp startDate = new Timestamp(time);
		  
		  System.out.println("Date Debut : " + startDate);
		  
		  
		  time = dateFin.getTime();
		  
		  Timestamp endDate=new Timestamp(time); 
		  
		boolean etat = true;
		
		String statut = "Non Debuter";
		
		Projet nouvelTache = new Projet(code_projet, intitule,  budget, type, avancement, statut, etat, startDate, endDate);
		projetDAO.insertProjet(nouvelTache, codeResponsable);
		
		
		request.setAttribute("id", adminId);
		
		try {
			showSuperAdminDashBoard(adminId, request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void updateTache(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException
	{
		Date dateFin = null;
		
		boolean etat = true;
		
		int adminId = Integer.parseInt(request.getParameter("idAdmin"));
		String code_tache = request.getParameter("code");
		String lib_tc = request.getParameter("design_tc");
		int prixU = Integer.parseInt(request.getParameter("prixUnitaire"));
		int codeResponsable = Integer.parseInt(request.getParameter("codeResponsable"));
		int avancement = Integer.parseInt(request.getParameter("avancement"));
		String codeProjet = request.getParameter("codeProjet");
		String statut = request.getParameter("statut");
		
		System.out.println("Statut " + statut);
		
		if(statut == "Terminer")
			etat = false; // Si la tache est terminer elle n'est plus visible 
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			
			dateFin = format.parse(request.getParameter("dateFin"));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
		 long time = dateFin.getTime();
		  
		  Timestamp endDate=new Timestamp(time); 
		  
		
		
		tacheDAO.updateTacheInfos(code_tache, lib_tc, prixU, avancement, statut, etat, endDate, codeResponsable, codeProjet);
		
		
		request.setAttribute("id", adminId);
		
		try {
			showAdminDashBoard(adminId, request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void updateProjet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException
	{
		Date dateFin = null;
		
		boolean etat = true;
		
		int adminId = Integer.parseInt(request.getParameter("idAdmin"));
		String intitule = request.getParameter("design_tc");
		String type = request.getParameter("typeProjet");
		int budget = Integer.parseInt(request.getParameter("prixUnitaire"));
		int codeResponsable = Integer.parseInt(request.getParameter("codeResponsable"));
		int avancement = Integer.parseInt(request.getParameter("avancement"));
		String code_projet = request.getParameter("code");
		String statut = request.getParameter("statut");
		
		
		
		System.out.println("Statut " + statut);
		
		if(statut == "Terminer")
			etat = false; // Si la tache est terminer elle n'est plus visible 
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			
			dateFin = format.parse(request.getParameter("dateFin"));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
		 long time = dateFin.getTime();
		  
		  Timestamp endDate=new Timestamp(time); 
		  
		
		  projetDAO.updateProjetInfos(codeResponsable, code_projet, intitule, budget, avancement, statut, type, etat, endDate);
		
		
		
		
		request.setAttribute("id", adminId);
		
		try {
			showSuperAdminDashBoard(adminId, request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException
	{
		
		int adminId = Integer.parseInt(request.getParameter("idAdmin"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		String fonction = request.getParameter("fonction");
		
		userDAO.updateUserRoleFonction(fonction, id );
		
		request.setAttribute("id", adminId);
		
		Utilisateur userActuel = userDAO.selectUser(adminId);
		request.setAttribute("id", adminId);
		
		if(userActuel.isRole() == 1)
		{
			try {
				showAdminDashBoard(adminId, request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			try {
				showSuperAdminDashBoard(adminId, request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	
	private void activerUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException
	{
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		int adminId = Integer.parseInt(request.getParameter("adminId"));
		
		userDAO.ActivateUser(id);
		
		Utilisateur userActuel = userDAO.selectUser(adminId);
		request.setAttribute("id", adminId);
		
		if(userActuel.isRole() == 1)
		{
			try {
				showAdminDashBoard(adminId, request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			try {
				showSuperAdminDashBoard(adminId, request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		
	}
	

	private void suspendreTache(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException
	{
		
		String code_tc = request.getParameter("code_tc");
		
		int adminId = Integer.parseInt(request.getParameter("adminId"));
		
		tacheDAO.SuspendreTache(code_tc);
		
		try {
			showAdminDashBoard(adminId, request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	private void suspendreProjet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException
	{
		
		String code_proj = request.getParameter("code_tc");
		
		int adminId = Integer.parseInt(request.getParameter("adminId"));
		
		projetDAO.SuspendreProjet(code_proj);
		
		
		try {
			showSuperAdminDashBoard(adminId, request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	// Méthode qui permet de retirer une tache à un utilisateur
	
	private void retirerTache(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException
	{
		
		String code_tc = request.getParameter("code_tc");
		
		int adminId = Integer.parseInt(request.getParameter("adminId"));
		
		int ancienUserId = Integer.parseInt(request.getParameter("ancienUserId"));
		
		tacheDAO.RetirerTache(code_tc, ancienUserId, 0);
		
		try {
			showAdminDashBoard(adminId, request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	// Méthode de prise en compte du cv de Yvan
	private void cvYvan(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException
	{
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("yvancv.html");
		
		dispatcher.forward(request, response);

		
	}
	
	//Méthode de prise en compte du cv de KOUEMOU
	
	private void cvKOUEMOU(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException
	{
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("samantaCv.html");
		
		dispatcher.forward(request, response);

		
	}
	
	//Méthode de prise en compte du cv de MOUTEKE
	
	private void cvMOUTEKE(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException
	{
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("destinCv.html");
		
		dispatcher.forward(request, response);

		
	}
	
	//Méthode de prise qui est appeler lorsqu'on veut retirer le projet a un administrateur
	
	private void retirerProjet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException
	{
		
		String code_tc = request.getParameter("code_tc");
		
		int adminId = Integer.parseInt(request.getParameter("adminId"));
		
		int ancienUserId = Integer.parseInt(request.getParameter("ancienUserId"));
		
		projetDAO.RetirerProjet(code_tc, ancienUserId, 0);
		
		
		try {
			showSuperAdminDashBoard(adminId, request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	private void affecterTache(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException
	{
		
		String code_tc = request.getParameter("code");
		
		int adminId = Integer.parseInt(request.getParameter("idAdmin"));
		
		int codeResponsable = Integer.parseInt(request.getParameter("codeResponsable"));
		
		tacheDAO.AffecterTache(code_tc, codeResponsable);
		
		try {
			showAdminDashBoard(adminId, request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	private void affecterProjet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException
	{
		
		String code_tc = request.getParameter("code");
		
		int adminId = Integer.parseInt(request.getParameter("idAdmin"));
		
		int codeResponsable = Integer.parseInt(request.getParameter("codeResponsable"));
		
		projetDAO.AffecterProjet(code_tc, codeResponsable);
		
		
		try {
			showSuperAdminDashBoard(adminId, request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	private void annulerTache(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException
	{
		
		String code_tc = request.getParameter("code_tc");
		
		int adminId = Integer.parseInt(request.getParameter("adminId"));
		
		tacheDAO.AnnulerTache(code_tc);
		
		try {
			showAdminDashBoard(adminId, request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	private void annulerProjet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException
	{
		
		String code_proj = request.getParameter("code_tc");
		
		int adminId = Integer.parseInt(request.getParameter("adminId"));
		
		projetDAO.AnnulerProjet(code_proj);
		
		
		try {
			showSuperAdminDashBoard(adminId, request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	private void terminerTache(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException
	{
		
		String code_tc = request.getParameter("code_tc");
		
		int adminId = Integer.parseInt(request.getParameter("adminId"));
		
		
		tacheDAO.TerminerTache(code_tc);
		
		
		
		try {
			showSuperAdminDashBoard(adminId, request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	private void terminerProjet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException
	{
		
		String code_proj = request.getParameter("code_tc");
		
		int adminId = Integer.parseInt(request.getParameter("adminId"));
		
		projetDAO.TerminerProjet(code_proj);
		
		
		try {
			showSuperAdminDashBoard(adminId, request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	private void demarerTache(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException
	{
		
		String code_tc = request.getParameter("code_tc");
		
		int adminId = Integer.parseInt(request.getParameter("adminId"));
		
		tacheDAO.DemarerTache(code_tc);
		
		try {
			showAdminDashBoard(adminId, request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	private void demarerProjet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException
	{
		
		String code_projet = request.getParameter("code_tc");
		
		int adminId = Integer.parseInt(request.getParameter("adminId"));
		
		projetDAO.DemarerProjet(code_projet);
		
		
		try {
			showSuperAdminDashBoard(adminId, request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	private void desactiverUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException
	{
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		int adminId = Integer.parseInt(request.getParameter("adminId"));
		
		userDAO.DesactivateUser(id);
		
		Utilisateur userActuel = userDAO.selectUser(adminId);
		request.setAttribute("id", adminId);
		
		if(userActuel.isRole() == 1)
		{
			try {
				showAdminDashBoard(adminId, request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			try {
				showSuperAdminDashBoard(adminId, request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		
	}
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	

}
