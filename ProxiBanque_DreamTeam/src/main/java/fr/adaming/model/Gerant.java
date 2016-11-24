package fr.adaming.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Gerant extends Conseiller{
	private int id;
	private String numeroBureau;
	
	//transormer l'agregation entre le conseiller et le gerant
	private List<Conseiller> listeConselliers=new ArrayList<Conseiller>();
	//transormer l'agregation entre l'agence et le gerant
	private Agence agence;
	
	
	
	
	/* constructeurs */
	
	/**
	 * @param id
	 * @param nomDuService
	 * @param numeroImmatriculation
	 * @param numeroBureau
	 * @param gerant
	 * @param listeClients
	 * @param id2
	 * @param numeroBureau2
	 * @param listeConselliers
	 * @param agence
	 */
	public Gerant(int id, String nomDuService, String numeroImmatriculation, String numeroBureau, Gerant gerant,
			List<Client> listeClients, int id2, String numeroBureau2, List<Conseiller> listeConselliers,
			Agence agence) {
		super(id, nomDuService, numeroImmatriculation, numeroBureau, gerant, listeClients);
		id = id2;
		numeroBureau = numeroBureau2;
		this.listeConselliers = listeConselliers;
		this.agence = agence;
	}
	/**
	 * @param id
	 * @param nomDuService
	 * @param numeroImmatriculation
	 * @param numeroBureau
	 * @param gerant
	 * @param listeClients
	 * @param numeroBureau2
	 * @param listeConselliers
	 * @param agence
	 */
	public Gerant(int id, String nomDuService, String numeroImmatriculation, String numeroBureau, Gerant gerant,
			List<Client> listeClients, String numeroBureau2, List<Conseiller> listeConselliers, Agence agence) {
		super(id, nomDuService, numeroImmatriculation, numeroBureau, gerant, listeClients);
		numeroBureau = numeroBureau2;
		this.listeConselliers = listeConselliers;
		this.agence = agence;
	}
	/**
	 * @param id
	 * @param nomDuService
	 * @param numeroImmatriculation
	 * @param numeroBureau
	 * @param gerant
	 * @param listeClients
	 */
	public Gerant(int id, String nomDuService, String numeroImmatriculation, String numeroBureau, Gerant gerant,
			List<Client> listeClients) {
		super(id, nomDuService, numeroImmatriculation, numeroBureau, gerant, listeClients);
	}
	
	/* getters et setters */
	
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the numeroBureau
	 */
	public String getNumeroBureau() {
		return numeroBureau;
	}
	/**
	 * @param numeroBureau the numeroBureau to set
	 */
	public void setNumeroBureau(String numeroBureau) {
		this.numeroBureau = numeroBureau;
	}
	/**
	 * @return the listeConselliers
	 */
	public List<Conseiller> getListeConselliers() {
		return listeConselliers;
	}
	/**
	 * @param listeConselliers the listeConselliers to set
	 */
	public void setListeConselliers(List<Conseiller> listeConselliers) {
		this.listeConselliers = listeConselliers;
	}
	/**
	 * @return the agence
	 */
	public Agence getAgence() {
		return agence;
	}
	/**
	 * @param agence the agence to set
	 */
	public void setAgence(Agence agence) {
		this.agence = agence;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Gerant [id=" + id + ", numeroBureau=" + numeroBureau + ", listeConselliers=" + listeConselliers
				+ ", agence=" + agence + "]";
	}
	
	
	
}
