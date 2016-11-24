package fr.adaming.model;

import java.util.Date;

public class CompteEpargne extends Compte {


	private double tauxRenumeration;

	/**
	 * @param idCompte
	 * @param numeroCompte
	 * @param solde
	 * @param dateCreation
	 * @param tauxRenumeration
	 */
	public CompteEpargne(int idCompte, String numeroCompte, double solde, Date dateCreation, double tauxRenumeration) {
		super(idCompte, numeroCompte, solde, dateCreation);
		this.tauxRenumeration = tauxRenumeration;
	}

	/**
	 * @param numeroCompte
	 * @param solde
	 * @param dateCreation
	 * @param tauxRenumeration
	 */
	public CompteEpargne(String numeroCompte, double solde, Date dateCreation, double tauxRenumeration) {
		super(numeroCompte, solde, dateCreation);
		this.tauxRenumeration = tauxRenumeration;
	}

	/**
	 * 
	 */
	public CompteEpargne() {
		super();
	}

	/**
	 * @return the tauxRenumeration
	 */
	public double getTauxRenumeration() {
		return tauxRenumeration;
	}

	/**
	 * @param tauxRenumeration the tauxRenumeration to set
	 */
	public void setTauxRenumeration(double tauxRenumeration) {
		this.tauxRenumeration = tauxRenumeration;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompteEpargne [tauxRenumeration=" + tauxRenumeration + "]";
	}
	
}
