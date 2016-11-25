///**
// * 
// */
//package fr.adaming.serviceTest;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import fr.adaming.dao.IClientDao;
//import fr.adaming.model.Adresse;
//import fr.adaming.model.Agence;
//import fr.adaming.model.Client;
//import fr.adaming.model.CompteCourant;
//import fr.adaming.model.CompteEpargne;
//import fr.adaming.model.Conseiller;
//import fr.adaming.model.Gerant;
//import fr.adaming.service.IClientService;
//
///**
// * @author inti0302
// *
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/application-context.xml")
//public class ClientServiceTest {
//
//	@Autowired
//	private IClientService clientService;
//
//	@Autowired
//	private IClientDao clientDao;
//
//	/**
//	 * @param clientDao
//	 *            the clientDao to set
//	 */
//	public void setClientDao(IClientDao clientDao) {
//		this.clientDao = clientDao;
//	}
//
//	@Before
//	public void beforeTest() {
//		System.out.println("-----------------------Avant le test du Service Client-----------------");
//	}
//
//	@After
//	public void afterTest() {
//		System.out.println("-----------------------Après le test du Service Client------------------");
//	}
//
//	// @Test
//	// public void testAjouterClientDao() {
//	//
//	// Date date = new Date(1988 + 1900, 11, 7);
//	// Date dateCons = new Date(1970 + 1900, 02, 11);
//	// Date dateGer = new Date(1970 + 1900, 11, 23);
//	// Date dateAg = new Date(2016 + 1900, 11, 22);
//	// Adresse adresse = new Adresse("Scorff", 44000, "Orvault");
//	// Adresse adresseCons = new Adresse(1, "Remy", 33000, "Bordeaux");
//	// Adresse adresseGer = new Adresse(2, "Fleurus", 47000, "Agen");
//	// List<Client> listeCl = null;
//	// List<Conseiller> listeCons = new ArrayList<Conseiller>();
//	//
//	// Agence agence = null;
//	// Gerant gerant = null;
//	// gerant = new Gerant("Gerant", "gerant", dateGer, adresseGer, 2,
//	// "direction", "111111", "ger", gerant, listeCl,
//	// "1", listeCons, agence);
//	// agence = new Agence(1, "Nantes", dateAg, gerant, "1");
//	//
//	// gerant.setGerant(gerant);
//	// gerant.setAgence(agence);
//	//
//	// Conseiller conseiller = new Conseiller("Toto", "toto", dateCons,
//	// adresseCons, 1, "compta", "123456", "toto",
//	// gerant, listeCl);
//	// listeCons.add(conseiller);
//	//
//	// gerant.setListeConseillers(listeCons);
//	//
//	// CompteCourant cptC = new CompteCourant();
//	// CompteEpargne cptE = new CompteEpargne();
//	//
//	// Client cl = new Client("Soule", "Benjamin", date, adresse, 123,
//	// "0553474147", conseiller, cptE, cptC);
//	//
//	// clientDao.addClient(cl);
//	// }
//
//	public void testGetAllClient() {
//		List<Client> listeCl = clientService.getAllClientsService();
//
//		for (Client cl : listeCl) {
//			System.out.println(cl.getNom());
//		}
//	}
//
//	@Test
//	public void testAjouterClientService() {
//
//		Date date = new Date(1988 + 1900, 11, 7);
//		Date dateCons = new Date(1970 + 1900, 02, 11);
//		Date dateGer = new Date(1970 + 1900, 11, 23);
//		Date dateAg = new Date(2016 + 1900, 11, 22);
//		Adresse adresse = new Adresse("Scorff", 44000, "Orvault");
//		Adresse adresseCons = new Adresse(1, "Remy", 33000, "Bordeaux");
//		Adresse adresseGer = new Adresse(2, "Fleurus", 47000, "Agen");
//		List<Client> listeCl = null;
//		List<Conseiller> listeCons = new ArrayList<Conseiller>();
//
//		Agence agence = null;
//		Gerant gerant = null;
//		gerant = new Gerant("Gerant", "gerant", dateGer, adresseGer, 2, "direction", "111111", "ger", gerant, listeCl,
//				"1", listeCons, agence);
//		agence = new Agence(1, "Nantes", dateAg, gerant, "1");
//
//		gerant.setGerant(gerant);
//		gerant.setAgence(agence);
//
//		Conseiller conseiller = new Conseiller("Toto", "toto", dateCons, adresseCons, 1, "compta", "123456", "toto",
//				gerant, listeCl);
//		listeCons.add(conseiller);
//
//		gerant.setListeConseillers(listeCons);
//
//		CompteCourant cptC = null;
//		CompteEpargne cptE = null;
//
//		Client cl = new Client("Soule", "Toto", date, adresse, 123, "0553474147", conseiller, cptE, cptC);
//
//		// assertEquals(1, clientService.addClientService(cl));
//		clientService.addClientService(cl);
//	}
//
//}
