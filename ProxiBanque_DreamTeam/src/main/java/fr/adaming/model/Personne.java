package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class Personne implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Propriétés ---------------------------------------------------------------------------------------------
	protected String nom;
	protected String prenom;
	
	@Temporal(TemporalType.DATE)
	protected Date dateDeNaissance;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idAdresse", referencedColumnName="idAdresse")
	protected Adresse adresse;
	
	
	// Constructeurs --------------------------------------------------------------------------------------------
	
	/**
	 * 
	 */
	public Personne() {
		super();
	}
	/**
	 * @param nom
	 * @param prenom
	 * @param dateDeNaissance
	 * @param adresse
	 */
	public Personne(String nom, String prenom, Date dateDeNaissance, Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.adresse = adresse;
	}
	
	
	/* getters et setters -------------------------------------------------------------------------------- */
	
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the dateDeNaissance
	 */
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	/**
	 * @param dateDeNaissance the dateDeNaissance to set
	 */
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", dateDeNaissance=" + dateDeNaissance + "]";
	}
	
	
	
}
