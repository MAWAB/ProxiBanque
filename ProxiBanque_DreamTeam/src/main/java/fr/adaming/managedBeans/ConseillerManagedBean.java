/**
 * 
 */
package fr.adaming.managedBeans;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.primefaces.context.RequestContext;
import org.primefaces.event.MenuActionEvent;

import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.service.IClientService;

/**
 * @author inti0302
 *
 */
@ManagedBean(name = "conseillerMB")
@SessionScoped
public class ConseillerManagedBean {

	@ManagedProperty(value = "#{clientServiceImpl}")
	IClientService clientService;

	private Conseiller conseillerLogged;
	private List<Client> listeClients;
	private HttpSession session;
	private Client clientAManipuler;
	MenuModel menulisteClientAModifier;

	
	
	/* initialisation du bean */
	@PostConstruct
	public void init() {
		clientAManipuler = new Client();
		conseillerLogged = new Conseiller();
		conseillerLogged.setIdConseiller(1);
		conseillerLogged.setPrenom(" Mr. Picsou");
		listeClients = clientService.getAllClientsByIdConseillerService(conseillerLogged.getIdConseiller());
		FacesContext fc = FacesContext.getCurrentInstance();
		session = (HttpSession) fc.getExternalContext().getSession(false);
		menulisteClientAModifier = new DefaultMenuModel();
	}

	public ConseillerManagedBean() {

	}

	public void creationMenuSelectionClientAModifier() {
		System.out.println("creation menu liste");
		menulisteClientAModifier = new DefaultMenuModel();
		DefaultSubMenu submenu = new DefaultSubMenu(
				"Sélection du compte source");
		DefaultMenuItem item;

		for (int i = 0; i < listeClients.size(); i++) {
			item = new DefaultMenuItem("nom : "
					+ listeClients.get(i).getNom() + " prenom : "
					+ listeClients.get(i).getPrenom());
			item.setParam("id_client", listeClients.get(i).getIdClient());
			item.setCommand("#{conseillerMB.selectionClientAModifier}");
			submenu.addElement(item);
		}
		menulisteClientAModifier.addElement(submenu);
	}
	
	public void selectionClientAModifier(ActionEvent event) throws IOException {

		DefaultMenuItem menuItem = (DefaultMenuItem) ((MenuActionEvent) event).getMenuItem();
		int id = Integer.parseInt(menuItem.getParams().get("id_client").get(0));
		clientAManipuler= clientService.getClientByIdService(id);
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
	}
	
	/* méthodes sur la manipulation des clients (ajouter, modifier et supprimer) */
	
	public String ajouterClient()
	{
		clientAManipuler.setConseiller(conseillerLogged);
		if(clientService.addClientService(clientAManipuler)==1){
			listeClients=clientService.getAllClientsByIdConseillerService(conseillerLogged.getIdConseiller());
			return "accueilConseiller";
		}else
		{
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('dialEchecAjoutClient').show(); return false;");
			return "accueilConseiller"; 
		}
		
	}
	
	public String modifierClient()
	{
		
		clientService.updateClientService(clientAManipuler);
		listeClients=clientService.getAllClientsByIdConseillerService(conseillerLogged.getIdConseiller());
		return "accueilConseiller";
	}
	
	public String supprimerClient()
	{
		clientService.deleteClientService(clientAManipuler.getIdClient());
		return "accueilConseiller";
	}
	
	
	/* méthodes de navigation */
	
	public String navigationInformationclient() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		int id = Integer.parseInt(params.get("id_client"));
		session.setAttribute("client", clientService.getClientByIdService(id));

		return "infosClient.xhtml";
	}
	
	public String navigationVersAjoutClient() {
		clientAManipuler = new Client();
		
		if (listeClients.size() < 10)
			return "ajoutClient";
		else
		{
			RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dialEchecAjoutClient').show(); return false;");
			return "accueilConseiller";
		}
	}

	public String navigationVersAccueil() {
		
		clientAManipuler = new Client();
			return "accueilConseiller";
		
	}

	public String navigationModificationClient() {
		creationMenuSelectionClientAModifier();
		return "modifClient";
	}

	public String navigationSuppressionClient() {
		return "suppClient";
	}

	/**
	 * @return the listeClients
	 */
	public List<Client> getListeClients() {
		return listeClients;
	}

	/**
	 * @param listeClients
	 *            the listeClients to set
	 */
	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}

	/**
	 * @return the clientService
	 */
	public IClientService getClientService() {
		return clientService;
	}

	/**
	 * @param clientService
	 *            the clientService to set
	 */
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	/**
	 * @return the conseillerLogged
	 */
	public Conseiller getConseillerLogged() {
		return conseillerLogged;
	}

	/**
	 * @param conseillerLogged
	 *            the conseillerLogged to set
	 */
	public void setConseillerLogged(Conseiller conseillerLogged) {
		this.conseillerLogged = conseillerLogged;
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
	 * @return the clientAManipuler
	 */
	public Client getClientAManipuler() {
		return clientAManipuler;
	}

	/**
	 * @param clientAManipuler the clientAManipuler to set
	 */
	public void setClientAManipuler(Client clientAManipuler) {
		this.clientAManipuler = clientAManipuler;
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

}
