package fr.adaming.serviceTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.model.Conseiller;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class ConseillerServiceTest {

	
	@Autowired
	Conseiller conseiller;
	
	
	@BeforeClass
	public static void beforeCTest() {
		System.out.println("-----------------------Début des tests----------------\n");
	}
	

	
	@AfterClass
	public static void afterCTest() {
		System.out.println("-----------------------Dans des tests-----------------\n");
	}
	
	
	
}
