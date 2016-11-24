package fr.adaming.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Conseiller extends Personne {
	
	
	private int idConseiller;
	private String nomDuService;
	private String numeroImmatriculation;
	private String motDePasse;
	// transormer l'agregation entre le conseiller et le gerant
	private Gerant gerant;

	// transormer l'agregation entre le conseiller et le gerant
	private List<Client> listeClients = new ArrayList<Client>();

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
	public Conseiller(String nom, String prenom, Date dateDeNaissance, Adresse adresse, int idConseiller,
			String nomDuService, String numeroImmatriculation, String motDePasse, Gerant gerant,
			List<Client> listeClients) {
		super(nom, prenom, dateDeNaissance, adresse);
		this.idConseiller = idConseiller;
		this.nomDuService = nomDuService;
		this.numeroImmatriculation = numeroImmatriculation;
		this.motDePasse = motDePasse;
		this.gerant = gerant;
		this.listeClients = listeClients;
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param dateDeNaissance
	 * @param adresse
	 * @param nomDuService
	 * @param numeroImmatriculation
	 * @param motDePasse
	 * @param gerant
	 * @param listeClients
	 */
	public Conseiller(String nom, String prenom, Date dateDeNaissance, Adresse adresse, String nomDuService,
			String numeroImmatriculation, String motDePasse, Gerant gerant, List<Client> listeClients) {
		super(nom, prenom, dateDeNaissance, adresse);
		this.nomDuService = nomDuService;
		this.numeroImmatriculation = numeroImmatriculation;
		this.motDePasse = motDePasse;
		this.gerant = gerant;
		this.listeClients = listeClients;
	}

	/**
	 * 
	 */
	public Conseiller() {
		super();
	}

	/**
	 * @return the idConseiller
	 */
	public int getIdConseiller() {
		return idConseiller;
	}

	/**
	 * @param idConseiller the idConseiller to set
	 */
	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

	/**
	 * @return the nomDuService
	 */
	public String getNomDuService() {
		return nomDuService;
	}

	/**
	 * @param nomDuService the nomDuService to set
	 */
	public void setNomDuService(String nomDuService) {
		this.nomDuService = nomDuService;
	}

	/**
	 * @return the numeroImmatriculation
	 */
	public String getNumeroImmatriculation() {
		return numeroImmatriculation;
	}

	/**
	 * @param numeroImmatriculation the numeroImmatriculation to set
	 */
	public void setNumeroImmatriculation(String numeroImmatriculation) {
		this.numeroImmatriculation = numeroImmatriculation;
	}

	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	/**
	 * @return the gerant
	 */
	public Gerant getGerant() {
		return gerant;
	}

	/**
	 * @param gerant the gerant to set
	 */
	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	/**
	 * @return the listeClients
	 */
	public List<Client> getListeClients() {
		return listeClients;
	}

	/**
	 * @param listeClients the listeClients to set
	 */
	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Conseiller [idConseiller=" + idConseiller + ", nomDuService=" + nomDuService
				+ ", numeroImmatriculation=" + numeroImmatriculation + ", motDePasse=" + motDePasse + ", gerant="
				+ gerant + ", listeClients=" + listeClients + "]";
	}

	
	
}
