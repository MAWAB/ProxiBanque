package fr.adaming.model;



public abstract class Compte {

	
	protected String numeroCompte;
	protected double solde;

	
	
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
	 */
	public Compte(String numeroCompte, double solde) {
		super();
		this.numeroCompte = numeroCompte;
		this.solde = solde;
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


	
	
}
