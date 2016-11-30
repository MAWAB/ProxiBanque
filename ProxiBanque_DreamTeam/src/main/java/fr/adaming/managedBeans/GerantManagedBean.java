package fr.adaming.managedBeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.primefaces.event.MenuActionEvent;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import fr.adaming.model.Adresse;
import fr.adaming.model.Agence;
import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.CompteEpargne;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Gerant;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICompteService;
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
	private Agence agence;

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
	@ManagedProperty(value="#{cmpServiceBean}")
	ICompteService<Compte> compteService;
	private List<Compte> listeCompte;
	
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
		this.agence = new Agence();
	}

	/** Getters & Setters */
	

	
	
	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @return the agence
	 */
	public Agence getAgence() {
		return agence;
	}

	/**
	 * @param agence the agence to set
	 */
	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	/**
	 * @return the session
	 */
	public HttpSession getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(HttpSession session) {
		this.session = session;
	}

	/**
	 * @return the gerant
	 */
	public Gerant getGerant() {
		return gerant;
	}

	/**
	 * @param gerant the gerant to set
	 */
	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the conseillerService
	 */
	public IConseillerService getConseillerService() {
		return conseillerService;
	}

	/**
	 * @param conseillerService the conseillerService to set
	 */
	public void setConseillerService(IConseillerService conseillerService) {
		this.conseillerService = conseillerService;
	}

	/**
	 * @return the conseiller
	 */
	public Conseiller getConseiller() {
		return conseiller;
	}

	/**
	 * @param conseiller the conseiller to set
	 */
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	/**
	 * @return the listeConseiller
	 */
	public List<Conseiller> getListeConseiller() {
		return listeConseiller;
	}

	/**
	 * @param listeConseiller the listeConseiller to set
	 */
	public void setListeConseiller(List<Conseiller> listeConseiller) {
		this.listeConseiller = listeConseiller;
	}

	
	
	/**
	 * @return the compteService
	 */
	public ICompteService<Compte> getCompteService() {
		return compteService;
	}

	/**
	 * @param compteService the compteService to set
	 */
	public void setCompteService(ICompteService<Compte> compteService) {
		this.compteService = compteService;
	}

	/**
	 * @return the listeCompte
	 */
	public List<Compte> getListeCompte() {
		return listeCompte;
	}

	/**
	 * @param listeCompte the listeCompte to set
	 */
	public void setListeCompte(List<Compte> listeCompte) {
		this.listeCompte = listeCompte;
	}

	/**
	 * @return the clientService
	 */
	public IClientService getClientService() {
		return clientService;
	}

	/**
	 * @param clientService the clientService to set
	 */
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
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
	 * @return the listeClient
	 */
	public List<Client> getListeClient() {
		return listeClient;
	}

	/**
	 * @param listeClient the listeClient to set
	 */
	public void setListeClient(List<Client> listeClient) {
		this.listeClient = listeClient;
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
		agence=gerant.getAgence();
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
	 * Afficher tous les comptes 
	 */
	public String getAllComptesByAgence() {
		
		listeCompte = new ArrayList<Compte>();
		
		listeClient = clientService.getAllClientsByIdAgenceService(agence.getIdAgence());
		for (Client cl:listeClient) {
			CompteCourant cc = (CompteCourant) compteService.getComptesCourantByIdClientService(cl.getIdClient());
			CompteEpargne ce = (CompteEpargne) compteService.getComptesEpargneByIdClientService(cl.getIdClient());
			int idcc = cc.getIdCompte();
			int idce = ce.getIdCompte();
			cc.setNumeroCompte(String.valueOf(idcc));
			ce.setNumeroCompte(String.valueOf(idce));
			listeCompte.add(cc);
			listeCompte.add(ce);
		}
		
		return "listeComptesGerant";
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

	/**
	 * Aller à la page information du client
	 * @return
	 */
	public String navigationInformationclient() {
		session.setAttribute("client", clientService.getClientByIdService(this.client.getIdClient()));
		return "infosClientsGerant.xhtml";
	}

	/**
	 * Aller à la page ajout d'un client
	 * @return
	 */
	public String navigationVersAjoutClient() {
		client = new Client();
		conseiller = new Conseiller();
		creationMenuSelectionConseillerWithLess10Clients();
		return "ajoutClientGerant";
	}

	/**
	 * Aller à la page Accueil
	 * @return
	 */
	public String navigationVersAccueil() {
		client = new Client();
		return "accueilGerant";
	}

	/**
	 * Aller à la page modification d'un client
	 * Charger la liste des clients dans le menu déroulant
	 * @return
	 */
	public String navigationModificationClient() {
		client = new Client();
		creationMenuSelectionClientAModifier();
		return "modifClientGerant";
	}

	/**
	 * Aller à la page suppression d'un client
	 * Charger la liste des clients dans le menu déroulant
	 * @return
	 */
	public String navigationSuppressionClient() {
		client = new Client();
		creationMenuSelectionClientAModifier();
		return "suppClientGerant";
	}

	/**
	 * Aller vers la page ajout conseiller
	 * Charger la liste des conseillers avec moins de 10 clients
	 * @return
	 */
	public String navigationVersAjoutConseiller() {
		conseiller = new Conseiller();
		creationMenuSelectionConseillerWithLess10Clients();
		return "ajoutConseiller";
	}

	/**
	 * Aller vers la page liste des clients de l'agence
	 * @return
	 */
	public String navigationVersListeClients() {
		listeClient = clientService.getAllClientsByIdAgenceService(1);
		return "listeClients";
	}
}
