package fr.adaming.restController;

import java.util.List;

import javax.faces.bean.ManagedProperty;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import fr.adaming.model.Client;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.Conseiller;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICompteService;
import fr.adaming.service.IConseillerService;

@Component
@Path("/audit")		// n�ccessaire pour d�tecter cette classe en tant que webservice
public class AuditRest {

	@Autowired
	@Qualifier("clientServiceImpl")
	private IClientService clientService;
	@Autowired
	@Qualifier("conseillerService")
	private IConseillerService conseillerService;

	@GET
	@Path("/getAllClients")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> getAllClients() {
		System.out.println("web service");
		return clientService.getAllClientsService();
	}

	@GET
	@Path("/getAllConseillers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Conseiller> getAllConseillers() {
		return conseillerService.getAllConseillerService();
	}
	
//	@GET
//	@Path("/getAllAgence")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Conseiller> getAllAgence() {
//		return conseillerService.();
//	}
////
//	@RequestMapping(value = "/getAllComptesCourant/{id_agence}", method = RequestMethod.GET, produces = "application/json", consumes= "application/json")	
//	public List<CompteCourant> getAllCompteCourant(@PathVariable int id_agence)
//	{
//		return compteService.getComptesCourantByIdAgenceService(id_agence);	
//				
//	}
//	@RequestMapping(value = "/getAllComptesCourant/{id_agence}", method = RequestMethod.GET, produces = "application/json", consumes= "application/json")
//	public List<CompteCourant> getAllCompteEpargne(@PathVariable int id_agence)
//	{
//		return compteService.getComptesEpargneByIdAgenceService(id_agence);
//				
//	}
	
	
	

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
	 * @return the conseillerService
	 */
	public IConseillerService getConseillerService() {
		return conseillerService;
	}



	/**
	 * @param conseillerService the conseillerService to set
	 */
	public void setConseillerService(IConseillerService conseillerService) {
		this.conseillerService = conseillerService;
	}
	
	
}
