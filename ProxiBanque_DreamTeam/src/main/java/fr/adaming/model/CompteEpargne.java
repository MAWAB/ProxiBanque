package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cEpargne")
public class CompteEpargne extends Compte implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_compteE")
	private int idCompte;	
	
	private double tauxRenumeration;
	
	@OneToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="client_id", referencedColumnName="idClient")
	private Client client;

	/**
	 * @param idCompte
	 * @param numeroCompte
	 * @param solde
	 * @param dateCreation
	 * @param tauxRenumeration
	 */
	public CompteEpargne(int idCompte, String numeroCompte, double solde, Date dateCreation, double tauxRenumeration) {
		super(numeroCompte, solde, dateCreation);
		this.tauxRenumeration = tauxRenumeration;
	}

	/**
	 * @param numeroCompte
	 * @param solde
	 * @param dateCreation
	 * @param tauxRenumeration
	 */
	public CompteEpargne(String numeroCompte, double solde, Date dateCreation, double tauxRenumeration) {
		super(numeroCompte, solde, dateCreation);
		this.tauxRenumeration = tauxRenumeration;
	}

	/**
	 * 
	 */
	public CompteEpargne() {
		super();
	}

	
	
	/**
	 * @return the idCompte
	 */
	public int getIdCompte() {
		return idCompte;
	}

	/**
	 * @param idCompte the idCompte to set
	 */
	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	/**
	 * @return the tauxRenumeration
	 */
	public double getTauxRenumeration() {
		return tauxRenumeration;
	}

	/**
	 * @param tauxRenumeration the tauxRenumeration to set
	 */
	public void setTauxRenumeration(double tauxRenumeration) {
		this.tauxRenumeration = tauxRenumeration;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompteEpargne [tauxRenumeration=" + tauxRenumeration + "]";
	}
	
}
