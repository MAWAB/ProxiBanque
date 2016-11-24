package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.service.IClientService;
import fr.adaming.service.IConseillerService;

@ManagedBean
@SessionScoped
public class GerantManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
	@PostConstruct
	public init(){
		listeConseiller = conseillerService.getAllConseillerDao();
	}
	
	
	
	
	

}
