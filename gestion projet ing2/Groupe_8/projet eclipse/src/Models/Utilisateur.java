package Models;

public class Utilisateur {
		
	 private int id;
	 private String nom;
	 private String prenom;
	 private String fonction;
	 private String login;
	 private String pwd;
	 private int role;
	 private boolean statut;
	 private boolean isFirstConnection;
	 private int createdBy;
	 
	 
	public Utilisateur(int id, String nom, String prenom, String fonction, String login, String pwd, int role,
			boolean statut, boolean isFirstConnection, int createdBy) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.fonction = fonction;
		this.login = login;
		this.pwd = pwd;
		this.role = role;
		this.statut = statut;
		this.isFirstConnection = isFirstConnection;
		this.createdBy = createdBy;
	}
	
	
	
	public Utilisateur(String nom, String prenom, String fonction, String login, String pwd, int role,
			boolean statut, boolean isFirstConnection, int createdBy) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.fonction = fonction;
		this.login = login;
		this.pwd = pwd;
		this.role = role;
		this.statut = statut;
		this.isFirstConnection = isFirstConnection;
		this.createdBy = createdBy;
	}

	
	public int getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}



	public boolean isFirstConnection() {
		return isFirstConnection;
	}


	public void setFirstConnection(boolean isFirstConnection) {
		this.isFirstConnection = isFirstConnection;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getFonction() {
		return fonction;
	}


	public void setFonction(String fonction) {
		this.fonction = fonction;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public int isRole() {
		return role;
	}


	public void setRole(int role) {
		this.role = role;
	}


	public boolean isStatut() {
		return statut;
	}


	public void setStatut(boolean statut) {
		this.statut = statut;
	}
	
	
	 
	 
	 

}
