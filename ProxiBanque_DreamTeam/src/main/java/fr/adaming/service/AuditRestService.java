package fr.adaming.service;

import java.util.List;

import org.springframework.stereotype.Service;
import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import fr.adaming.model.Agence;
import fr.adaming.model.Conseiller;


@Service("auditeurServiceImpl")
public class AuditRestService implements IAuditRestService {

	@Override
	public List<Agence> getAllAgences() {
		ClientConfig clientConfig = new DefaultClientConfig();
		// pour faire le mapping objet java et objet json
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		// etape 2
		Client cl = Client.create(clientConfig);
		// etape 3 : creer une web ressource
		String empURL = "http://localhost:8080/ProxiBanque_DreamTeam/rest/audit/getAllAgences";
		WebResource webResource = cl.resource(empURL);
		// invoquer le web service et recuperer le résultat
		ClientResponse response = webResource.get(ClientResponse.class);
		List<Agence> listeAgence = response
				.getEntity(new GenericType<List<Agence>>() {
				});
		return listeAgence;
	}

	@Override
	public Agence getAgenceById(int id_agence) {

		// étape 1 : instancier un objet ClientConfig pour configurer le client Rest ful
		ClientConfig clientConfig=new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		// étape 2 : instancier un client rest
		Client client=Client.create(clientConfig);
		// étape 3 : créer une web ressource
		WebResource webResource=client.resource("http://localhost:8080/ProxiBanque_DreamTeam/rest/audit/getAgenceById/"); // resource base de wadl
		Agence agenceRecuperer=webResource.path(Integer.toString(id_agence))
				.accept(MediaType.APPLICATION_JSON)
				.get(Agence.class);	
		return agenceRecuperer;
	}

	public List<fr.adaming.model.Client> getAllClients()
	{
		ClientConfig clientConfig = new DefaultClientConfig();
		// pour faire le mapping objet java et objet json
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		// etape 2
		com.sun.jersey.api.client.Client cl = Client.create(clientConfig);
		// etape 3 : creer une web ressource
		String empURL = "http://localhost:8080/ProxiBanque_DreamTeam/rest/audit/getAllClients";
		WebResource webResource = cl.resource(empURL);
		// invoquer le web service et recuperer le résultat
		ClientResponse response = webResource.get(ClientResponse.class);
		List<fr.adaming.model.Client> listeclient = response
				.getEntity(new GenericType<List<fr.adaming.model.Client>>() {
				});
		return listeclient;
	}
	
	public int getNumberCompteEpargne()
	{
		ClientConfig clientConfig = new DefaultClientConfig();
		// pour faire le mapping objet java et objet json
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		// etape 2
		com.sun.jersey.api.client.Client cl = Client.create(clientConfig);
		// etape 3 : creer une web ressource
		String empURL = "http://localhost:8080/ProxiBanque_DreamTeam/rest/audit/getNumberCompteEpargne";
		WebResource webResource = cl.resource(empURL);
		// invoquer le web service et recuperer le résultat
		ClientResponse response = webResource.get(ClientResponse.class);
		return response.getEntity(Integer.class);
		
		
	}
	public int getNumberCompteCourant()
	{
		ClientConfig clientConfig = new DefaultClientConfig();
		// pour faire le mapping objet java et objet json
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		// etape 2
		com.sun.jersey.api.client.Client cl = Client.create(clientConfig);
		// etape 3 : creer une web ressource
		String empURL = "http://localhost:8080/ProxiBanque_DreamTeam/rest/audit/getNumberCompteCourant";
		WebResource webResource = cl.resource(empURL);
		// invoquer le web service et recuperer le résultat
		ClientResponse response = webResource.get(ClientResponse.class);
		return response.getEntity(Integer.class);
		
		
	}
	
	
	public int getNumberCompteEpargneValorisee()
	{
		ClientConfig clientConfig = new DefaultClientConfig();
		// pour faire le mapping objet java et objet json
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		// etape 2
		com.sun.jersey.api.client.Client cl = Client.create(clientConfig);
		// etape 3 : creer une web ressource
		String empURL = "http://localhost:8080/ProxiBanque_DreamTeam/rest/audit/getNumberCompteEpargneValorisee";
		WebResource webResource = cl.resource(empURL);
		// invoquer le web service et recuperer le résultat
		ClientResponse response = webResource.get(ClientResponse.class);
		return response.getEntity(Integer.class);
		
		
	}
	
	public int getNumberCompteCourantEnDefaut()
	{
		ClientConfig clientConfig = new DefaultClientConfig();
		// pour faire le mapping objet java et objet json
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		// etape 2
		com.sun.jersey.api.client.Client cl = Client.create(clientConfig);
		// etape 3 : creer une web ressource
		String empURL = "http://localhost:8080/ProxiBanque_DreamTeam/rest/audit/getNumberCompteCourantEnDefaut";
		WebResource webResource = cl.resource(empURL);
		// invoquer le web service et recuperer le résultat
		ClientResponse response = webResource.get(ClientResponse.class);
		return response.getEntity(Integer.class);
		
		
	}
	public int getNumberClients()
	{
		ClientConfig clientConfig = new DefaultClientConfig();
		// pour faire le mapping objet java et objet json
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		// etape 2
		com.sun.jersey.api.client.Client cl = Client.create(clientConfig);
		// etape 3 : creer une web ressource
		String empURL = "http://localhost:8080/ProxiBanque_DreamTeam/rest/audit/getNumberClient";
		WebResource webResource = cl.resource(empURL);
		// invoquer le web service et recuperer le résultat
		ClientResponse response = webResource.get(ClientResponse.class);
		return response.getEntity(Integer.class);

	}
	
	public int getNumberConseillers()
	{
		ClientConfig clientConfig = new DefaultClientConfig();
		// pour faire le mapping objet java et objet json
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		// etape 2
		com.sun.jersey.api.client.Client cl = Client.create(clientConfig);
		// etape 3 : creer une web ressource
		String empURL = "http://localhost:8080/ProxiBanque_DreamTeam/rest/audit/getNumberConseillers";
		WebResource webResource = cl.resource(empURL);
		// invoquer le web service et recuperer le résultat
		ClientResponse response = webResource.get(ClientResponse.class);
		return response.getEntity(Integer.class);

	}

	public List<Conseiller> getAllConseillers()
	{
		ClientConfig clientConfig = new DefaultClientConfig();
		// pour faire le mapping objet java et objet json
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		// etape 2
		Client cl = Client.create(clientConfig);
		// etape 3 : creer une web ressource
		String empURL = "http://localhost:8080/ProxiBanque_DreamTeam/rest/audit/getAllConseillers";
		WebResource webResource = cl.resource(empURL);
		// invoquer le web service et recuperer le résultat
		ClientResponse response = webResource.get(ClientResponse.class);
		List<Conseiller> listeConseiller = response
				.getEntity(new GenericType<List<Conseiller>>() {
				});
		return listeConseiller;
	}

}
