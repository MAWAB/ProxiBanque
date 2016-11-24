package fr.adaming.model;

import java.util.Date;

public abstract class Personne {
	protected String nom;
	protected String prenom;
	protected Date dateDeNaissance;
	protected Adresse adresse;
	
	
	
	
	/**
	 * 
	 */
	public Personne() {
		super();
	}
	/**
	 * @param nom
	 * @param prenom
	 * @param dateDeNaissance
	 * @param adresse
	 */
	public Personne(String nom, String prenom, Date dateDeNaissance, Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.adresse = adresse;
	}
	/* getters et setters */
	
	
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
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the dateDeNaissance
	 */
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	/**
	 * @param dateDeNaissance the dateDeNaissance to set
	 */
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", dateDeNaissance=" + dateDeNaissance + "]";
	}
	
	
	
}