package fr.adaming.model;

import java.util.Date;

public class CompteCourant extends Compte{

	private int id;
	private double decouvert;
	
	//transormer la compotision entre le client et le compteCourant
	private Client client;

	//transormer la composition entre le compteCourant et la VisaElectron
	private VisaElectron visaElectron;
	

	//transormer la composition entre le compteCourant et la VisaPremium
	private VisaPremium visaPremium;


	/**
	 * @param numeroCompte
	 * @param solde
	 * @param dateCreation
	 * @param id
	 * @param decouvert
	 * @param client
	 * @param visaElectron
	 * @param visaPremium
	 */
	public CompteCourant(String numeroCompte, double solde, Date dateCreation, int id, double decouvert, Client client,
			VisaElectron visaElectron, VisaPremium visaPremium) {
		super(numeroCompte, solde, dateCreation);
		this.id = id;
		this.decouvert = decouvert;
		this.client = client;
		this.visaElectron = visaElectron;
		this.visaPremium = visaPremium;
	}


	/**
	 * @param numeroCompte
	 * @param solde
	 * @param dateCreation
	 * @param decouvert
	 * @param client
	 * @param visaElectron
	 * @param visaPremium
	 */
	public CompteCourant(String numeroCompte, double solde, Date dateCreation, double decouvert, Client client,
			VisaElectron visaElectron, VisaPremium visaPremium) {
		super(numeroCompte, solde, dateCreation);
		this.decouvert = decouvert;
		this.client = client;
		this.visaElectron = visaElectron;
		this.visaPremium = visaPremium;
	}


	/**
	 * @param numeroCompte
	 * @param solde
	 * @param dateCreation
	 */
	public CompteCourant(String numeroCompte, double solde, Date dateCreation) {
		super(numeroCompte, solde, dateCreation);
	}
	
	/* getters et setters*/
	
	
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
	 * @return the decouvert
	 */
	public double getDecouvert() {
		return decouvert;
	}


	/**
	 * @param decouvert the decouvert to set
	 */
	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
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


	/**
	 * @return the visaElectron
	 */
	public VisaElectron getVisaElectron() {
		return visaElectron;
	}


	/**
	 * @param visaElectron the visaElectron to set
	 */
	public void setVisaElectron(VisaElectron visaElectron) {
		this.visaElectron = visaElectron;
	}


	/**
	 * @return the visaPremium
	 */
	public VisaPremium getVisaPremium() {
		return visaPremium;
	}


	/**
	 * @param visaPremium the visaPremium to set
	 */
	public void setVisaPremium(VisaPremium visaPremium) {
		this.visaPremium = visaPremium;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompteCourant [id=" + id + ", decouvert=" + decouvert + ", client=" + client + ", visaElectron="
				+ visaElectron + ", visaPremium=" + visaPremium + "]";
	}

	
}
