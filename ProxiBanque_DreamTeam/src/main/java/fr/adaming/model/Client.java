package fr.adaming.model;

import java.util.Date;

public class Client extends Personne{
	
	
private int id;
private int numeroClient;
private String telephone;


/* constructeurs*/


/**
 * @param id
 * @param numeroClient
 * @param telephone
 */
public Client(int id, int numeroClient, String telephone) {
	super();
	this.id = id;
	this.numeroClient = numeroClient;
	this.telephone = telephone;
}
/**
 * @param numeroClient
 * @param telephone
 */
public Client(int numeroClient, String telephone) {
	super();
	this.numeroClient = numeroClient;
	this.telephone = telephone;
}
/**
 * 
 */
public Client() {
	super();
}

/* getters et setters */


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
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Client [id=" + id + ", numeroClient=" + numeroClient + ", telephone=" + telephone + "]";
}


}
