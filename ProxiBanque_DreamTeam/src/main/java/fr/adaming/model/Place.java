/**
 * 
 */
package fr.adaming.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author inti0302
 *
 */
@Entity
@Table(name = "places")
public class Place implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPlace;

	private String nom;
	private double taux;

	@OneToMany(mappedBy = "place", fetch = FetchType.EAGER, cascade =CascadeType.MERGE)
	private List<Client> listeCl;

	@OneToMany(mappedBy = "place", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Placement> listePl;

	/**
	 * 
	 */
	public Place() {
		super();
	}

	/**
	 * @param idPlace
	 * @param nom
	 * @param taux
	 */
	public Place(int idPlace, String nom, double taux) {
		super();
		this.idPlace = idPlace;
		this.nom = nom;
		this.taux = taux;
	}

	/**
	 * @param nom
	 * @param taux
	 */
	public Place(String nom, double taux) {
		super();
		this.nom = nom;
		this.taux = taux;
	}

	/**
	 * @return the idPlace
	 */
	public int getIdPlace() {
		return idPlace;
	}

	/**
	 * @param idPlace
	 *            the idPlace to set
	 */
	public void setIdPlace(int idPlace) {
		this.idPlace = idPlace;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the taux
	 */
	public double getTaux() {
		return taux;
	}

	/**
	 * @param taux
	 *            the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}

	/**
	 * @return the listeCl
	 */
	public List<Client> getListeCl() {
		return listeCl;
	}

	/**
	 * @param listeCl
	 *            the listeCl to set
	 */
	public void setListeCl(List<Client> listeCl) {
		this.listeCl = listeCl;
	}

	/**
	 * @return the listePl
	 */
	public Set<Placement> getListePl() {
		return listePl;
	}

	/**
	 * @param listePl
	 *            the listePl to set
	 */
	public void setListePl(Set<Placement> listePl) {
		this.listePl = listePl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Place [idPlace=" + idPlace + ", nom=" + nom + ", taux=" + taux + "]";
	}

}
