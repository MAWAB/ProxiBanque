package fr.adaming.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Conseiller extends Personne {
	private int id;
	private String nomDuService;
	private String numeroImmatriculation;
	private String numeroBureau;
	private String motDePasse;
	// transormer l'agregation entre le conseiller et le gerant
	private Gerant gerant;

	// transormer l'agregation entre le conseiller et le gerant
	private List<Client> listeClients = new ArrayList<Client>();

	/* constructeurs */

	public Conseiller(String nom, String prenom, Date dateDeNaissance) {
		super(nom, prenom, dateDeNaissance);
	}

	public Conseiller(String nom, String prenom, Date dateDeNaissance, String nomDuService,
			String numeroImmatriculation, String numeroBureau, String motDePasse, Gerant gerant,
			List<Client> listeClients) {
		super(nom, prenom, dateDeNaissance);
		this.nomDuService = nomDuService;
		this.numeroImmatriculation = numeroImmatriculation;
		this.numeroBureau = numeroBureau;
		this.motDePasse = motDePasse;
		this.gerant = gerant;
		this.listeClients = listeClients;
	}

	public Conseiller(String nom, String prenom, Date dateDeNaissance, int id, String nomDuService,
			String numeroImmatriculation, String numeroBureau, String motDePasse, Gerant gerant,
			List<Client> listeClients) {
		super(nom, prenom, dateDeNaissance);
		this.id = id;
		this.nomDuService = nomDuService;
		this.numeroImmatriculation = numeroImmatriculation;
		this.numeroBureau = numeroBureau;
		this.motDePasse = motDePasse;
		this.gerant = gerant;
		this.listeClients = listeClients;
	}

	/* getters et setters */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomDuService() {
		return nomDuService;
	}

	public void setNomDuService(String nomDuService) {
		this.nomDuService = nomDuService;
	}

	public String getNumeroImmatriculation() {
		return numeroImmatriculation;
	}

	public void setNumeroImmatriculation(String numeroImmatriculation) {
		this.numeroImmatriculation = numeroImmatriculation;
	}

	public String getNumeroBureau() {
		return numeroBureau;
	}

	public void setNumeroBureau(String numeroBureau) {
		this.numeroBureau = numeroBureau;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Gerant getGerant() {
		return gerant;
	}

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	public List<Client> getListeClients() {
		return listeClients;
	}

	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}

	@Override
	public String toString() {
		return "Conseiller [id=" + id + ", nomDuService=" + nomDuService + ", numeroImmatriculation="
				+ numeroImmatriculation + ", numeroBureau=" + numeroBureau + ", motDePasse=" + motDePasse + ", gerant="
				+ gerant + ", listeClients=" + listeClients + "]";
	}

}
