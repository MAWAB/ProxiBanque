package fr.adaming.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="gerants")
@DiscriminatorValue(value="G")
public class Gerant extends Conseiller implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	// Propriétés -------------------------------------------------------------------------------------------------
	
	private String numeroBureau;
	
	//transormer l'agregation entre le conseiller et le gerant

	@OneToMany(mappedBy="gerant", fetch=FetchType.EAGER)
	private List<Conseiller> listeConseillers=new ArrayList<Conseiller>();
	//transormer l'agregation entre l'agence et le gerant

	 
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idAgence", referencedColumnName="idAgence")
	private Agence agence;

	
	
	// Constructeurs ---------------------------------------------------------------------------------------------
	
	public Gerant() {
		super();
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
			List<Client> listeClients, String numeroBureau, List<Conseiller> listeConseillers, Agence agence) {
		super(nom, prenom, dateDeNaissance, adresse, idConseiller, nomDuService, numeroImmatriculation, motDePasse,
				gerant, listeClients);
		this.numeroBureau = numeroBureau;
		this.listeConseillers = listeConseillers;
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
	 * @return the listeConseillers
	 */
	@JsonIgnore
	public List<Conseiller> getListeConseillers() {
		return listeConseillers;
	}
	/**
	 * @param listeConseillers the listeConseillers to set
	 */
	public void setListeConseillers(List<Conseiller> listeConseillers) {
		this.listeConseillers = listeConseillers;
	}
	/**
	 * @return the agence
	 */
	@JsonIgnore
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
		return "Gerant [numeroBureau=" + numeroBureau + ", listeConseillers=" + listeConseillers + ", agence=" + agence
				+ "]";
	}
	
	

	
	
	
	

	
	
	
	
}
