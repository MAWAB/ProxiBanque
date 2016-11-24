package fr.adaming.model;

import java.util.Date;

public class CompteCourant extends Compte{

	private double decouvert;
	//transormer la compotision entre le client et le compteCourant
	private Client client;

	//transormer la composition entre le compteCourant et la VisaElectron
	private VisaElectron visaElectron;
	
	//transormer la composition entre le compteCourant et la VisaPremium
	private VisaPremium visaPremium;

	/**
	 * @param idCompte
	 * @param numeroCompte
	 * @param solde
	 * @param dateCreation
	 * @param decouvert
	 * @param client
	 * @param visaElectron
	 * @param visaPremium
	 */
	public CompteCourant(int idCompte, String numeroCompte, double solde, Date dateCreation, double decouvert,
			Client client, VisaElectron visaElectron, VisaPremium visaPremium) {
		super(idCompte, numeroCompte, solde, dateCreation);
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
	 * 
	 */
	public CompteCourant() {
		super();
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


	
	
	
	
}
