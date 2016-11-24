package fr.adaming.model;

import java.util.Date;

public class VisaElectron extends Carte{

	private double plafondCredit;

	/**
	 * @param idCarte
	 * @param numeroCarte
	 * @param dateExpiration
	 * @param codePin
	 * @param compteCourant
	 * @param active
	 * @param plafondCredit
	 */
	public VisaElectron(int idCarte, String numeroCarte, Date dateExpiration, String codePin,
			CompteCourant compteCourant, Boolean active, double plafondCredit) {
		super(idCarte, numeroCarte, dateExpiration, codePin, compteCourant, active);
		this.plafondCredit = plafondCredit;
	}

	/**
	 * @param numeroCarte
	 * @param dateExpiration
	 * @param codePin
	 * @param compteCourant
	 * @param active
	 * @param plafondCredit
	 */
	public VisaElectron(String numeroCarte, Date dateExpiration, String codePin, CompteCourant compteCourant,
			Boolean active, double plafondCredit) {
		super(numeroCarte, dateExpiration, codePin, compteCourant, active);
		this.plafondCredit = plafondCredit;
	}

	/**
	 * 
	 */
	public VisaElectron() {
		super();
	}

	/**
	 * @return the plafondCredit
	 */
	public double getPlafondCredit() {
		return plafondCredit;
	}

	/**
	 * @param plafondCredit the plafondCredit to set
	 */
	public void setPlafondCredit(double plafondCredit) {
		this.plafondCredit = plafondCredit;
	}

	/**
	 * @param plafondCredit
	 */
	public VisaElectron(double plafondCredit) {
		super();
		this.plafondCredit = plafondCredit;
	}
	
	
}
