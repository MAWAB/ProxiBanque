package fr.adaming.model;

import java.util.Date;

public class Agence {

	private int idAgence;
	private String nom;
	private Date dateCreation;
	private Gerant gerant;
	private String numeroAgence;
	
	
	/* constructeurs*/
	
	
	/**
	 * @param idAgence
	 * @param nom
	 * @param dateCreation
	 * @param gerant
	 * @param numeroAgence
	 */
	public Agence(int idAgence, String nom, Date dateCreation, Gerant gerant, String numeroAgence) {
		super();
		this.idAgence = idAgence;
		this.nom = nom;
		this.dateCreation = dateCreation;
		this.gerant = gerant;
		this.numeroAgence = numeroAgence;
	}
	/**
	 * @param nom
	 * @param dateCreation
	 * @param gerant
	 * @param numeroAgence
	 */
	public Agence(String nom, Date dateCreation, Gerant gerant, String numeroAgence) {
		super();
		this.nom = nom;
		this.dateCreation = dateCreation;
		this.gerant = gerant;
		this.numeroAgence = numeroAgence;
	}
	/**
	 * 
	 */
	public Agence() {
		super();
	}
	/* méthodes */
	
	/**
	 * @return the idAgence
	 */
	public int getIdAgence() {
		return idAgence;
	}
	/**
	 * @param idAgence the idAgence to set
	 */
	public void setIdAgence(int idAgence) {
		this.idAgence = idAgence;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the dateCreation
	 */
	public Date getDateCreation() {
		return dateCreation;
	}
	/**
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	/**
	 * @return the gerant
	 */
	public Gerant getGerant() {
		return gerant;
	}
	/**
	 * @param gerant the gerant to set
	 */
	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}
	/**
	 * @return the numeroAgence
	 */
	public String getNumeroAgence() {
		return numeroAgence;
	}
	/**
	 * @param numeroAgence the numeroAgence to set
	 */
	public void setNumeroAgence(String numeroAgence) {
		this.numeroAgence = numeroAgence;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Agence [idAgence=" + idAgence + ", nom=" + nom + ", dateCreation=" + dateCreation + ", gerant=" + gerant
				+ ", numeroAgence=" + numeroAgence + "]";
	}


	
}