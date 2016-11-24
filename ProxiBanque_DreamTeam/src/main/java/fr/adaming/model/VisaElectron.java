package fr.adaming.model;

import java.util.Date;

public class VisaElectron extends Carte{
	private int id;
	private double plafond;
	
	
	/* constructeurs */
	
	
	/**
	 * @param numeroCarte
	 * @param dateExpiration
	 * @param codePin
	 * @param compteCourant
	 * @param id
	 * @param plafond
	 */
	public VisaElectron(long numeroCarte, Date dateExpiration, int codePin, CompteCourant compteCourant, int id,
			double plafond) {
		super(numeroCarte, dateExpiration, codePin, compteCourant);
		this.id = id;
		this.plafond = plafond;
	}
	/**
	 * @param numeroCarte
	 * @param dateExpiration
	 * @param codePin
	 * @param compteCourant
	 * @param plafond
	 */
	public VisaElectron(long numeroCarte, Date dateExpiration, int codePin, CompteCourant compteCourant,
			double plafond) {
		super(numeroCarte, dateExpiration, codePin, compteCourant);
		this.plafond = plafond;
	}
	/**
	 * @param numeroCarte
	 * @param dateExpiration
	 * @param codePin
	 * @param compteCourant
	 */
	public VisaElectron(long numeroCarte, Date dateExpiration, int codePin, CompteCourant compteCourant) {
		super(numeroCarte, dateExpiration, codePin, compteCourant);
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
	 * @return the plafond
	 */
	public double getPlafond() {
		return plafond;
	}
	/**
	 * @param plafond the plafond to set
	 */
	public void setPlafond(double plafond) {
		this.plafond = plafond;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "VisaElectron [id=" + id + ", plafond=" + plafond + "]";
	}
	

	
}
