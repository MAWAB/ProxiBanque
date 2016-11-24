package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

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
	
	
	

}
