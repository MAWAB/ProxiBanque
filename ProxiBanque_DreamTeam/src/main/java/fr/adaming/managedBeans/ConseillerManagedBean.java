/**
 * 
 */
package fr.adaming.managedBeans;

import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
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
	}

	public ConseillerManagedBean() {

	}

	
	/* méthodes sur la manipulation des clients (ajouter, modifier et supprimer) */
	
	public void ajouterClient()
	{
		clientService.addClientService(clientAManipuler);
	}
	
	public void modifierClient()
	{
		clientService.updateClientService(clientAManipuler);
	}
	
	public void supprimerClient()
	{
		clientService.deleteClientService(clientAManipuler.getIdClient());
	}
	
	
	/* méthodes de navigation */
	
	public String navigationInformationclient() {
		System.out.println("navigation infor clients");
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		int id = Integer.parseInt(params.get("id_client"));
		session.setAttribute("client", clientService.getClientByIdService(id));

		return "infosClient.xhtml";
	}
	
	public String navigationVersAjoutClient() {
		System.out.println("navigation vers la page ajout");
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
		
			return "accueilConseiller";
		
	}

	public String navigationModificationClient() {
		return null;
	}

	public String navigationSuppressionClient() {
		return null;
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

}
