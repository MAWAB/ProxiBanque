package fr.adaming.serviceTest;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.model.Conseiller;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/resources/application-context.xml"})
public class ConseillerServiceTest {

	
	@Autowired
	Conseiller conseiller;
	
	
	@BeforeClass
	public static void beforeCTest() {
		System.out.println("-----------------------Début des tests----------------");
	}
	
	@Before
	public void beforeTest() {
		System.out.println("-----------------------Dans la méthode beforeTest()-----------------");
	}
	
	@After
	public void afterTest() {
		System.out.println("-----------------------Dans la méthode afterTest()------------------");
	}
	
	@AfterClass
	public static void afterCTest() {
		System.out.println("-----------------------Dans la méthode afterCTest()-----------------");
	}
	
}
