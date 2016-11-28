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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cEpargne")
public class CompteEpargne extends Compte implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_compteE")
	private int idCompte;	
	
	private double tauxRenumeration;
	
	@Temporal(TemporalType.DATE)
	protected Date dateCreation;
	
	@OneToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="client_id", referencedColumnName="idClient")
	private Client client;

	/**
	 * @param numeroCompte
	 * @param solde
	 * @param idCompte
	 * @param tauxRenumeration
	 * @param dateCreation
	 * @param client
	 */
	public CompteEpargne(String numeroCompte, double solde, int idCompte,
			double tauxRenumeration, Date dateCreation, Client client) {
		super(numeroCompte, solde);
		this.idCompte = idCompte;
		this.tauxRenumeration = tauxRenumeration;
		this.dateCreation = dateCreation;
		this.client = client;
	}

	/**
	 * @param numeroCompte
	 * @param solde
	 * @param tauxRenumeration
	 * @param dateCreation
	 * @param client
	 */
	public CompteEpargne(String numeroCompte, double solde,
			double tauxRenumeration, Date dateCreation, Client client) {
		super(numeroCompte, solde);
		this.tauxRenumeration = tauxRenumeration;
		this.dateCreation = dateCreation;
		this.client = client;
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

	/**
	 * @return the dateCreation
	 */
	public Date getDateCreation() {
		return dateCreation;
	}

	/**
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompteEpargne [idCompte=" + idCompte + ", tauxRenumeration="
				+ tauxRenumeration + ", dateCreation=" + dateCreation
				+ ", client=" + client + ", numeroCompte=" + numeroCompte
				+ ", solde=" + solde + "]";
	}


	
	
}
