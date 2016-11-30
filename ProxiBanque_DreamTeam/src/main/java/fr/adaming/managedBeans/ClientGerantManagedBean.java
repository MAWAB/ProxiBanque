/**
 * 
 */
package fr.adaming.managedBeans;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Carte;
import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.VisaElectron;
import fr.adaming.model.VisaPremium;
import fr.adaming.service.ICarteService;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICompteService;

/**
 * @author inti0302
 *
 */
@ManagedBean(name = "clientGerantMB")
@ViewScoped
public class ClientGerantManagedBean implements Serializable {

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
	private String adresse;

	private CompteCourant compteCourant;
	private double somme;

	HttpSession session;

	/**
	 * 
	 */
	public ClientGerantManagedBean() {
		super();
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
	 * @param clientService
	 *            the clientService to set
	 */
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	/**
	 * @return the compteService
	 */
	public ICompteService<Compte> getCompteService() {
		return compteService;
	}

	/**
	 * @param compteService
	 *            the compteService to set
	 */
	public void setCompteService(ICompteService<Compte> compteService) {
		this.compteService = compteService;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse
	 *            the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
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

	public ICarteService<Carte> getCarteService() {
		return carteService;
	}

	public void setCarteService(ICarteService<Carte> carteService) {
		this.carteService = carteService;
	}

	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		session = (HttpSession) facesContext.getExternalContext().getSession(false);

		this.client = (Client) session.getAttribute("client");
		this.adresse = "Rue " + this.client.getAdresse().getRue() + ", " + this.client.getAdresse().getCodePostal()
				+ " " + this.client.getAdresse().getVille();
	}

	public String navigationAjoutCompteC() {
		session.setAttribute("client", clientService.getClientByIdService(this.client.getIdClient()));
		return "ajoutCCGerant.xhtml";
	}

	public String navigationAjoutCompteEp() {
		session.setAttribute("client", clientService.getClientByIdService(this.client.getIdClient()));
		return "ajoutCEGerant.xhtml";
	}

	public void retirer() throws IOException {

		compteCourant = client.getCompteCourant();
		compteService.retraitService(compteCourant, somme);
		client.setCompteCourant(compteCourant);
		//clientService.updateClientService(client);

		this.client = clientService.getClientByIdService(client.getIdClient());
		session.setAttribute("client", client);
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());

	}

	public String deposer() throws IOException {

		compteCourant = client.getCompteCourant();
		compteService.depotService(compteCourant, somme);
		client.setCompteCourant(compteCourant);
		//clientService.updateClientService(client);

		this.client = clientService.getClientByIdService(client.getIdClient());
		session.setAttribute("client", client);
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
		this.client = (Client) session.getAttribute("client");

		return "infosClientsGerant.xhtml";
	}

	public String navigationPatrimoine() {
		session.setAttribute("fondInsuff", false);
		session.setAttribute("client", this.client);
		return "patrimoine.xhtml";
	}

	public String navigationVirement() {
		session.setAttribute("client", this.client);
		return "virementRechercheCmpGerant.xhtml";
	}

	public String navigationInfoCartes() {
		session.setAttribute("client", this.client);
		return "ajoutCarteGerant.xhtml";
	}

	public void supprimerCarteElectron() throws IOException {

		VisaElectron vp = (VisaElectron) carteService.getCarteByIdService(client.getCompteCourant().getVisaElectron());

		vp.setCompteCourant(null);
		carteService.modifierCarteService(vp);

		carteService.supprimerCarteService(vp);

		this.client = clientService.getClientByIdService(client.getIdClient());
		session.setAttribute("client", client);
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
	}

	public void supprimerCartePremium() throws IOException {

		VisaPremium vp = (VisaPremium) carteService.getCarteByIdService(client.getCompteCourant().getVisaPremium());

		vp.setCompteCourant(null);
		carteService.modifierCarteService(vp);

		carteService.supprimerCarteService(vp);

		this.client = clientService.getClientByIdService(client.getIdClient());
		session.setAttribute("client", client);
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
	}
}
