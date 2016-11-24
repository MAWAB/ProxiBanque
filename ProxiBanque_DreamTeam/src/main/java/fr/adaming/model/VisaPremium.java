package fr.adaming.model;

import java.util.Date;

public class VisaPremium extends Carte{

private String plafondRetrait;
/**
 * @param numeroCarte
 * @param dateExpiration
 * @param codePin
 * @param compteCourant
 * @param id
 * @param nomAssurance
 */
public VisaPremium(long numeroCarte, Date dateExpiration, int codePin, CompteCourant compteCourant, int id,
		String nomAssurance) {
	super(numeroCarte, dateExpiration, codePin, compteCourant);
	this.id = id;
	this.nomAssurance = nomAssurance;
}
/**
 * @param numeroCarte
 * @param dateExpiration
 * @param codePin
 * @param compteCourant
 * @param nomAssurance
 */
public VisaPremium(long numeroCarte, Date dateExpiration, int codePin, CompteCourant compteCourant,
		String nomAssurance) {
	super(numeroCarte, dateExpiration, codePin, compteCourant);
	this.nomAssurance = nomAssurance;
}
/**
 * @param numeroCarte
 * @param dateExpiration
 * @param codePin
 * @param compteCourant
 */
public VisaPremium(long numeroCarte, Date dateExpiration, int codePin, CompteCourant compteCourant) {
	super(numeroCarte, dateExpiration, codePin, compteCourant);
}
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
 * @return the nomAssurance
 */
public String getNomAssurance() {
	return nomAssurance;
}
/**
 * @param nomAssurance the nomAssurance to set
 */
public void setNomAssurance(String nomAssurance) {
	this.nomAssurance = nomAssurance;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "VisaPremium [id=" + id + ", nomAssurance=" + nomAssurance + "]";
}




}
