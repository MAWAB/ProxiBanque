package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "visaelectrons")
public class VisaElectron extends Carte implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVisaElectron;

	@Temporal(TemporalType.DATE)
	protected Date dateExpiration;

	@OneToOne
	@JoinColumn(name = "compte_id", referencedColumnName = "id_compteC")
	private CompteCourant compteCourant;

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
		super(numeroCarte, codePin, active);
		this.idVisaElectron = idCarte;
		this.dateExpiration = dateExpiration;
		this.plafondCredit = plafondCredit;
		this.compteCourant = compteCourant;
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
		super(numeroCarte, codePin, active);
		this.plafondCredit = plafondCredit;
		this.plafondCredit = plafondCredit;
		this.compteCourant = compteCourant;
	}

	/**
	 * 
	 */
	public VisaElectron() {
		super();
	}

	/**
	 * @return the idVisaElectron
	 */
	public int getIdVisaElectron() {
		return idVisaElectron;
	}

	/**
	 * @param idVisaElectron
	 *            the idVisaElectron to set
	 */
	public void setIdVisaElectron(int idVisaElectron) {
		this.idVisaElectron = idVisaElectron;
	}

	/**
	 * @return the dateExpiration
	 */
	public Date getDateExpiration() {
		return dateExpiration;
	}

	/**
	 * @param dateExpiration
	 *            the dateExpiration to set
	 */
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	/**
	 * @return the compteCourant
	 */
	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	/**
	 * @param compteCourant
	 *            the compteCourant to set
	 */
	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

	/**
	 * @return the plafondCredit
	 */
	public double getPlafondCredit() {
		return plafondCredit;
	}

	/**
	 * @param plafondCredit
	 *            the plafondCredit to set
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
