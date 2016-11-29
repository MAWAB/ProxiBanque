package fr.adaming.managedBeans;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;
import org.primefaces.event.MenuActionEvent;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.adaming.model.Adresse;
import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Gerant;
import fr.adaming.service.IClientService;
import fr.adaming.service.IConseillerService;

@ManagedBean(name = "gerantMB")
@SessionScoped
public class GerantManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** atrtibuts session */
	HttpSession session;

	/** attributs gerant */
	private Gerant gerant;
	private String nom;
	private String password;

	/** attributs conseiller */
	@ManagedProperty(value = "#{conseillerService}")
	IConseillerService conseillerService;

	private Conseiller conseiller;
	private Adresse adresse;
	private List<Conseiller> listeConseiller;

	/** attributs clients */
	@ManagedProperty(value = "#{clientServiceImpl}")
	IClientService clientService;

	private Client client;
	private List<Client> listeClient;

	/** attributs comptes */

	/** attributs cartes */

	/** attributs supplémentaires */
	MenuModel menulisteConseillerLess10Clients;
	MenuModel menulisteAllConseiller;
	MenuModel menulisteClientAModifier;

	/** Constructeur vide */

	public GerantManagedBean() {
		this.conseiller = new Conseiller();
		this.client = new Client();
		this.gerant = new Gerant();
		this.adresse = new Adresse();
	}

	/** Getters & Setters */
	public IConseillerService getConseillerService() {
		return conseillerService;
	}

	public void setConseillerService(IConseillerService conseillerService) {
		this.conseillerService = conseillerService;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public List<Conseiller> getListeConseiller() {
		return listeConseiller;
	}

	public void setListeConseiller(List<Conseiller> listeConseiller) {
		this.listeConseiller = listeConseiller;
	}

	public IClientService getClientService() {
		return clientService;
	}

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Client> getListeClient() {
		return listeClient;
	}

	public void setListeClient(List<Client> listeClient) {
		this.listeClient = listeClient;
	}

	public Gerant getGerant() {
		return gerant;
	}

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse
	 *            the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the menulisteConseillerLess10Clients
	 */
	public MenuModel getMenulisteConseillerLess10Clients() {
		return menulisteConseillerLess10Clients;
	}

	/**
	 * @param menulisteConseillerLess10Clients
	 *            the menulisteConseillerLess10Clients to set
	 */
	public void setMenulisteConseillerLess10Clients(MenuModel menulisteConseillerLess10Clients) {
		this.menulisteConseillerLess10Clients = menulisteConseillerLess10Clients;
	}

	/**
	 * @return the menulisteAllConseiller
	 */
	public MenuModel getMenulisteAllConseiller() {
		return menulisteAllConseiller;
	}

	/**
	 * @param menulisteAllConseiller
	 *            the menulisteAllConseiller to set
	 */
	public void setMenulisteAllConseiller(MenuModel menulisteAllConseiller) {
		this.menulisteAllConseiller = menulisteAllConseiller;
	}

	/**
	 * @return the menulisteClientAModifier
	 */
	public MenuModel getMenulisteClientAModifier() {
		return menulisteClientAModifier;
	}

	/**
	 * @param menulisteClientAModifier the menulisteClientAModifier to set
	 */
	public void setMenulisteClientAModifier(MenuModel menulisteClientAModifier) {
		this.menulisteClientAModifier = menulisteClientAModifier;
	}

	/** autres méthodes */
	
	/**
	 * init: chargement de toutes les listes : il faudra utiliser les méthodes
	 * en commentaires une fois la fonction login réalisée
	 */
	@PostConstruct
	public void init() {

		// listeConseiller =
		// conseillerService.getConseillerByAgenceService(conseiller.getGerant().getAgence().getIdAgence());
		// listeClient =
		// clientService.getAllClientsByIdAgenceService(client.getConseiller().getGerant().getAgence().getIdAgence());
		client = new Client();
		conseiller = new Conseiller();
		gerant = (Gerant) conseillerService.getConseillerByIdService(1);
		listeConseiller = conseillerService.getAllConseillerService();
		listeClient = clientService.getAllClientsService();
		FacesContext fc = FacesContext.getCurrentInstance();
		session = (HttpSession) fc.getExternalContext().getSession(false);
		menulisteConseillerLess10Clients = new DefaultMenuModel();
		menulisteAllConseiller = new DefaultMenuModel();
		menulisteClientAModifier = new DefaultMenuModel();

	}

	/** Deconnexion */

	public String seDeconnecter() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "accueilGerant";
	}

	/** CRUD conseiller */

	/**
	 * Récupérer un conseiller par son ID
	 * Renvoie vers l'accueil Gérant
	 */
	public String getConseillerById() {
		conseillerService.getConseillerByIdService(conseiller.getIdConseiller());
		// listeConseiller =
		// conseillerService.getConseillerByAgenceService(conseiller.getGerant().getAgence().getIdAgence());
		listeConseiller = conseillerService.getAllConseillerService();
		return "accueilGerant.xhtml";
	}

	/**
	 * Ajouter un conseiller
	 * Renvoie vers l'accueil gérant
	 */
	public String ajouterConseiller() {
		conseiller.setGerant(gerant);
		conseiller.setAdresse(adresse);
		conseiller.setListeClients(listeClient);
		conseillerService.addConseillerService(conseiller);
		// listeConseiller =
		// conseillerService.getConseillerByAgenceService(conseiller.getGerant().getAgence().getIdAgence());
		listeConseiller = conseillerService.getAllConseillerService();
		return "accueilGerant.xhtml";

	}

	/**
	 * Modifier un conseiller
	 * Réactualise la page accueil gérant
	 * @throws IOException
	 */
	public void modifierConseiller() throws IOException {
		conseiller = conseillerService.getConseillerByIdService(conseiller.getIdConseiller());
		conseillerService.updateConseillerService(conseiller);
		// listeConseiller =
		// conseillerService.getConseillerByAgenceService(conseiller.getGerant().getAgence().getIdAgence());
		listeConseiller = conseillerService.getAllConseillerService();
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
	}

	/**
	 * Supprimer un conseiller depuis la page d'accueil du gérant
	 * Réactualise la page
	 */
	public String supprimerConseiller() {
		conseillerService.deleteConseillerService(conseiller);
		// listeConseiller =
		// conseillerService.getConseillerByAgenceService(conseiller.getGerant().getAgence().getIdAgence());
		listeConseiller = conseillerService.getAllConseillerService();
		return "accueilGerant.xhtml";
	}

	/** CRUD client */

	/**
	 * Récupérer un client par son Id
	 * Renvoie vers la page d'accueil du gérant
	 */
	public String getClientById() {
		clientService.getClientByIdService(client.getIdClient());
		// listeClient =
		// clientService.getAllClientsByIdAgenceService(client.getConseiller().getGerant().getAgence().getIdAgence());
		listeClient = clientService.getAllClientsService();
		return "accueilGerant.xhtml";
	}

	/**
	 * Ajouter un client
	 * Renvoie vers la page d'accueil du gérant
	 */
	public String ajouterClient() {
		client.setConseiller(conseiller);
		clientService.addClientService(client);
		// listeClient =
		// clientService.getAllClientsByIdAgenceService(client.getConseiller().getGerant().getAgence().getIdAgence());
		listeClient = clientService.getAllClientsService();
		return "accueilGerant.xhtml";
	}

	/**
	 * Modifier un client
	 * Renvoie vers la page d'accueil du gérant
	 */
	public String modifierClient() {
		clientService.updateClientService(client);
		// listeClient =
		// clientService.getAllClientsByIdAgenceService(client.getConseiller().getGerant().getAgence().getIdAgence());
		listeClient = clientService.getAllClientsService();
		return "accueilGerant.xhtml";
	}

	/**
	 * Supprimer un client depuis la page d'accueil du gérant
	 * Réactualise la page d'accueil
	 */
	public String supprimerClient() {
		clientService.deleteClientService(client.getIdClient());
		// listeClient =
		// clientService.getAllClientsByIdAgenceService(client.getConseiller().getGerant().getAgence().getIdAgence());
		listeClient = clientService.getAllClientsService();
		return "accueilGerant.xhtml";
	}


	/**
	 * Sélectionner le conseiller à ajouter au client
	 * @param event
	 * @throws IOException
	 */
	public void selectionConseiller(ActionEvent event) throws IOException {

		DefaultMenuItem menuItem = (DefaultMenuItem) ((MenuActionEvent) event).getMenuItem();
		int id = Integer.parseInt(menuItem.getParams().get("id_conseiller").get(0));
		conseiller = conseillerService.getConseillerByIdService(id);
		client.setConseiller(conseiller);
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
	}

	/**
	 * Créer un menu déroulant contenant tous les conseillers avec moins de 10 clients
	 */
	public void creationMenuSelectionConseillerWithLess10Clients() {
		
		menulisteConseillerLess10Clients = new DefaultMenuModel();
		DefaultSubMenu submenu = new DefaultSubMenu("Sélection du conseiller");
		DefaultMenuItem item;

		List<Conseiller> conseillerList = conseillerService.getConseillerWithLess10ClientByAgenceService(1);

		for (int i = 0; i < conseillerList.size(); i++) {
			item = new DefaultMenuItem("Id : " + conseillerList.get(i).getIdConseiller() + ", Nom : "
					+ conseillerList.get(i).getNom() + ", Prénom : " + conseillerList.get(i).getPrenom());
			item.setCommand("#{gerantMB.selectionConseiller}");
			item.setParam("id_conseiller", conseillerList.get(i).getIdConseiller());
			submenu.addElement(item);
		}
		menulisteConseillerLess10Clients.addElement(submenu);
	}
	
	/**
	 * Créer un menu déroulant avec tous les clients
	 */
	public void creationMenuSelectionClientAModifier() {
		menulisteClientAModifier = new DefaultMenuModel();
		DefaultSubMenu submenu = new DefaultSubMenu("Sélection du client");
		DefaultMenuItem item;

		for (int i = 0; i < listeClient.size(); i++) {
			item = new DefaultMenuItem("Id : " + listeClient.get(i).getIdClient() + ", Nom : "
					+ listeClient.get(i).getNom() + ", Prénom : " + listeClient.get(i).getPrenom());
			item.setParam("id_client", listeClient.get(i).getIdClient());
			item.setCommand("#{gerantMB.selectionClientAModifier}");
			submenu.addElement(item);
		}
		menulisteClientAModifier.addElement(submenu);
	}

	/**
	 * Sélectionner le client dans le menu déroulant
	 * @param event
	 * @throws IOException
	 */
	public void selectionClientAModifier(ActionEvent event) throws IOException {

		DefaultMenuItem menuItem = (DefaultMenuItem) ((MenuActionEvent) event).getMenuItem();
		int id = Integer.parseInt(menuItem.getParams().get("id_client").get(0));
		client = clientService.getClientByIdService(id);
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
	}
	
	/** Navigation */

	public String navigationInformationclient() {
		session.setAttribute("client", clientService.getClientByIdService(this.client.getIdClient()));
		return "infosClientsGerant.xhtml";
	}

	public String navigationVersAjoutClient() {
		client = new Client();
		conseiller = new Conseiller();
		creationMenuSelectionConseillerWithLess10Clients();
		return "ajoutClientGerant";
	}

	public String navigationVersAccueil() {
		client = new Client();
		return "accueilGerant";
	}

	public String navigationModificationClient() {
		client = new Client();
		creationMenuSelectionClientAModifier();
		return "modifClientGerant";
	}

	public String navigationSuppressionClient() {
		client = new Client();
		creationMenuSelectionClientAModifier();
		return "suppClientGerant";
	}

	public String navigationVersAjoutConseiller() {
		conseiller = new Conseiller();
		creationMenuSelectionConseillerWithLess10Clients();
		return "ajoutConseiller";
	}

	public String navigationVersListeClients() {
		listeClient = clientService.getAllClientsByIdAgenceService(1);
		return "listeClients";
	}
}
