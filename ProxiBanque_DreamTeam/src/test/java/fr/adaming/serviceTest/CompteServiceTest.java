//package fr.adaming.serviceTest;
//
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import fr.adaming.dao.IClientDao;
//import fr.adaming.dao.ICompteDao;
//import fr.adaming.model.Adresse;
//import fr.adaming.model.Agence;
//import fr.adaming.model.Carte;
//import fr.adaming.model.Client;
//import fr.adaming.model.Compte;
//import fr.adaming.model.CompteCourant;
//import fr.adaming.model.CompteEpargne;
//import fr.adaming.model.Conseiller;
//import fr.adaming.model.Gerant;
//import fr.adaming.model.VisaElectron;
//import fr.adaming.model.VisaPremium;
//import fr.adaming.service.IClientService;
//import fr.adaming.service.ICompteService;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/application-context.xml")
//public class CompteServiceTest {
//
//	@Autowired
//	private ICompteService<Compte> compteService;
//	
//	@Autowired
//	private ICompteDao<Compte> compteDao;	
//
//		
//	/**
//	 * @param compteDao the compteDao to set
//	 */
//	public void setCompteDao(ICompteDao<Compte> compteDao) {
//		this.compteDao = compteDao;
//	}
//	
//	
//	
//	
//	String numeroCompte="81589";
//	double solde=15000;
//	int idCompte=2;
//	double decouvert=5000;
//	
//	@SuppressWarnings("deprecation")
//	Date dateCreation = new Date (1995, 1, 2);
//	Client client=null;
//	VisaElectron visaElectron=null;
//	VisaPremium visaPremium=null;
//	
//	Compte compte=new CompteCourant(numeroCompte, solde, idCompte, decouvert, dateCreation, client, visaElectron, visaPremium);
//	
//	
//	@Test
//	public void testAjouterCompteService() {
//		
//		//assertEquals(1, clientService.addClientService(cl));
//		compteService.ajouterCompteService(compte);
//	}
//	
//}
