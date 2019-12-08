package Models;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Projet {
	
	private String code_projet;
	private String lib_proj;
	private int budget_proj;
	private String type_projet;
	private int avancement;
	private String statut;
	private boolean etat;
	private Timestamp date_debut;
	private Timestamp date_fin;
	
	private int idResponsable;
	
	private Utilisateur responsable;
	
	private ArrayList<Tache> listeTachesAffecter;
	
	private ArrayList<Tache> listeTachesNonAffecter;
	
	
	public Projet(String code_projet, String lib_proj, int budget, String type_projet, int avancement,
			String status, boolean etat, Timestamp date_debut, Timestamp date_fin) {
		super();
		this.code_projet = code_projet;
		this.lib_proj = lib_proj;
		this.budget_proj = budget;
		this.type_projet = type_projet;
		this.avancement = avancement;
		this.statut = status;
		this.etat = etat;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		
		listeTachesAffecter = new ArrayList<Tache>();
		listeTachesNonAffecter = new ArrayList<Tache>();
	}
	
	public Projet(int idResponsable, String code_projet, String lib_proj, int budget, String type_projet, int avancement,
			String status, boolean etat, Timestamp date_debut, Timestamp date_fin) {
		super();
		this.code_projet = code_projet;
		this.lib_proj = lib_proj;
		this.budget_proj = budget;
		this.type_projet = type_projet;
		this.avancement = avancement;
		this.statut = status;
		this.etat = etat;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.idResponsable = idResponsable;
		
		listeTachesAffecter = new ArrayList<Tache>();
		listeTachesNonAffecter = new ArrayList<Tache>();
	}
	




	public int getIdResponsable() {
		return idResponsable;
	}





	public void setIdResponsable(int idResponsable) {
		this.idResponsable = idResponsable;
	}





	public Utilisateur getResponsable() {
		return responsable;
	}





	public void setResponsable(Utilisateur responsable) {
		this.responsable = responsable;
	}





	public ArrayList<Tache> getListeTachesAffecter() {
		return listeTachesAffecter;
	}


	public void setListeTachesAffecter(ArrayList<Tache> listeTachesAffecter) {
		this.listeTachesAffecter = listeTachesAffecter;
	}

	public ArrayList<Tache> getListeTachesNonAffecter() {
		return listeTachesNonAffecter;
	}

	public void setListeTachesNonAffecter(ArrayList<Tache> listeTachesNonAffecter) {
		
		this.listeTachesNonAffecter = listeTachesNonAffecter;
	}





	public String getCode_projet() {
		return code_projet;
	}
	public void setCode_projet(String code_projet) {
		this.code_projet = code_projet;
	}
	public String getLib_proj() {
		return lib_proj;
	}
	public void setLib_proj(String lib_proj) {
		this.lib_proj = lib_proj;
	}
	public int getBudget_proj() {
		return budget_proj;
	}
	public void setBudget_proj(int budget_proj) {
		this.budget_proj = budget_proj;
	}
	public String getType_projet() {
		return type_projet;
	}
	public void setType_projet(String type_projet) {
		this.type_projet = type_projet;
	}
	public int getAvancement() {
		return avancement;
	}
	public void setAvancement(int avancement) {
		this.avancement = avancement;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String status) {
		this.statut = status;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public Timestamp getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Timestamp date_debut) {
		this.date_debut = date_debut;
	}
	public Timestamp getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Timestamp date_fin) {
		this.date_fin = date_fin;
	}
	
	

}
