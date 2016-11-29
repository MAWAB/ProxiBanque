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

@Service("auditeurServiceImpl")
public class AuditRestService implements IAuditRestService {

	@Override
	public List<Agence> getAllAgences() {
		System.out.println("Je suis dans la méthode web service");
		ClientConfig clientConfig = new DefaultClientConfig();
		// pour faire le mapping objet java et objet json
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		// etape 2
		Client cl = Client.create(clientConfig);
		// etape 3 : creer une web ressource
		String empURL = "http://localhost:8080/ProxiBanque_DreamTeam/rest/audit/getAllAgences";
		System.out.println("empUrl");
		WebResource webResource = cl.resource(empURL);
		// invoquer le web service et recuperer le résultat
		System.out.println("webresource");
		ClientResponse response = webResource.get(ClientResponse.class);
		List<Agence> listeAgence = response
				.getEntity(new GenericType<List<Agence>>() {
				});
		return listeAgence;
	}

	@Override
	public Agence getAgenceById(int id_agence) {
		// TODO Auto-generated method stub
		return null;
	}

}
