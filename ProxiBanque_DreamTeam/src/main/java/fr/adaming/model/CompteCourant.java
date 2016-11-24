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
	 * @param decouvert
	 * @param client
	 * @param visaElectron
	 * @param visaPremium
	 */
	public CompteCourant(double decouvert, Client client, VisaElectron visaElectron, VisaPremium visaPremium) {
		super();
		this.decouvert = decouvert;
		this.client = client;
		this.visaElectron = visaElectron;
		this.visaPremium = visaPremium;
	}

	
	
	
	
	
}
