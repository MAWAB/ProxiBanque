package fr.adaming.model;

import java.util.Date;

public abstract class Compte {
	
private String numeroCompte;
private double solde;
private Date dateCreation;

/* constructeurs */
/**
 * @param numeroCompte
 * @param solde
 * @param dateCreation
 */

public Compte(String numeroCompte, double solde, Date dateCreation) {
	super();
	this.numeroCompte = numeroCompte;
	this.solde = solde;
	this.dateCreation = dateCreation;
}


/**
 * 
 */
public Compte() {
	super();
}


/* méthodes */



/**
 * @return the numeroCompte
 */
public String getNumeroCompte() {
	return numeroCompte;
}

/**
 * @param numeroCompte the numeroCompte to set
 */
public void setNumeroCompte(String numeroCompte) {
	this.numeroCompte = numeroCompte;
}

/**
 * @return the solde
 */
public double getSolde() {
	return solde;
}

/**
 * @param solde the solde to set
 */
public void setSolde(double solde) {
	this.solde = solde;
}

/**
 * @return the dateCreation
 */
public Date getDateCreation() {
	return dateCreation;
}

/**
 * @param dateCreation the dateCreation to set
 */
public void setDateCreation(Date dateCreation) {
	this.dateCreation = dateCreation;
}


/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Compte [numeroCompte=" + numeroCompte + ", solde=" + solde + ", dateCreation=" + dateCreation + "]";
}



}
