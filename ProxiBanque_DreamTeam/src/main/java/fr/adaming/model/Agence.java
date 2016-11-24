package fr.adaming.model;

import java.util.Date;

public class Agence {

	private int id;
	private String nom;
	private Date dateCreation;
	private Gerant gerant;
	
	
	/* constructeurs */
	
	
	/**
	 * @param id
	 * @param nom
	 * @param dateCreation
	 * @param gerant
	 */
	public Agence(int id, String nom, Date dateCreation, Gerant gerant) {
		super();
		this.id = id;
		this.nom = nom;
		this.dateCreation = dateCreation;
		this.gerant = gerant;
	}
	/**
	 * @param nom
	 * @param dateCreation
	 * @param gerant
	 */
	public Agence(String nom, Date dateCreation, Gerant gerant) {
		super();
		this.nom = nom;
		this.dateCreation = dateCreation;
		this.gerant = gerant;
	}
	/**
	 * 
	 */
	public Agence() {
		super();
	}
	/* getters et setters */
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Agence [id=" + id + ", nom=" + nom + ", dateCreation=" + dateCreation + ", gerant=" + gerant + "]";
	}
	

	
}