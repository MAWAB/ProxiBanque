package fr.adaming.managedBeans;

import java.io.IOException;
import java.net.URL;
import java.rmi.Remote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.event.MenuActionEvent;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import com.cdyne.ws.DelayedStockQuote;
import com.cdyne.ws.DelayedStockQuoteSoap;
import com.cdyne.ws.QuoteData;

import fr.adaming.model.Agence;
import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Place;
import fr.adaming.service.IAuditRestService;

@ManagedBean(name = "auditeurMB")
@SessionScoped
public class AuditeurManagedBean {

	@ManagedProperty(value = "#{auditeurServiceImpl}")
	private IAuditRestService auditRestService;

	private MenuModel menuListeDesAgences;
	private List<Agence> listeDesAgences;
	private Agence agenceAAuditer;
	private DelayedStockQuote stub;
	private DelayedStockQuoteSoap service;
	private List<Place> listeDesPlaces;
	private MenuModel menuListeDesOptionsAudit;


	private List<Client> listeClient;
	private int nombreCompteEpargne;
	private int nombreCompteCourant;
	private int nombreCompteAValorise;
	private int nombreCompteCourantDeficit;
	private int nombreClient;
	private int nombreConseiller;
	
	
	@PostConstruct
	public void init() {
		menuListeDesAgences = new DefaultMenuModel();
		agenceAAuditer = new Agence();
		listeDesAgences = new ArrayList<Agence>();
		menuListeDesAgences = new DefaultMenuModel();
		menuListeDesOptionsAudit = new DefaultMenuModel();
		creationMenuSelectionClientAModifier();
		creationMenuSelectionOptionAudit();
		listeDesPlaces = new ArrayList<Place>();

	}

	public AuditeurManagedBean() {

	}

	public void creationMenuSelectionOptionAudit() {

		DefaultSubMenu submenu = new DefaultSubMenu("Sélection de l'audit à réaliser");
		DefaultMenuItem item;
		item = new DefaultMenuItem("Synthèse");
		item.setParam("choixOptionAudit", 0);
		item.setCommand("#{auditeurMB.selectionOptionAudit}");
		submenu.addElement(item);
		item = new DefaultMenuItem("Liste des clients");
		item.setParam("choixOptionAudit", 1);
		item.setCommand("#{auditeurMB.selectionOptionAudit}");
		submenu.addElement(item);
		item = new DefaultMenuItem("mise à jour des placements");
		item.setParam("choixOptionAudit", 3);
		item.setCommand("#{auditeurMB.selectionOptionAudit}");
		submenu.addElement(item);
		menuListeDesAgences.addElement(submenu);
	}

	public void miseAJourPlacement() {
		System.out.println("methode pour updater les placements");
	}

	public String selectionOptionAudit(ActionEvent event) throws IOException {
		DefaultMenuItem menuItem = (DefaultMenuItem) ((MenuActionEvent) event).getMenuItem();
		int choixAudit = Integer.parseInt(menuItem.getParams().get("choixOptionAudit").get(0));
		switch (choixAudit) {

		case 0:

			return "auditAccueil";
		case 1:
			return "ClientsAudit";
		case 2:
			return "listeDesComptes";
		case 3:
			DelayedStockQuote stub = new DelayedStockQuote();
			DelayedStockQuoteSoap service = stub.getDelayedStockQuoteSoap();
			QuoteData data = service.getQuote("ac", "0");
			Place placeToUpdate = new Place();
			placeToUpdate.setNom(data.getCompanyName());
			placeToUpdate.setTaux(Double.parseDouble(data.getEarnPerShare().toString()));
			listeDesPlaces.add(placeToUpdate);
			data = service.getQuote("b", "0");
			placeToUpdate = new Place();
			placeToUpdate.setNom(data.getCompanyName());
			placeToUpdate.setTaux(Double.parseDouble(data.getEarnPerShare().toString()));
			listeDesPlaces.add(placeToUpdate);
			data = service.getQuote("c", "0");
			placeToUpdate = new Place();
			placeToUpdate.setNom(data.getCompanyName());
			placeToUpdate.setTaux(Double.parseDouble(data.getEarnPerShare().toString()));
			listeDesPlaces.add(placeToUpdate);
			data = service.getQuote("d", "0");
			placeToUpdate = new Place();
			placeToUpdate.setTaux(Double.parseDouble(data.getEarnPerShare().toString()));
			placeToUpdate.setNom(data.getCompanyName());
			listeDesPlaces.add(placeToUpdate);
			return "miseAjourPlacement";

		default:
			return "auditAccueil";

		}
	}

	public String navigationVersAccueil() {
		return "auditAccueil";
	}

	public void creationMenuSelectionClientAModifier() {

		DefaultSubMenu submenu = new DefaultSubMenu("Sélection de l'agence à auditer");
		DefaultMenuItem item;
		listeDesAgences = auditRestService.getAllAgences();
		for (int i = 0; i < listeDesAgences.size(); i++) {
			item = new DefaultMenuItem(listeDesAgences.get(i).getNom());
			item.setParam("id_agence", listeDesAgences.get(i).getIdAgence());
			item.setCommand("#{auditeurMB.selectionAgenceDansMenu}");
			submenu.addElement(item);
		}
		menuListeDesAgences.addElement(submenu);
	}

