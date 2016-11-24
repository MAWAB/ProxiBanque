package fr.adaming.model;

import java.util.Date;

public class VisaPremium extends Carte{

private String plafondRetrait;

/**
 * @param idCarte
 * @param numeroCarte
 * @param dateExpiration
 * @param codePin
 * @param compteCourant
 * @param active
 * @param plafondRetrait
 */
public VisaPremium(int idCarte, String numeroCarte, Date dateExpiration, String codePin, CompteCourant compteCourant,
		Boolean active, String plafondRetrait) {
	super(idCarte, numeroCarte, dateExpiration, codePin, compteCourant, active);
	this.plafondRetrait = plafondRetrait;
}

/**
 * @param numeroCarte
 * @param dateExpiration
 * @param codePin
 * @param compteCourant
 * @param active
 * @param plafondRetrait
 */
public VisaPremium(String numeroCarte, Date dateExpiration, String codePin, CompteCourant compteCourant, Boolean active,
		String plafondRetrait) {
	super(numeroCarte, dateExpiration, codePin, compteCourant, active);
	this.plafondRetrait = plafondRetrait;
}

/**
 * 
 */
public VisaPremium() {
	super();
}

/**
 * @return the plafondRetrait
 */
public String getPlafondRetrait() {
	return plafondRetrait;
}

/**
 * @param plafondRetrait the plafondRetrait to set
 */
public void setPlafondRetrait(String plafondRetrait) {
	this.plafondRetrait = plafondRetrait;
}

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "VisaPremium [plafondRetrait=" + plafondRetrait + "]";
}


}
