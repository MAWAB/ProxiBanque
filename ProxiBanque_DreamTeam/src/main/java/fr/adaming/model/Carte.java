package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Carte implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected String numeroCarte;
	protected String codePin;
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
	public Carte(String numeroCarte, String codePin, Boolean active) {
		super();
		this.numeroCarte = numeroCarte;
		this.codePin = codePin;
		this.active = active;
	}

	/* getters et setters */

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
