package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Gerant;
import fr.adaming.service.IClientService;
import fr.adaming.service.IConseillerService;

@ManagedBean(name="gerantMB")
@SessionScoped
public class GerantManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** atrtibuts session*/
	HttpSession session;
	
	/** attributs gerant*/
	private Gerant gerant;
	
	/** attributs conseiller*/
	IConseillerService conseillerService;
	private Conseiller conseiller;
	private List<Conseiller> listeConseiller;
	
	/** attributs clients*/
	IClientService clientService;
	private Client client;
	private List<Client> listeClient;
	
	
	/** attributs comptes*/
	
	/** attributs cartes*/
	
	/**Constructeur vide*/
	
	public GerantManagedBean() {
		this.conseiller = new Conseiller();
		this.client = new Client();
	}

	
	/** Getters & Setters*/
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
	
	/** autres méthodes*/
	
	/** init: chargement de toutes les listes*/
	@PostConstruct
	public void init(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		session = (HttpSession) facesContext.getExternalContext().getSession(false);
		
		gerant= (Gerant) session.getAttribute("gerant");
		listeConseiller = conseillerService.getAllConseillerService();
		listeClient = clientService.getAllClientsService();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("gerant", gerant);
	}
	
	/** CRUD conseiller*/
	
	public String getConseillerById(){
		conseillerService.getConseillerByIdService(conseiller.getIdConseiller());
		listeConseiller = conseillerService.getAllConseillerService();
		return "accueilGerant.xhtml";
	}
	
	public String ajouterConseiller(){
		conseillerService.addConseillerService(conseiller);
		listeConseiller = conseillerService.getAllConseillerService();
		return "accueilGerant.xhtml";
		
	}
	
	public String modifierConseiller(){
		conseillerService.updateConseillerService(conseiller);
		listeConseiller = conseillerService.getAllConseillerService();
		return "accueilGerant.xhtml";
	}
	
	public String supprimerConseiller(){
		conseillerService.deleteConseillerService(conseiller);
		listeConseiller = conseillerService.getAllConseillerService();
		return "accueilGerant.xhtml";
	}
	
	/** CRUD client*/
	
	public String getClientById(){
		clientService.getClientByIdService(client.getIdClient());
		listeClient = clientService.getAllClientsService();
		return "accueilGerant.xhtml";
	}
	
	public String ajouterClient(){
		clientService.addClientService(client);
		listeClient = clientService.getAllClientsService();
		return "accueilGerant.xhtml";
	}
	
	public String modifierClient(){
		clientService.updateClientService(client);
		listeClient = clientService.getAllClientsService();
		return "accueilGerant.xhtml";
	}
	
	public String supprimerClient(){
		clientService.deleteClientService(client.getIdClient());
		listeClient = clientService.getAllClientsService();
		return "accueilGerant.xhtml";
	}
	
	
	
	
	
	
	
	
	

}
