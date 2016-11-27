package fr.adaming.serviceTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.dao.IClientDao;
import fr.adaming.dao.ICompteDao;
import fr.adaming.model.Adresse;
import fr.adaming.model.Agence;
import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Gerant;
import fr.adaming.model.VisaElectron;
import fr.adaming.model.VisaPremium;
import fr.adaming.service.ICompteService;


public class CompteServiceTest {

	@Autowired
	private ICompteService<Compte> compteService;
		
	public static void main(String[] args) {
		
		ApplicationContext cxt=new FileSystemXmlApplicationContext("C:\\Users\\inti0226\\git\\ProxiBanque1\\ProxiBanque_DreamTeam\\src\\main\\webapp\\WEB-INF\\application-context.xml");
		
		ICompteService<Compte> compteService=(ICompteService<Compte>) cxt.getBean("cmpServiceBean");
		

		String numeroCompte="81589";
		double solde=15000;
		int idCompte=12;
		double decouvert=5000;
		@SuppressWarnings("deprecation")
		Date dateCreation=new Date(2017,12,24);
		
///////////////////////////////////////////////
		Date date = new Date(1988 + 1900, 11, 7);
		Date dateCons = new Date(1970 + 1900, 02, 11);
		Date dateGer = new Date(1970 + 1900, 11, 23);
		Date dateAg = new Date(2016 + 1900, 11, 22);

		Adresse adresse = new Adresse("Sco", 44000, "Orvault");
		Adresse adresseCons = new Adresse(1, "Remy", 33000, "Bordeaux");
		Adresse adresseGer = new Adresse(2, "Fleurus", 47000, "Agen");

		List<Client> listeCl = null;
		List<Conseiller> listeCons = new ArrayList<Conseiller>();

		Agence agence = null;
		Gerant gerant = null;
		gerant = new Gerant("Gerant", "gerant", dateGer, adresseGer, 2, "direction", "111111", "ger", gerant, listeCl,
				"1", listeCons, agence);
		agence = new Agence(1, "Nantes", dateAg, gerant, "1");

		gerant.setGerant(gerant);
		gerant.setAgence(agence);

		Conseiller conseiller = new Conseiller("Toto", "toto", dateCons, adresseCons, 1, "compta", "123456", "toto",
				gerant, listeCl);
		listeCons.add(conseiller);

		gerant.setListeConseillers(listeCons);

		Client cl = new Client("Soule", "Toto", date, adresse, 123, "0553474147", conseiller);
///////////////////////////////////////////////
		
		CompteCourant compteCourant=null;
		
		VisaElectron visaElectron=new VisaElectron("n5191959carte", dateCreation, "c254Pin", compteCourant, true, 19515619);
		VisaPremium visaPremium=new VisaPremium("n126119carte", dateCreation, "c654Pin", compteCourant, false, 5191);
		
		compteCourant=new CompteCourant(numeroCompte, solde, idCompte, decouvert, dateCreation, cl, visaElectron, visaPremium);
		
		
		compteService.ajouterCompteService(compteCourant);
	}
	
	
}
