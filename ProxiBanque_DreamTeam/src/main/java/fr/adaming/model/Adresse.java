package fr.adaming.model;

public class Adresse {
	
private int id;
private String rue;
private int codePostal;

/* constructeurs */


/**
 * @param id
 * @param rue
 * @param codePostal
 */
public Adresse(int id, String rue, int codePostal) {
	super();
	this.id = id;
	this.rue = rue;
	this.codePostal = codePostal;
}
/**
 * @param rue
 * @param codePostal
 */
public Adresse(String rue, int codePostal) {
	super();
	this.rue = rue;
	this.codePostal = codePostal;
}
/**
 * 
 */
public Adresse() {
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
 * @return the rue
 */
public String getRue() {
	return rue;
}
/**
 * @param rue the rue to set
 */
public void setRue(String rue) {
	this.rue = rue;
}
/**
 * @return the codePostal
 */
public int getCodePostal() {
	return codePostal;
}
/**
 * @param codePostal the codePostal to set
 */
public void setCodePostal(int codePostal) {
	this.codePostal = codePostal;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Adresse [id=" + id + ", rue=" + rue + ", codePostal=" + codePostal + "]";
}




}
