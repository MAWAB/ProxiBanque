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

import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.service.IClientService;

/**
 * @author inti0302
 *
 */
@ManagedBean(name="conseillerMB")
@SessionScoped
public class ConseillerManagedBean {
	
	@Qualifier("clientServiceImpl")
	IClientService clientService;
	private Conseiller conseillerLogged;
	private List<Client> listeClients;
	
	@PostConstruct
	public void init()
	{
		conseillerLogged = new Conseiller();
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
	
	
}
