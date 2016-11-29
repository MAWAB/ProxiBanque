package fr.adaming.restController;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import fr.adaming.model.Agence;
import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.service.IAgenceService;
import fr.adaming.service.IClientService;
import fr.adaming.service.IConseillerService;

@Component
@Path("/audit")		// néccessaire pour détecter cette classe en tant que webservice
public class AuditRestServiceController {

	@Autowired
	@Qualifier("clientServiceImpl")
	private IClientService clientService;
	@Autowired
	@Qualifier("conseillerService")
	private IConseillerService conseillerService;
	
	@Autowired
	@Qualifier("agenceServiceImpl")
	private IAgenceService agenceService;
	

	@GET
	@Path("/getAllClients")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> getAllClients() {
		return clientService.getAllClientsService();
		
	}

	@GET
	@Path("/getNumberCompteCourant")
	@Produces(MediaType.APPLICATION_JSON)
	public int getNumberCompteCourant() {
		List<Client>  listeClient=clientService.getAllClientsService();
		int nombreComteCourant=0;
		for(int i=0;i<listeClient.size();i++)
		{
			if(listeClient.get(i).getCompteCourant()!=null)
			{
				nombreComteCourant++;
			}
		}
		return nombreComteCourant;
		
		
	}
	
	
	@GET
	@Path("/getNumberCompteEpargne")
	@Produces(MediaType.APPLICATION_JSON)
	public int getNumberCompteEpargne() {
		List<Client>  listeClient=clientService.getAllClientsService();
		int nombreCompteEpargne=0;
		for(int i=0;i<listeClient.size();i++)
		{
			if(listeClient.get(i).getCompteEpargne()!=null)
			{
				nombreCompteEpargne++;
			}
		}
		return nombreCompteEpargne;
		
		
	}
	
	@GET
	@Path("/getNumberCompteEpargneValorisee")
	@Produces(MediaType.APPLICATION_JSON)
	public int getNumberCompteEpargneEnDefaut() {
		List<Client>  listeClient=clientService.getAllClientsService();
		int nombreCompteEpargneValorisee=0;
		for(int i=0;i<listeClient.size();i++)
		{
			if(listeClient.get(i).getCompteEpargne()!=null)
			{
				if(listeClient.get(i).getCompteEpargne().getSolde()>500000)
				{
					nombreCompteEpargneValorisee++;					
				}

			}
		}
		return nombreCompteEpargneValorisee;
	}
	
	
	
	
	
	@GET
	@Path("/getNumberCompteCourantEnDefaut")
	@Produces(MediaType.APPLICATION_JSON)
	public int getNumberCompteCourantEnDefaut() {
		List<Client>  listeClient=clientService.getAllClientsService();
		int nombreCompteCourantEnDefaut=0;
		for(int i=0;i<listeClient.size();i++)
		{
			if(listeClient.get(i).getCompteEpargne()!=null)
			{
				if(listeClient.get(i).getCompteCourant().getSolde()<-5000)
				{
					nombreCompteCourantEnDefaut++;					
				}

			}
		}
		return nombreCompteCourantEnDefaut;
	}
	
	
	
	
	
	@GET
	@Path("/getNumberClient")
	@Produces(MediaType.APPLICATION_JSON)
	public int getNumberClients() {
		return clientService.getAllClientsService().size();
	}
	
	@GET
	@Path("/getNumberConseillers")
	@Produces(MediaType.APPLICATION_JSON)
	public int getNumberConseillers()
	{
		return conseillerService.getAllConseillerService().size();
		
	}
	@GET
	@Path("/getAgenceById/{id_agence}")
	@Produces(MediaType.APPLICATION_JSON)
	public Agence getAgenceById(@PathParam("id_agence") int id_agence) {
		return agenceService.getAgenceById(id_agence);
	}
	
	
	@GET
	@Path("/getAllConseillers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Conseiller> getAllConseillers() {
		return conseillerService.getAllConseillerService();
	}
	
	@GET
	@Path("/getAllAgences")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Agence> getAllAgence() {
		return agenceService.getAllAgences();
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
