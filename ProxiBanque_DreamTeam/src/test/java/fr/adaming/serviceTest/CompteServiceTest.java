package fr.adaming.serviceTest;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.dao.IClientDao;
import fr.adaming.dao.ICompteDao;
import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.VisaElectron;
import fr.adaming.model.VisaPremium;
import fr.adaming.service.ICompteService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/application-context.xml")
public class CompteServiceTest {

	@Autowired
	private ICompteService<Compte> compteService;
	
	@Autowired
	private ICompteDao<Compte> compteDao;
	
	
	@Autowired
	private IClientDao clientDao;
	
		
	/**
	 * @param compteDao the compteDao to set
	 */
	public void setCompteDao(ICompteDao<Compte> compteDao) {
		this.compteDao = compteDao;
	}
	
	
	
	/**
	 * @param clientDao the clientDao to set
	 */
	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}




	@Ignore
	@Test
	public void testAjouterCompteService() {
		

		String numeroCompte="81589";
		double solde=15000;
		int idCompte=2;
		double decouvert=5000;
		Date dateCreation=new Date(2017,12,24);
		
			
		Client client=clientDao.getClientById(1);
		
		CompteCourant compteCourant=null;
		
		VisaElectron visaElectron=new VisaElectron("n5191959carte", dateCreation, "c254Pin", compteCourant, true, 19515619);
		VisaPremium visaPremium=new VisaPremium("n126119carte", dateCreation, "c654Pin", compteCourant, false, 5191);
		
		compteCourant=new CompteCourant(numeroCompte, solde, idCompte, decouvert, dateCreation, client, visaElectron, visaPremium);
		
		
		//assertEquals(1, clientService.addClientService(cl));
		compteService.ajouterCompteService(compteCourant);
	}
	
}
