//package fr.adaming.serviceTest;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import fr.adaming.dao.IClientDao;
//import fr.adaming.dao.ICompteDao;
//import fr.adaming.model.Adresse;
//import fr.adaming.model.Agence;
//import fr.adaming.model.Client;
//import fr.adaming.model.Compte;
//import fr.adaming.model.CompteCourant;
//import fr.adaming.model.CompteEpargne;
//import fr.adaming.model.Conseiller;
//import fr.adaming.model.Gerant;
//import fr.adaming.model.VisaElectron;
//import fr.adaming.model.VisaPremium;
//import fr.adaming.service.ClientServiceImpl;
//import fr.adaming.service.IClientService;
//import fr.adaming.service.ICompteService;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/application-context.xml")
//public class CompteServiceTest {
//
//	@Autowired
//	private ICompteService<Compte> compteService;
//	
//	@Autowired
//	private IClientService clientService;
//	
//	
//	public void testAjouterCompteService() {
//
//		Client cl = clientService.getClientByIdService(1);
//		
//		Date date = new Date(1988 + 1900, 11, 7);
//		
//		CompteCourant cptC = new CompteCourant("0123", 1000, 300, date, cl);
//		
//		compteService.ajouterCompteService(cptC);
//	}
//	
//	@Test
//	public void testSupprimerCompteService() {
//
//		CompteCourant cptC = (CompteCourant) compteService.getComptesCourantByIdClientService(1);
//		compteService.supprimerCompteService(cptC);
//	}
//	
////			
////	public static void main(String[] args) {
////		
////		ApplicationContext cxt=new FileSystemXmlApplicationContext("C:\\Users\\inti0226\\git\\ProxiBanque1\\ProxiBanque_DreamTeam\\src\\main\\webapp\\WEB-INF\\application-context.xml");
////		
////		ICompteService<Compte> compteService=(ICompteService<Compte>) cxt.getBean("cmpServiceBean");
////		IClientService clientService=(IClientService) cxt.getBean("clientServiceImpl");
////
////		String numeroCompte="81589";
////		double solde=15000;
////		int idCompte=12;
////		double decouvert=5000;
////		
////		Date dateCreation=new Date(2017,12,24);
//		
///////////////////////////////////////////////////
////		Date date = new Date(1988 + 1900, 11, 7);
////		Date dateCons = new Date(1970 + 1900, 02, 11);
////		Date dateGer = new Date(1970 + 1900, 11, 23);
////		Date dateAg = new Date(2016 + 1900, 11, 22);
////
////		Adresse adresse = new Adresse("Sco", 44000, "Orvault");
////		Adresse adresseCons = new Adresse(1, "Remy", 33000, "Bordeaux");
////		Adresse adresseGer = new Adresse(2, "Fleurus", 47000, "Agen");
////
////		List<Client> listeCl = null;
////		List<Conseiller> listeCons = new ArrayList<Conseiller>();
////
////		Agence agence = null;
////		Gerant gerant = null;
////		gerant = new Gerant("Gerant", "gerant", dateGer, adresseGer, 2, "direction", "111111", "ger", gerant, listeCl,
////				"1", listeCons, agence);
////		agence = new Agence(1, "Nantes", dateAg, gerant, "1");
////
////		gerant.setGerant(gerant);
////		gerant.setAgence(agence);
////
////		Conseiller conseiller = new Conseiller("Toto", "toto", dateCons, adresseCons, 1, "compta", "123456", "toto",
////				gerant, listeCl);
////		listeCons.add(conseiller);
////
////		gerant.setListeConseillers(listeCons);
////
////		Client cl = new Client("Soule", "Toto", date, adresse, 123, "0553474147", conseiller);
//		
////		Client client=clientService.getClientByIdService(1);
//		
/////////////////////////////////////////////////
//		
////		CompteCourant compteCourant=null;
////		
////		VisaElectron visaElectron=new VisaElectron("n5191959carte", dateCreation, "c254Pin", compteCourant, true, 19515619);
////		VisaPremium visaPremium=new VisaPremium("n126119carte", dateCreation, "c654Pin", compteCourant, false, 5191);
////		
////		compteCourant=new CompteCourant(numeroCompte, solde, idCompte, decouvert, dateCreation, cl, visaElectron, visaPremium);
////		
////		CompteEpargne compteEpargne=new CompteEpargne(numeroCompte, solde, idCompte, 4, dateCreation, client);
//		
//		
//		
////----------------------------------Modifier--------------------------------------//		
////		CompteCourant compteCourant=new CompteCourant();
////		compteCourant.setIdCompte(1);
////		CompteCourant compModif=(CompteCourant) compteService.getCompteByIdService(compteCourant);
////		compModif.setSolde(solde);
////		
////		compteService.modifierCompteService(compModif);
////		System.out.println(compteService.getCompteByIdService(compteCourant));
////		
////		
////		CompteEpargne compteEpargne=new CompteEpargne();
////		compteEpargne.setIdCompte(1);
////		CompteEpargne compModif=(CompteEpargne) compteService.getCompteByIdService(compteEpargne);
////		compModif.setSolde(solde);
////		
////		compteService.modifierCompteService(compModif);
////		System.out.println(compteService.getCompteByIdService(compteEpargne));
//		
//		
////----------------------------------Supprimer--------------------------------------//
////		CompteEpargne compteEpargne=new CompteEpargne();
////		compteEpargne.setIdCompte(1);
////		
////		compteService.supprimerCompteService(compteEpargne);
////		
////		
////		CompteCourant compteCourant=new CompteCourant();
////		compteCourant.setIdCompte(1);
////		
////		compteService.supprimerCompteService(compteCourant);
//		
//		
////----------------------------------Retrait--------------------------------------//		
////		double somme=15000;
////		CompteCourant compteCourant=new CompteCourant();
////		compteCourant.setIdCompte(1);
////		CompteCourant cmp=(CompteCourant) compteService.getCompteByIdService(compteCourant);
////		
////		
////		compteService.retraitService(cmp, somme);
////		System.out.println(compteService.getCompteByIdService(compteCourant));
////		
////		
////		double somme=15000;
////		CompteEpargne compteEpargne=new CompteEpargne();
////		compteEpargne.setIdCompte(1);
////		CompteEpargne cmp=(CompteEpargne) compteService.getCompteByIdService(compteEpargne);
////		
////		
////		compteService.retraitService(cmp, somme);
////		System.out.println(compteService.getCompteByIdService(compteEpargne));
//		
//
////----------------------------------Depot--------------------------------------//		
////		double somme=15000;
////		CompteCourant compteCourant=new CompteCourant();
////		compteCourant.setIdCompte(1);
////		CompteCourant cmp=(CompteCourant) compteService.getCompteByIdService(compteCourant);
////		
////		
////		compteService.depotService(cmp, somme);
////		System.out.println(compteService.getCompteByIdService(compteCourant));
////		
////		
////		double somme=15000;
////		CompteEpargne compteEpargne=new CompteEpargne();
////		compteEpargne.setIdCompte(1);
////		CompteEpargne cmp=(CompteEpargne) compteService.getCompteByIdService(compteEpargne);
////		
////		
////		compteService.depotService(cmp, somme);
////		System.out.println(compteService.getCompteByIdService(compteEpargne));
//
//		
////----------------------------------Virement--------------------------------------//		
////		double somme=15000;
////		CompteCourant compteCourant1=new CompteCourant();
////		compteCourant1.setIdCompte(1);
////		CompteCourant compte1=(CompteCourant) compteService.getCompteByIdService(compteCourant1);
////		
////		CompteCourant compteCourant2=new CompteCourant();
////		compteCourant2.setIdCompte(2);
////		CompteCourant compte2=(CompteCourant) compteService.getCompteByIdService(compteCourant2);
////		
////		CompteEpargne compteEpargne1=new CompteEpargne();
////		compteEpargne1.setIdCompte(1);
////		CompteEpargne compte1=(CompteEpargne) compteService.getCompteByIdService(compteEpargne1);		
////		
////		CompteEpargne compteEpargne2=new CompteEpargne();
////		compteEpargne2.setIdCompte(2);
////		CompteEpargne compte2=(CompteEpargne) compteService.getCompteByIdService(compteEpargne2);
////				
////		compteService.virementService(compte1, compte2, somme);
////		
////
////		
////	}
//	
//	
//}
