/**
 * 
 */
package fr.adaming.managedBeans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.service.IClientService;

/**
 * @author inti0302
 *
 */
@Controller("conseillerMB")
@Scope("session")
public class ConseillerManagedBean {
	
	@Autowired
	@Qualifier("clientServiceImpl")
	IClientService clientService;
	private Conseiller conseillerLogged;
	private List<Client> listeClients;
	
	@PostConstruct
	public void init()
	{
		conseillerLogged = new Conseiller();
		conseillerLogged.setIdConseiller(1);
		listeClients = clientService.getAllClientsByIdConseillerService(conseillerLogged.getIdConseiller());
	}
	
	
	public ConseillerManagedBean()
	{
		
	}
	public void methodeTemporaire()
	{
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * @return the listeClients
	 */
	public List<Client> getListeClients() {
		return listeClients;
	}

	/**
	 * @param listeClients the listeClients to set
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
	 * @param clientService the clientService to set
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
	 * @param conseillerLogged the conseillerLogged to set
	 */
	public void setConseillerLogged(Conseiller conseillerLogged) {
		this.conseillerLogged = conseillerLogged;
	}
	
	
}
