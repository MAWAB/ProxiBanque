package fr.adaming.model;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public abstract class Compte {

	
	protected String numeroCompte;
	protected double solde;
	
	@Temporal(TemporalType.DATE)
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
