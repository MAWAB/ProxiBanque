package fr.adaming.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gerants")
public class Gerant extends Conseiller{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGerant;
	private String numeroBureau;
	
	//transormer l'agregation entre le conseiller et le gerant
	private List<Conseiller> listeConselliers=new ArrayList<Conseiller>();
	//transormer l'agregation entre l'agence et le gerant
	private Agence agence;
	/**
	 * @param nom
	 * @param prenom
	 * @param dateDeNaissance
	 * @param adresse
	 * @param idConseiller
	 * @param nomDuService
	 * @param numeroImmatriculation
	 * @param motDePasse
	 * @param gerant
	 * @param listeClients
	 * @param idGerant
	 * @param numeroBureau
	 * @param listeConselliers
	 * @param agence
	 */
	public Gerant(String nom, String prenom, Date dateDeNaissance, Adresse adresse, int idConseiller,
			String nomDuService, String numeroImmatriculation, String motDePasse, Gerant gerant,
			List<Client> listeClients, int idGerant, String numeroBureau, List<Conseiller> listeConselliers,
			Agence agence) {
		super(nom, prenom, dateDeNaissance, adresse, idConseiller, nomDuService, numeroImmatriculation, motDePasse,
				gerant, listeClients);
		this.idGerant = idGerant;
		this.numeroBureau = numeroBureau;
		this.listeConselliers = listeConselliers;
		this.agence = agence;
	}
	/**
	 * @param nom
	 * @param prenom
	 * @param dateDeNaissance
	 * @param adresse
	 * @param idConseiller
	 * @param nomDuService
	 * @param numeroImmatriculation
	 * @param motDePasse
	 * @param gerant
	 * @param listeClients
	 * @param numeroBureau
	 * @param listeConselliers
	 * @param agence
	 */
	public Gerant(String nom, String prenom, Date dateDeNaissance, Adresse adresse, int idConseiller,
			String nomDuService, String numeroImmatriculation, String motDePasse, Gerant gerant,
			List<Client> listeClients, String numeroBureau, List<Conseiller> listeConselliers, Agence agence) {
		super(nom, prenom, dateDeNaissance, adresse, idConseiller, nomDuService, numeroImmatriculation, motDePasse,
				gerant, listeClients);
		this.numeroBureau = numeroBureau;
		this.listeConselliers = listeConselliers;
		this.agence = agence;
	}
	/**
	 * @param nom
	 * @param prenom
	 * @param dateDeNaissance
	 * @param adresse
	 * @param idConseiller
	 * @param nomDuService
	 * @param numeroImmatriculation
	 * @param motDePasse
	 * @param gerant
	 * @param listeClients
	 */
	public Gerant(String nom, String prenom, Date dateDeNaissance, Adresse adresse, int idConseiller,
			String nomDuService, String numeroImmatriculation, String motDePasse, Gerant gerant,
			List<Client> listeClients) {
		super(nom, prenom, dateDeNaissance, adresse, idConseiller, nomDuService, numeroImmatriculation, motDePasse,
				gerant, listeClients);
	}
	/**
	 * @return the idGerant
	 */
	public int getIdGerant() {
		return idGerant;
	}
	/**
	 * @param idGerant the idGerant to set
	 */
	public void setIdGerant(int idGerant) {
		this.idGerant = idGerant;
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
		return "Gerant [idGerant=" + idGerant + ", numeroBureau=" + numeroBureau + ", listeConselliers="
				+ listeConselliers + ", agence=" + agence + "]";
	}
	
	
	
}