	public void selectionAgenceDansMenu(ActionEvent event) throws IOException {
		DefaultMenuItem menuItem = (DefaultMenuItem) ((MenuActionEvent) event).getMenuItem();
		int id_agence = Integer.parseInt(menuItem.getParams().get("id_agence").get(0));
		agenceAAuditer = auditRestService.getAgenceById(id_agence);
		// rafraichir la page
		
		listeClient=auditRestService.getAllClients();
		nombreCompteEpargne=auditRestService.getNumberCompteEpargne();
		nombreCompteCourant=auditRestService.getNumberCompteCourant();
		nombreCompteCourantDeficit= auditRestService.getNumberCompteCourantEnDefaut();
		nombreCompteAValorise=auditRestService.getNumberCompteEpargneValorisee();
		nombreClient=auditRestService.getNumberClients();
		nombreConseiller= auditRestService.getNumberConseillers();
		
		
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
	}

	/**
	 * @return the auditRestService
	 */
	public IAuditRestService getAuditRestService() {
		return auditRestService;
	}

	/**
	 * @param auditRestService
	 *            the auditRestService to set
	 */
	public void setAuditRestService(IAuditRestService auditRestService) {
		this.auditRestService = auditRestService;
	}

	/**
	 * @return the menuListeDesAgences
	 */
	public MenuModel getMenuListeDesAgences() {
		return menuListeDesAgences;
	}

	/**
	 * @param menuListeDesAgences
	 *            the menuListeDesAgences to set
	 */
	public void setMenuListeDesAgences(MenuModel menuListeDesAgences) {
		this.menuListeDesAgences = menuListeDesAgences;
	}

	/**
	 * @return the listeDesAgences
	 */
	public List<Agence> getListeDesAgences() {
		return listeDesAgences;
	}

	/**
	 * @param listeDesAgences
	 *            the listeDesAgences to set
	 */
	public void setListeDesAgences(List<Agence> listeDesAgences) {
		this.listeDesAgences = listeDesAgences;
	}

	/**
	 * @return the agenceAAuditer
	 */
	public Agence getAgenceAAuditer() {
		return agenceAAuditer;
	}

	/**
	 * @param agenceAAuditer
	 *            the agenceAAuditer to set
	 */
	public void setAgenceAAuditer(Agence agenceAAuditer) {
		this.agenceAAuditer = agenceAAuditer;
	}

	/**
	 * @return the menuListeDesOptionsAudit
	 */
	public MenuModel getMenuListeDesOptionsAudit() {
		return menuListeDesOptionsAudit;
	}

	/**
	 * @param menuListeDesOptionsAudit
	 *            the menuListeDesOptionsAudit to set
	 */
	public void setMenuListeDesOptionsAudit(MenuModel menuListeDesOptionsAudit) {
		this.menuListeDesOptionsAudit = menuListeDesOptionsAudit;
	}

	/**
	 * @return the stub
	 */
	public DelayedStockQuote getStub() {
		return stub;
	}

	/**
	 * @param stub
	 *            the stub to set
	 */
	public void setStub(DelayedStockQuote stub) {
		this.stub = stub;
	}

	/**
	 * @return the service
	 */
	public DelayedStockQuoteSoap getService() {
		return service;
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(DelayedStockQuoteSoap service) {
		this.service = service;
	}

	/**
	 * @return the listeDesPlaces
	 */
	public List<Place> getListeDesPlaces() {
		return listeDesPlaces;
	}

	/**
	 * @param listeDesPlaces
	 *            the listeDesPlaces to set
	 */
	public void setListeDesPlaces(List<Place> listeDesPlaces) {
		this.listeDesPlaces = listeDesPlaces;
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
	 * @return the nombreCompteEpargne
	 */
	public int getNombreCompteEpargne() {
		return nombreCompteEpargne;
	}

	/**
	 * @param nombreCompteEpargne the nombreCompteEpargne to set
	 */
	public void setNombreCompteEpargne(int nombreCompteEpargne) {
		this.nombreCompteEpargne = nombreCompteEpargne;
	}

	/**
	 * @return the nombreCompteCourant
	 */
	public int getNombreCompteCourant() {
		return nombreCompteCourant;
	}

	/**
	 * @param nombreCompteCourant the nombreCompteCourant to set
	 */
	public void setNombreCompteCourant(int nombreCompteCourant) {
		this.nombreCompteCourant = nombreCompteCourant;
	}

	/**
	 * @return the nombreCompteAValorise
	 */
	public int getNombreCompteAValorise() {
		return nombreCompteAValorise;
	}

	/**
	 * @param nombreCompteAValorise the nombreCompteAValorise to set
	 */
	public void setNombreCompteAValorise(int nombreCompteAValorise) {
		this.nombreCompteAValorise = nombreCompteAValorise;
	}

	/**
	 * @return the nombreCompteCourantDeficit
	 */
	public int getNombreCompteCourantDeficit() {
		return nombreCompteCourantDeficit;
	}

	/**
	 * @param nombreCompteCourantDeficit the nombreCompteCourantDeficit to set
	 */
	public void setNombreCompteCourantDeficit(int nombreCompteCourantDeficit) {
		this.nombreCompteCourantDeficit = nombreCompteCourantDeficit;
	}

	/**
	 * @return the nombreClient
	 */
	public int getNombreClient() {
		return nombreClient;
	}

	/**
	 * @param nombreClient the nombreClient to set
	 */
	public void setNombreClient(int nombreClient) {
		this.nombreClient = nombreClient;
	}

	/**
	 * @return the nombreConseiller
	 */
	public int getNombreConseiller() {
		return nombreConseiller;
	}

	/**
	 * @param nombreConseiller the nombreConseiller to set
	 */
	public void setNombreConseiller(int nombreConseiller) {
		this.nombreConseiller = nombreConseiller;
	}

}
