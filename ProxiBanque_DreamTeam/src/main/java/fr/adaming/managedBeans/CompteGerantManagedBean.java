package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Carte;
import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.CompteEpargne;
import fr.adaming.model.VisaElectron;
import fr.adaming.model.VisaPremium;
import fr.adaming.service.ICarteService;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICompteService;

@ManagedBean(name = "compteGerantMB")
@ViewScoped
public class CompteGerantManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{clientServiceImpl}")
	IClientService clientService;

	@ManagedProperty(value = "#{cmpServiceBean}")
	ICompteService<Compte> compteService;

	@ManagedProperty(value = "#{carteService}")
	ICarteService<Carte> carteService;

	private Client client;
	private CompteEpargne compteEpargne;
	private CompteCourant compteCourant;
	private int carte = 0;
	private VisaElectron visaElectron;
	private VisaPremium visaPremium;
	private double somme = 0;

	HttpSession session;

	// Getters & Setters
	// ------------------------------------------------------------------------------------

	/**
	 * @return the compteService
	 */
	public ICompteService<Compte> getCompteService() {
		return compteService;
	}

	public IClientService getClientService() {
		return clientService;
	}

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	/**
	 * @param compteService
	 *            the compteService to set
	 */
	public void setCompteService(ICompteService<Compte> compteService) {
		this.compteService = compteService;
	}

	/**
	 * @return the carteService
	 */
	public ICarteService<Carte> getCarteService() {
		return carteService;
	}

	/**
	 * @param carteService
	 *            the carteService to set
	 */
	public void setCarteService(ICarteService<Carte> carteService) {
		this.carteService = carteService;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the compteEpargne
	 */
	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}

	/**
	 * @param compteEpargne
	 *            the compteEpargne to set
	 */
	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}

	/**
	 * @return the compteCourant
	 */
	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	/**
	 * @param compteCourant
	 *            the compteCourant to set
	 */
	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

	/**
	 * @return the carte
	 */
	public int getCarte() {
		return carte;
	}

	/**
	 * @param carte
	 *            the carte to set
	 */
	public void setCarte(int carte) {
		this.carte = carte;
	}

	/**
	 * @return the visaElectron
	 */
	public VisaElectron getVisaElectron() {
		return visaElectron;
	}

	/**
	 * @param visaElectron
	 *            the visaElectron to set
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
	 * @param visaPremium
	 *            the visaPremium to set
	 */
	public void setVisaPremium(VisaPremium visaPremium) {
		this.visaPremium = visaPremium;
	}

	/**
	 * @return the somme
	 */
	public double getSomme() {
		return somme;
	}

	/**
	 * @param somme
	 *            the somme to set
	 */
	public void setSomme(double somme) {
		this.somme = somme;
	}

	// Init
	// ------------------------------------------------------------------------------------------------------------
	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		session = (HttpSession) facesContext.getExternalContext().getSession(false);
		this.client = (Client) session.getAttribute("client");

		this.compteCourant = new CompteCourant();
		this.compteEpargne = new CompteEpargne();
		this.visaElectron = new VisaElectron();
		this.visaPremium = new VisaPremium();
	}

	// Constructeur vide
	// -----------------------------------------------------------------------------------------------
	public CompteGerantManagedBean() {
		super();
	}

	// Méthodes
	// --------------------------------------------------------------------------------------------------------

	public String addCompteEpargne() {

		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 1);
		Date date = c.getTime();
		compteEpargne.setDateCreation(date);
		compteEpargne.setSolde(0);
		compteEpargne.setClient(client);

		compteService.ajouterCompteService(compteEpargne);
		client.setCompteEpargne(compteEpargne);

		return "infosClientsGerant.xhtml";
	}

	public String addCompteCourant() {

		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 1);
		Date dateJour = c.getTime();

		compteCourant.setDateCreation(dateJour);
		compteCourant.setSolde(0);
		compteCourant.setClient(client);
		compteService.ajouterCompteService(compteCourant);

		if (carte == 1) {

			visaElectron.setActive(true);
			carteService.ajouterCarteService(visaElectron);
			visaElectron.setCompteCourant(compteCourant);
			carteService.modifierCarteService(visaElectron);

		} else if (carte == 2) {

			visaPremium.setActive(true);
			carteService.ajouterCarteService(visaPremium);
			visaPremium.setCompteCourant(compteCourant);
			carteService.modifierCarteService(visaPremium);
		}

		compteService.modifierCompteService(compteCourant);
		Client cl = clientService.getClientByIdService(client.getIdClient());
		session.setAttribute("client", cl);
		return "infosClientsGerant.xhtml";
	}

	public String deleteCompte() {

		return "infosClientsGerant.xhtml";
	}

	public String retirer() {

		compteService.retraitService(client.getCompteCourant(), somme);
		return "infosClientsGerant.xhtml";
	}

	public String deposer() {

		compteService.depotService(client.getCompteCourant(), somme);
		return "infosClientsGerant.xhtml";
	}
	
	public String addCarte() {
		
		if (carte == 0) {

			visaElectron.setActive(true);
			carteService.ajouterCarteService(visaElectron);
			visaElectron.setCompteCourant(this.client.getCompteCourant());
			carteService.modifierCarteService(visaElectron);

		} else if (carte == 1) {

			visaPremium.setActive(true);
			carteService.ajouterCarteService(visaPremium);
			visaPremium.setCompteCourant(this.client.getCompteCourant());
			carteService.modifierCarteService(visaPremium);
		}

		compteService.modifierCompteService(this.client.getCompteCourant());
		Client cl = clientService.getClientByIdService(client.getIdClient());
		session.setAttribute("client", cl);
		return "infosClientsGerant.xhtml";
	}
	
	

}
