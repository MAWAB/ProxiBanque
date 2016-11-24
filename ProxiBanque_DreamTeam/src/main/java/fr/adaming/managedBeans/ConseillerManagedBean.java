/**
 * 
 */
package fr.adaming.managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.adaming.model.Client;
import fr.adaming.service.IConseillerService;

/**
 * @author inti0302
 *
 */
@ManagedBean
@SessionScoped
public class ConseillerManagedBean {
	
	IConseillerService conseillerService;

	
	private List<Client> listeClients;
	
	@PostConstruct
	public void init()
	{
		listeClients = new ArrayList<Client>();
		
	}
	
	
	public ConseillerManagedBean()
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
	
	
}
