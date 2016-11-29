package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.model.menu.MenuModel;

import fr.adaming.model.Carte;
import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.CompteEpargne;
import fr.adaming.model.VisaElectron;
import fr.adaming.model.VisaPremium;
import fr.adaming.service.ICarteService;
import fr.adaming.service.ICompteService;

@ManagedBean(name = "compte2MB")
@ViewScoped
public class Compte_2ManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@ManagedProperty(value="#{cmpServiceBean}")
	ICompteService<Compte> compteService;
	
//	@ManagedProperty(value="#{carteService}")
//	ICarteService<Carte> carteService;
	
	private Client client;
	private CompteEpargne compteEpargne;
	private CompteCourant compteCourant;
	private int carte=0;
	private VisaElectron visaElectron;
	private VisaPremium visaPremium;
	
	HttpSession session;

	// Getters & Setters ------------------------------------------------------------------------------------
	
	/**
	 * @return the compteService
	 */
	public ICompteService<Compte> getCompteService() {
		return compteService;
	}


	/**
	 * @param compteService the compteService to set
	 */
	public void setCompteService(ICompteService<Compte> compteService) {
		this.compteService = compteService;
	}


	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}


	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	


	/**
	 * @return the compteEpargne
	 */
	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}


	/**
	 * @param compteEpargne the compteEpargne to set
	 */
	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}


	/**
	 * @return the compteCourant
	 */
	public CompteCourant getCompteCourant() {
		return compteCourant;
	}


	/**
	 * @param compteCourant the compteCourant to set
	 */
	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}


	/**
	 * @return the carte
	 */
	public int getCarte() {
		return carte;
	}


	/**
	 * @param carte the carte to set
	 */
	public void setCarte(int carte) {
		this.carte = carte;
	}
	

	/**
	 * @return the visaElectron
	 */
	public VisaElectron getVisaElectron() {
		return visaElectron;
	}


	/**
	 * @param visaElectron the visaElectron to set
	 */
	public void setVisaElectron(VisaElectron visaElectron) {
		this.visaElectron = visaElectron;
	}


	/**
	 * @return the visaPremium
	 */
	public VisaPremium getVisaPremium() {
		return visaPremium;
	}


	/**
	 * @param visaPremium the visaPremium to set
	 */
	public void setVisaPremium(VisaPremium visaPremium) {
		this.visaPremium = visaPremium;
	}


	// Init ------------------------------------------------------------------------------------------------------------
	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		session = (HttpSession) facesContext.getExternalContext().getSession(false);
		this.client = (Client) session.getAttribute("client");
		
		this.compteCourant = new CompteCourant();
		this.compteEpargne = new CompteEpargne();
		this.visaElectron = new VisaElectron();
		this.visaPremium = new VisaPremium();
	}
	

	// Constructeur vide -----------------------------------------------------------------------------------------------
	public Compte_2ManagedBean() {
		super();
	}
	
	
	// Méthodes --------------------------------------------------------------------------------------------------------
	
	public String addCompteEpargne() {
		
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();
		compteEpargne.setDateCreation(date);
		compteEpargne.setSolde(0);
		compteEpargne.setClient(client);
		
		compteService.ajouterCompteService(compteEpargne);
		
		return "infosClient.xhtml";
	}
	
	
//	public String addCompteCourant() {
//		
//		Calendar c = Calendar.getInstance();
//		Date dateJour = c.getTime();
//		
//		compteCourant.setDateCreation(dateJour);
//		compteCourant.setSolde(0);
//		compteCourant.setClient(client);
//		
//		if (carte == 1) {
//			
//			visaElectron.setActive(true);
//			carteService.ajouterCarteService(visaElectron);
//			compteCourant.setVisaElectron(visaElectron);
//			
//		} else if (carte == 2) {
//			
//			visaPremium.setActive(true);
//			carteService.ajouterCarteService(visaPremium);
//			compteCourant.setVisaPremium(visaPremium);
//		}
//		
//		compteService.ajouterCompteService(compteCourant);
//		
//		return "infoClient.xhtml";
//	}

	
	public String deleteCompte() {
		
		
		
		return "infosClient.xhtml";
	}
	
	public String retirer() {
		
		return "infosClient.xhtml";
	}
	
	public String deposer() {
		
		return "infosClient.xhtml";
	}
	
