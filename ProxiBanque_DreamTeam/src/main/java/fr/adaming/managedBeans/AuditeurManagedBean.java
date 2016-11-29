package fr.adaming.managedBeans;

import java.io.IOException;
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
import org.primefaces.event.MenuActionEvent;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import fr.adaming.model.Agence;
import fr.adaming.service.IAuditRestService;

@ManagedBean(name = "auditeurMB")
@SessionScoped
public class AuditeurManagedBean {

	@ManagedProperty(value = "#{auditeurServiceImpl}")
	private IAuditRestService auditRestService;

	private MenuModel menuListeDesAgences;
	private List<Agence> listeDesAgences;
	private Agence agenceAAuditer;

	private MenuModel menuListeDesOptionsAudit;

	@PostConstruct
	public void init() {
		menuListeDesAgences = new DefaultMenuModel();
		agenceAAuditer = new Agence();
		listeDesAgences = new ArrayList<Agence>();
		menuListeDesAgences = new DefaultMenuModel();
		menuListeDesOptionsAudit = new DefaultMenuModel();
		creationMenuSelectionClientAModifier();
		creationMenuSelectionOptionAudit();
	}

	public AuditeurManagedBean() {

	}

	public void creationMenuSelectionOptionAudit()
	{

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
			item = new DefaultMenuItem("Liste des comptes");
			item.setParam("choixOptionAudit", 2);
			item.setCommand("#{auditeurMB.selectionOptionAudit}");
			submenu.addElement(item);
			item = new DefaultMenuItem("mise à jour des placements");
			item.setParam("choixOptionAudit", 3);
			item.setCommand("#{auditeurMB.selectionOptionAudit}");
			submenu.addElement(item);		
		menuListeDesAgences.addElement(submenu);
	}
	public String selectionOptionAudit(ActionEvent event) throws IOException
	{
		DefaultMenuItem menuItem = (DefaultMenuItem) ((MenuActionEvent) event).getMenuItem();
		int choixAudit = Integer.parseInt(menuItem.getParams().get("choixOptionAudit").get(0));
		switch(choixAudit)
		{
		case 0 : return "auditAccueil";
					
		case 1 :  return "listeDesClients";
			
		case 2 : return "listeDesComptes";
		
		case 3 : return "miseAjourPlacement";
		
		default: return "auditAccueil";
		
		}
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
	 * @param menuListeDesOptionsAudit the menuListeDesOptionsAudit to set
	 */
	public void setMenuListeDesOptionsAudit(MenuModel menuListeDesOptionsAudit) {
		this.menuListeDesOptionsAudit = menuListeDesOptionsAudit;
	}

}
