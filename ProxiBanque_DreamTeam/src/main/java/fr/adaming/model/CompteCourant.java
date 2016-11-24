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
@Table(name = "cCourant")
public class CompteCourant extends Compte implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_compteC")
	private int idCompte;
	
	private double decouvert;
	
	@Temporal(TemporalType.DATE)
	protected Date dateCreation;
	
	//transormer la compotision entre le client et le compteCourant
	@OneToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="client_id", referencedColumnName="idClient")
	private Client client;

	//transormer la composition entre le compteCourant et la VisaElectron
	@OneToOne(mappedBy="compteCourant")
	private VisaElectron visaElectron;
	
	//transormer la composition entre le compteCourant et la VisaPremium
	@OneToOne(mappedBy="compteCourant")
	private VisaPremium visaPremium;

	/**
	 * @param numeroCompte
	 * @param solde
	 * @param idCompte
	 * @param decouvert
	 * @param dateCreation
	 * @param client
	 * @param visaElectron
	 * @param visaPremium
	 */
	public CompteCourant(String numeroCompte, double solde, int idCompte,
			double decouvert, Date dateCreation, Client client,
			VisaElectron visaElectron, VisaPremium visaPremium) {
		super(numeroCompte, solde);
		this.idCompte = idCompte;
		this.decouvert = decouvert;
		this.dateCreation = dateCreation;
		this.client = client;
		this.visaElectron = visaElectron;
		this.visaPremium = visaPremium;
	}

	/**
	 * @param numeroCompte
	 * @param solde
	 * @param decouvert
	 * @param dateCreation
	 * @param client
	 * @param visaElectron
	 * @param visaPremium
	 */
	public CompteCourant(String numeroCompte, double solde, double decouvert,
			Date dateCreation, Client client, VisaElectron visaElectron,
			VisaPremium visaPremium) {
		super(numeroCompte, solde);
		this.decouvert = decouvert;
		this.dateCreation = dateCreation;
		this.client = client;
		this.visaElectron = visaElectron;
		this.visaPremium = visaPremium;
	}

	/**
	 * 
	 */
	public CompteCourant() {
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
	 * @return the decouvert
	 */
	public double getDecouvert() {
		return decouvert;
	}

	/**
	 * @param decouvert the decouvert to set
	 */
	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
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

	/**
	 * @return the visaElectron
	 */
	public VisaElectron getVisaElectron() {
		return visaElectron;
	}

	/**
	 * @param visaElectron the visaElectron to set
	 */
	public void setVisaElectron(VisaElectron visaElectron) {
		this.visaElectron = visaElectron;
	}

	/**
	 * @return the visaPremium
	 */
	public VisaPremium getVisaPremium() {
		return visaPremium;
	}

	/**
	 * @param visaPremium the visaPremium to set
	 */
	public void setVisaPremium(VisaPremium visaPremium) {
		this.visaPremium = visaPremium;
	}


		
	
}