//------------------------------Willem-------------------------------------//	
	
	private CompteCourant compteCourant1=new CompteCourant();
	private CompteCourant compteCourant2=new CompteCourant();
	private double somme;
	private int compte1;
	private int compte2;
	private int id_compte1;
	private int id_compte2;
	
	

		
	/**
	 * @return the compteCourant1
	 */
	public CompteCourant getCompteCourant1() {
		return compteCourant1;
	}


	/**
	 * @param compteCourant1 the compteCourant1 to set
	 */
	public void setCompteCourant1(CompteCourant compteCourant1) {
		this.compteCourant1 = compteCourant1;
	}


	/**
	 * @return the compteCourant2
	 */
	public CompteCourant getCompteCourant2() {
		return compteCourant2;
	}


	/**
	 * @param compteCourant2 the compteCourant2 to set
	 */
	public void setCompteCourant2(CompteCourant compteCourant2) {
		this.compteCourant2 = compteCourant2;
	}


	/**
	 * @return the somme
	 */
	public double getSomme() {
		return somme;
	}


	/**
	 * @param somme the somme to set
	 */
	public void setSomme(double somme) {
		this.somme = somme;
	}


	/**
	 * @return the compte1
	 */
	public int getCompte1() {
		return compte1;
	}


	/**
	 * @param compte1 the compte1 to set
	 */
	public void setCompte1(int compte1) {
		this.compte1 = compte1;
	}


	/**
	 * @return the compte2
	 */
	public int getCompte2() {
		return compte2;
	}


	/**
	 * @param compte2 the compte2 to set
	 */
	public void setCompte2(int compte2) {
		this.compte2 = compte2;
	}


	/**
	 * @return the id_compte1
	 */
	public int getId_compte1() {
		return id_compte1;
	}


	/**
	 * @param id_compte1 the id_compte1 to set
	 */
	public void setId_compte1(int id_compte1) {
		this.id_compte1 = id_compte1;
	}


	/**
	 * @return the id_compte2
	 */
	public int getId_compte2() {
		return id_compte2;
	}


	/**
	 * @param id_compte2 the id_compte2 to set
	 */
	public void setId_compte2(int id_compte2) {
		this.id_compte2 = id_compte2;
	}


	


	public String rechercheComptesVir() {
		
		CompteCourant cc=new CompteCourant();
		CompteEpargne ce=new CompteEpargne();
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		session = (HttpSession) facesContext.getExternalContext().getSession(false);
		session.setAttribute("compte1", compte1);
		session.setAttribute("compte2", compte2);
		
		if(compte1==1 && compte2==1){	
			cc.setIdCompte(id_compte1);
			compteCourant1=(CompteCourant) compteService.getCompteByIdService(cc);
			
			cc.setIdCompte(id_compte2);
			compteCourant2=(CompteCourant) compteService.getCompteByIdService(cc);
			
			session.setAttribute("compteCourant1", compteCourant1);
			session.setAttribute("compteCourant2", compteCourant2);
			
			
		}else if(compte1==1 && compte2==2){
			cc.setIdCompte(id_compte1);
			compteCourant1=(CompteCourant) compteService.getCompteByIdService(cc);
			
			ce.setIdCompte(id_compte2);
			compteEpargne=(CompteEpargne) compteService.getCompteByIdService(ce);
			
			session.setAttribute("compteCourant1", compteCourant1);
			session.setAttribute("compteEpargne", compteEpargne);
			
		}else if(compte1==2 && compte2==1){
			ce.setIdCompte(id_compte1);
			compteEpargne=(CompteEpargne) compteService.getCompteByIdService(ce);
			
			cc.setIdCompte(id_compte2);
			compteCourant1=(CompteCourant) compteService.getCompteByIdService(cc);

			session.setAttribute("compteEpargne", compteEpargne);
			session.setAttribute("compteCourant1", compteCourant1);
		}
		
		
		return "virement.xhtml";
	}
	
	
	public String virer() {
		this.compte1=(int) session.getAttribute("compte1");
		this.compte2=(int) session.getAttribute("compte2");
				
		
		if(compte1==1 && compte2==1){
			this.compteCourant1=(CompteCourant) session.getAttribute("compteCourant1");
			this.compteCourant2=(CompteCourant) session.getAttribute("compteCourant2");
			
			compteService.virementService(compteCourant1, compteCourant2, somme);			
			
		}else if(compte1==1 && compte2==2){
			this.compteCourant1=(CompteCourant) session.getAttribute("compteCourant1");
			this.compteEpargne=(CompteEpargne) session.getAttribute("compteEpargne");
			
			compteService.virementService(compteCourant1, compteEpargne, somme);
			
		}else if(compte1==2 && compte2==1){
			this.compteEpargne=(CompteEpargne) session.getAttribute("compteEpargne");
			this.compteCourant1=(CompteCourant) session.getAttribute("compteCourant1");
			
			compteService.virementService(compteEpargne, compteCourant1, somme);
			
		}
		return "accueilConseiller.xhtml";
	}
	
}
