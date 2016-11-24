package fr.adaming.model;

import java.util.Date;

public class CompteEpargne extends Compte {

	private int id;
	private double tauxRenumeration;
	
	/* constructeur */
	
	//transormer la compotision entre le client et le compteEpargne
	private Client client;

	/**
	 * @param numeroCompte
	 * @param solde
	 * @param dateCreation
	 * @param id
	 * @param tauxRenumeration
	 * @param client
	 */
	public CompteEpargne(String numeroCompte, double solde, Date dateCreation, int id, double tauxRenumeration,
			Client client) {
		super(numeroCompte, solde, dateCreation);
		this.id = id;
		this.tauxRenumeration = tauxRenumeration;
		this.client = client;
	}

	/**
	 * @param numeroCompte
	 * @param solde
	 * @param dateCreation
	 * @param tauxRenumeration
	 * @param client
	 */
	public CompteEpargne(String numeroCompte, double solde, Date dateCreation, double tauxRenumeration, Client client) {
		super(numeroCompte, solde, dateCreation);
		this.tauxRenumeration = tauxRenumeration;
		this.client = client;
	}

	/**
	 * @param numeroCompte
	 * @param solde
	 * @param dateCreation
	 */
	public CompteEpargne(String numeroCompte, double solde, Date dateCreation) {
		super(numeroCompte, solde, dateCreation);
	}
	
	/* méthodes */

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

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompteEpargne [id=" + id + ", tauxRenumeration=" + tauxRenumeration + ", client=" + client + "]";
	}
	
	
	
	
}
