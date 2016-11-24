package fr.adaming.model;

import java.util.Date;

public class Client extends Personne{
	
	
private int idClient;
private int numeroClient;
private String telephone;
private Conseiller conseiller;
private CompteEpargne compteEpargne;
private CompteCourant compteCourant;


/**
 * @param nom
 * @param prenom
 * @param dateDeNaissance
 * @param adresse
 * @param idClient
 * @param numeroClient
 * @param telephone
 * @param conseiller
 * @param compteEpargne
 * @param compteCourant
 */
public Client(String nom, String prenom, Date dateDeNaissance, Adresse adresse, int idClient, int numeroClient,
		String telephone, Conseiller conseiller, CompteEpargne compteEpargne, CompteCourant compteCourant) {
	super(nom, prenom, dateDeNaissance, adresse);
	this.idClient = idClient;
	this.numeroClient = numeroClient;
	this.telephone = telephone;
	this.conseiller = conseiller;
	this.compteEpargne = compteEpargne;
	this.compteCourant = compteCourant;
}


/**
 * @param nom
 * @param prenom
 * @param dateDeNaissance
 * @param adresse
 * @param numeroClient
 * @param telephone
 * @param conseiller
 * @param compteEpargne
 * @param compteCourant
 */
public Client(String nom, String prenom, Date dateDeNaissance, Adresse adresse, int numeroClient, String telephone,
		Conseiller conseiller, CompteEpargne compteEpargne, CompteCourant compteCourant) {
	super(nom, prenom, dateDeNaissance, adresse);
	this.numeroClient = numeroClient;
	this.telephone = telephone;
	this.conseiller = conseiller;
	this.compteEpargne = compteEpargne;
	this.compteCourant = compteCourant;
}


/**
 * 
 */
public Client() {
	super();
}


/**
 * @return the idClient
 */
public int getIdClient() {
	return idClient;
}


/**
 * @param idClient the idClient to set
 */
public void setIdClient(int idClient) {
	this.idClient = idClient;
}


/**
 * @return the numeroClient
 */
public int getNumeroClient() {
	return numeroClient;
}


/**
 * @param numeroClient the numeroClient to set
 */
public void setNumeroClient(int numeroClient) {
	this.numeroClient = numeroClient;
}


/**
 * @return the telephone
 */
public String getTelephone() {
	return telephone;
}


/**
 * @param telephone the telephone to set
 */
public void setTelephone(String telephone) {
	this.telephone = telephone;
}


/**
 * @return the conseiller
 */
public Conseiller getConseiller() {
	return conseiller;
}


/**
 * @param conseiller the conseiller to set
 */
public void setConseiller(Conseiller conseiller) {
	this.conseiller = conseiller;
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









}
