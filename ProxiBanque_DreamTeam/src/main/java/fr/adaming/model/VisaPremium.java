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
@Table(name = "visapremiums")
public class VisaPremium extends Carte implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVisaPremium;

	@Temporal(TemporalType.DATE)
	protected Date dateExpiration;

	@OneToOne
	@JoinColumn(name = "compte_id", referencedColumnName = "id_compteC")
	private CompteCourant compteCourant;

	private double plafondRetrait;

	/**
	 * @param idCarte
	 * @param numeroCarte
	 * @param dateExpiration
	 * @param codePin
	 * @param compteCourant
	 * @param active
	 * @param plafondRetrait
	 */
	public VisaPremium(int idCarte, String numeroCarte, Date dateExpiration, String codePin,
			CompteCourant compteCourant, Boolean active, double plafondRetrait) {
		super(numeroCarte, codePin, active);
		this.idVisaPremium = idCarte;
		this.plafondRetrait = plafondRetrait;
		this.dateExpiration = dateExpiration;
		this.compteCourant = compteCourant;
	}

	/**
	 * @param numeroCarte
	 * @param dateExpiration
	 * @param codePin
	 * @param compteCourant
	 * @param active
	 * @param plafondRetrait
	 */
	public VisaPremium(String numeroCarte, Date dateExpiration, String codePin, CompteCourant compteCourant,
			Boolean active, double plafondRetrait) {
		super(numeroCarte, codePin, active);
		this.plafondRetrait = plafondRetrait;
		this.dateExpiration = dateExpiration;
		this.compteCourant = compteCourant;
	}

	/**
	 * 
	 */
	public VisaPremium() {
		super();
	}

	/**
	 * @return the idVisaPremium
	 */
	public int getIdVisaPremium() {
		return idVisaPremium;
	}

	/**
	 * @param idVisaPremium
	 *            the idVisaPremium to set
	 */
	public void setIdVisaPremium(int idVisaPremium) {
		this.idVisaPremium = idVisaPremium;
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
	 * @return the plafondRetrait
	 */
	public double getPlafondRetrait() {
		return plafondRetrait;
	}

	/**
	 * @param plafondRetrait
	 *            the plafondRetrait to set
	 */
	public void setPlafondRetrait(double plafondRetrait) {
		this.plafondRetrait = plafondRetrait;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "VisaPremium [plafondRetrait=" + plafondRetrait + "]";
	}

}
