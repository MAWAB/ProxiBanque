/**
 * 
 */
package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author inti0302
 *
 */
@Entity
@Table(name = "placements")
public class Placement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPlacement;

	private double somme;

	@ManyToOne
	@JoinColumn(name = "client_id", referencedColumnName = "idClient")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "place_id", referencedColumnName = "idPlace")
	private Place place;

	/**
	 * 
	 */
	public Placement() {
		super();
	}

	/**
	 * @param idPlacement
	 * @param somme
	 */
	public Placement(int idPlacement, double somme) {
		super();
		this.idPlacement = idPlacement;
		this.somme = somme;
	}

	/**
	 * @param somme
	 */
	public Placement(double somme) {
		super();
		this.somme = somme;
	}

	/**
	 * @return the idPlacement
	 */
	public int getIdPlacement() {
		return idPlacement;
	}

	/**
	 * @param idPlacement
	 *            the idPlacement to set
	 */
	public void setIdPlacement(int idPlacement) {
		this.idPlacement = idPlacement;
	}

	/**
	 * @return the somme
	 */
	public double getSomme() {
		return somme;
	}

	/**
	 * @param somme
	 *            the somme to set
	 */
	public void setSomme(double somme) {
		this.somme = somme;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the place
	 */
	public Place getPlace() {
		return place;
	}

	/**
	 * @param place
	 *            the place to set
	 */
	public void setPlace(Place place) {
		this.place = place;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Placement [idPlacement=" + idPlacement + ", somme=" + somme + "]";
	}

}
