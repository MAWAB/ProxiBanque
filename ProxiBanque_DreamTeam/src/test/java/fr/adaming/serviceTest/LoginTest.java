//package fr.adaming.serviceTest;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import fr.adaming.model.Adresse;
//import fr.adaming.model.Client;
//import fr.adaming.model.Conseiller;
//import fr.adaming.model.Gerant;
//import fr.adaming.service.IConseillerService;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
//public class LoginTest {
//	
//	@Autowired
//	IConseillerService conseillerService;
//	
//	@BeforeClass
//	public static void beforeTest(){
//		System.out.println("-----------------Avant les tests------------------");
//	}
//	
//	public static void afterTest(){
//		System.out.println("-----------------Après les tests------------------");
//	}
//	
//	
//	
//	@Test
//	public void testLogin(){
//
//		
//		int i = conseillerService.isExistService("3", "j");
//		
//		System.out.println(i);
//		
//	}
//
//}
