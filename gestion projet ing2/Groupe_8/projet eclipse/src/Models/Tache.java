package Models;

import java.sql.Timestamp;


public class Tache {
	
	private String code_tc;
	private String design_tc;
	private int coutunit_tc;
	private int avancement;
	private String statut;
	private boolean etat;
	private Timestamp date_debut;
	private Timestamp date_fin;
	
	private int idResponsable;
	
	private Utilisateur responsable;
	
	
	public Tache(int idResp, String code_tc, String design_tc, int coutunit_tc, int avancement, String status, boolean etat,
			Timestamp date_debut, Timestamp date_fin) {
		super();
		this.code_tc = code_tc;
		this.design_tc = design_tc;
		this.coutunit_tc = coutunit_tc;
		this.avancement = avancement;
		this.statut = status;
		this.etat = etat;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.idResponsable = idResp;
	}
	

	public Tache(String code_tc, String design_tc, int coutunit_tc, int avancement, String status, boolean etat,
			Timestamp date_debut, Timestamp date_fin) {
		super();
		this.code_tc = code_tc;
		this.design_tc = design_tc;
		this.coutunit_tc = coutunit_tc;
		this.avancement = avancement;
		this.statut = status;
		this.etat = etat;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		
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




	public void setStatut(String statut) {
		this.statut = statut;
	}




	public String getCode_tc() {
		return code_tc;
	}
	public void setCode_tc(String code_tc) {
		this.code_tc = code_tc;
	}
	public String getDesign_tc() {
		return design_tc;
	}
	public void setDesign_tc(String design_tc) {
		this.design_tc = design_tc;
	}
	public int getCoutunit_tc() {
		return coutunit_tc;
	}
	public void setCoutunit_tc(int coutunit_tc) {
		this.coutunit_tc = coutunit_tc;
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
	public void setStatutt(String status) {
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
