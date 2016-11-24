package fr.adaming.model;

import java.util.Date;

public abstract class Compte {

	protected int idCompte;
	protected String numeroCompte;
	protected double solde;
	protected Date dateCreation;
	
	
	/* constructeurs */
	
	/**
	 * 
	 */
	public Compte() {
		super();
	}
	/**
	 * @param numeroCompte
	 * @param solde
	 * @param dateCreation
	 */
	public Compte(String numeroCompte, double solde, Date dateCreation) {
		super();
		this.numeroCompte = numeroCompte;
		this.solde = solde;
		this.dateCreation = dateCreation;
	}
	/* getters et setters */
	
	
	/**
	 * @param idCompte
	 * @param numeroCompte
	 * @param solde
	 * @param dateCreation
	 */
	public Compte(int idCompte, String numeroCompte, double solde, Date dateCreation) {
		super();
		this.idCompte = idCompte;
		this.numeroCompte = numeroCompte;
		this.solde = solde;
		this.dateCreation = dateCreation;
	}
	/**
	 * @return the idCompte
	 */
	public int getIdCompte() {
		return idCompte;
	}
	/**
	 * @param idCompte the idCompte to set
	 */
	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}
	/**
	 * @return the numeroCompte
	 */
	public String getNumeroCompte() {
		return numeroCompte;
	}
	/**
	 * @param numeroCompte the numeroCompte to set
	 */
	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}
	/**
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}
	/**
	 * @param solde the solde to set
	 */
	public void setSolde(double solde) {
		this.solde = solde;
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

	

}
