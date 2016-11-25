package fr.adaming.serviceTest;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.model.Adresse;
import fr.adaming.model.Agence;
import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Gerant;
import fr.adaming.service.IConseillerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class ConseillerServiceTest {

		
	@Autowired
	IConseillerService conseillerService;
	
	
	@BeforeClass
	public static void beforeCTest() {
		System.out.println("-----------------------D�but des tests conseillerService----------------\n");
	}
	

	
	@AfterClass
	public static void afterCTest() {
		System.out.println("-----------------------Fin des tests conseillerService-----------------\n");
	}
	
	
	@Test
	public void addConseiller() {
		System.out.println("-------------------M�thode addConseiller-------------------");
		
		Date dateAgence = new Date(2016, 11, 25);
		Date dNGerant = new Date(2016, 11, 25);
		Date dNConseiller = new Date(2016, 11, 25);
		Gerant gerant = null;
		Agence agence = null;
		List<Client> clientList = null;
		List<Conseiller> conseillerList = null;
		
		Adresse adresse1 = new Adresse(1, "rue", 44, "Nantes");
		Adresse adresse2 = new Adresse(2, "rue", 53, "evron");
		agence = new Agence(1, "agence", dateAgence, gerant, "123");
		gerant = new Gerant("toto", "titi", dNGerant, adresse1, 1, "service", "immat", "password", gerant, clientList, "bureau", conseillerList, agence);
		Conseiller conseiller = new Conseiller("tutu", "tata", dNConseiller, adresse2, "service", "immat", "mdp", gerant, clientList);
		
		Conseiller cons = conseillerService.addConseillerService(conseiller);
		
		assertEquals(conseiller.getNom(), cons.getNom());
		
		
		
	}
	
}
