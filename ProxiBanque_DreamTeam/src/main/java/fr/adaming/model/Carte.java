package fr.adaming.model;

import java.util.Date;

public abstract class Carte {


private long numeroCarte;
private Date dateExpiration;
private int codePin;
private CompteCourant compteCourant;



/* constructeurs */


/**
 * @param numeroCarte
 * @param dateExpiration
 * @param codePin
 * @param compteCourant
 */
public Carte(long numeroCarte, Date dateExpiration, int codePin, CompteCourant compteCourant) {
	super();
	this.numeroCarte = numeroCarte;
	this.dateExpiration = dateExpiration;
	this.codePin = codePin;
	this.compteCourant = compteCourant;
}



/**
 * 
 */
public Carte() {
	super();
}


/* méthodes */

/**
 * @return the numeroCarte
 */
public long getNumeroCarte() {
	return numeroCarte;
}





/**
 * @param numeroCarte the numeroCarte to set
 */
public void setNumeroCarte(long numeroCarte) {
	this.numeroCarte = numeroCarte;
}





/**
 * @return the dateExpiration
 */
public Date getDateExpiration() {
	return dateExpiration;
}





/**
 * @param dateExpiration the dateExpiration to set
 */
public void setDateExpiration(Date dateExpiration) {
	this.dateExpiration = dateExpiration;
}





/**
 * @return the codePin
 */
public int getCodePin() {
	return codePin;
}





/**
 * @param codePin the codePin to set
 */
public void setCodePin(int codePin) {
	this.codePin = codePin;
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


/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Carte [numeroCarte=" + numeroCarte + ", dateExpiration=" + dateExpiration + ", codePin=" + codePin
			+ ", compteCourant=" + compteCourant + "]";
}



}


