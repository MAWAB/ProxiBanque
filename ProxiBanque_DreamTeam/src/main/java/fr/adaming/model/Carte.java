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
@Table(name="cartes")
public abstract class Carte implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int idCarte;
	protected String numeroCarte;
	
	@Temporal(TemporalType.DATE)
	protected Date dateExpiration;
	protected String codePin;
	
	@OneToOne
	@JoinColumn(name="compe_id", referencedColumnName="id_compteC")
	protected CompteCourant compteCourant;
	protected Boolean active;

	/* constructeurs */

	/**
	 * 
	 */
	public Carte() {
		super();
	}

	/**
	 * @param numeroCarte
	 * @param dateExpiration
	 * @param codePin
	 * @param compteCourant
	 * @param active
	 */
	public Carte(String numeroCarte, Date dateExpiration, String codePin, CompteCourant compteCourant, Boolean active) {
		super();
		this.numeroCarte = numeroCarte;
		this.dateExpiration = dateExpiration;
		this.codePin = codePin;
		this.compteCourant = compteCourant;
		this.active = active;
	}

	/**
	 * @param idCarte
	 * @param numeroCarte
	 * @param dateExpiration
	 * @param codePin
	 * @param compteCourant
	 * @param active
	 */
	public Carte(int idCarte, String numeroCarte, Date dateExpiration, String codePin, CompteCourant compteCourant,
			Boolean active) {
		super();
		this.idCarte = idCarte;
		this.numeroCarte = numeroCarte;
		this.dateExpiration = dateExpiration;
		this.codePin = codePin;
		this.compteCourant = compteCourant;
		this.active = active;
	}
	/* getters et setters */

	/**
	 * @return the idCarte
	 */
	public int getIdCarte() {
		return idCarte;
	}

	/**
	 * @param idCarte
	 *            the idCarte to set
	 */
	public void setIdCarte(int idCarte) {
		this.idCarte = idCarte;
	}

	/**
	 * @return the numeroCarte
	 */
	public String getNumeroCarte() {
		return numeroCarte;
	}

	/**
	 * @param numeroCarte
	 *            the numeroCarte to set
	 */
	public void setNumeroCarte(String numeroCarte) {
		this.numeroCarte = numeroCarte;
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
	 * @return the codePin
	 */
	public String getCodePin() {
		return codePin;
	}

	/**
	 * @param codePin
	 *            the codePin to set
	 */
	public void setCodePin(String codePin) {
		this.codePin = codePin;
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
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

}
