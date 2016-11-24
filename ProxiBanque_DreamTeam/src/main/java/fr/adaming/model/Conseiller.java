package fr.adaming.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Conseiller extends Personne{
private int id;
private String nomDuService;
private String numeroImmatriculation;
private String numeroBureau;

//transormer l'agregation entre le conseiller et le gerant
	private Gerant gerant;
	
//transormer l'agregation entre le conseiller et le gerant
		private List<Client> listeClients=new ArrayList<Client>();
		
		/* constructeurs */

/**
 * @param id
 * @param nomDuService
 * @param numeroImmatriculation
 * @param numeroBureau
 * @param gerant
 * @param listeClients
 */
public Conseiller(int id, String nomDuService, String numeroImmatriculation, String numeroBureau, Gerant gerant,
		List<Client> listeClients) {
	super();
	this.id = id;
	this.nomDuService = nomDuService;
	this.numeroImmatriculation = numeroImmatriculation;
	this.numeroBureau = numeroBureau;
	this.gerant = gerant;
	this.listeClients = listeClients;
}

/**
 * @param nomDuService
 * @param numeroImmatriculation
 * @param numeroBureau
 * @param gerant
 * @param listeClients
 */
public Conseiller(String nomDuService, String numeroImmatriculation, String numeroBureau, Gerant gerant,
		List<Client> listeClients) {
	super();
	this.nomDuService = nomDuService;
	this.numeroImmatriculation = numeroImmatriculation;
	this.numeroBureau = numeroBureau;
	this.gerant = gerant;
	this.listeClients = listeClients;
}

/**
 * 
 */
public Conseiller() {
	super();
}

/* méthodes */

/**
 * @return the id
 */
public int getId() {
	return id;
}

/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}

/**
 * @return the nomDuService
 */
public String getNomDuService() {
	return nomDuService;
}

/**
 * @param nomDuService the nomDuService to set
 */
public void setNomDuService(String nomDuService) {
	this.nomDuService = nomDuService;
}

/**
 * @return the numeroImmatriculation
 */
public String getNumeroImmatriculation() {
	return numeroImmatriculation;
}

/**
 * @param numeroImmatriculation the numeroImmatriculation to set
 */
public void setNumeroImmatriculation(String numeroImmatriculation) {
	this.numeroImmatriculation = numeroImmatriculation;
}

/**
 * @return the numeroBureau
 */
public String getNumeroBureau() {
	return numeroBureau;
}

/**
 * @param numeroBureau the numeroBureau to set
 */
public void setNumeroBureau(String numeroBureau) {
	this.numeroBureau = numeroBureau;
}

/**
 * @return the gerant
 */
public Gerant getGerant() {
	return gerant;
}

/**
 * @param gerant the gerant to set
 */
public void setGerant(Gerant gerant) {
	this.gerant = gerant;
}

/**
 * @return the listeClients
 */
public List<Client> getListeClients() {
	return listeClients;
}

/**
 * @param listeClients the listeClients to set
 */
public void setListeClients(List<Client> listeClients) {
	this.listeClients = listeClients;
}

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Conseiller [id=" + id + ", nomDuService=" + nomDuService + ", numeroImmatriculation="
			+ numeroImmatriculation + ", numeroBureau=" + numeroBureau + ", gerant=" + gerant + ", listeClients="
			+ listeClients + "]";
}

		
		
}
