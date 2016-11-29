//package fr.adaming.serviceTest;
//
//import java.util.Date;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import fr.adaming.model.Carte;
//import fr.adaming.model.Client;
//import fr.adaming.model.Compte;
//import fr.adaming.model.CompteCourant;
//import fr.adaming.model.VisaElectron;
//import fr.adaming.model.VisaPremium;
//import fr.adaming.service.ICarteService;
//import fr.adaming.service.IClientService;
//import fr.adaming.service.ICompteService;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/application-context.xml")
//public class CarteServiceTest {
//	
//	@Autowired
//	private ICarteService<Carte> carteService;
//	
//	@Autowired
//	private ICompteService<Compte> compteService;
//	
//	@Autowired
//	private IClientService clientService;
//	
//	@Before
//	public void beforeTest(){
//		System.out.println("---------------------Avant le test de service carte--------------------------");
//	}
//	
//	@After
//	public void afterTest(){
//		System.out.println("---------------------Après le test de service carte--------------------------");
//	}
//	
//	//@Test
//	public void testAjouterCarte(){
//		
//		Client cl1 = clientService.getClientByIdService(1);
//		CompteCourant cc1 = cl1.getCompteCourant();
//		Date date = new Date(2010 + 1900, 11, 28);
//		VisaElectron vE1 = new VisaElectron("0666", date, "1111", cc1, true, 3000);
//		
//		carteService.ajouterCarteService(vE1);
//	}
//	
//	//@Test
//	public void testSupprimerCarte(){
//		VisaElectron veInit= new VisaElectron();
//		VisaPremium vpInit = new VisaPremium();
//		veInit.setIdVisaElectron(1);
//		vpInit.setIdVisaPremium(1);
//		VisaElectron ve = (VisaElectron) carteService.getCarteByIdService(veInit);
//		VisaPremium vp = (VisaPremium) carteService.getCarteByIdService(vpInit);
//		
//		
//		System.out.println("------------------------Supression-------------------------------------");
//		
//		carteService.supprimerCarteService(ve);
//		carteService.supprimerCarteService(vp);
//	}
//	
//	//@Test
//	public void testModifierCarte(){
//		VisaPremium vp = new VisaPremium();
//		vp.setIdVisaPremium(1);
//		VisaPremium premiumModif = (VisaPremium) carteService.getCarteByIdService(vp);
//		premiumModif.setPlafondRetrait(666);
//		
//		carteService.modifierCarteService(premiumModif);
//		
//		VisaElectron ve = new VisaElectron();
//		ve.setIdVisaElectron(1);
//		VisaElectron electronModif = (VisaElectron) carteService.getCarteByIdService(ve);
//		electronModif.setPlafondCredit(666);
//		
//		
//		carteService.modifierCarteService(electronModif);
//	}
//	
//	public void testGetIdByCompte(){
//		
//	}
//	
//
//}
