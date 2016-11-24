package fr.adaming.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Gerant extends Conseiller{
	private int idGerant;
	private String numeroBureau;
	
	//transormer l'agregation entre le conseiller et le gerant
	private List<Conseiller> listeConselliers=new ArrayList<Conseiller>();
	//transormer l'agregation entre l'agence et le gerant
	private Agence agence;
	
	
	/* constructeurs */
	public Gerant(String nom, String prenom, Date dateDeNaissance, int id, String numeroBureau,
			List<Conseiller> listeConselliers, Agence agence) {
		super(nom, prenom, dateDeNaissance);
		this.id = id;
		this.numeroBureau = numeroBureau;
		this.listeConselliers = listeConselliers;
		this.agence = agence;
	}
	public Gerant(String nom, String prenom, Date dateDeNaissance, String numeroBureau,
			List<Conseiller> listeConselliers, Agence agence) {
		super(nom, prenom, dateDeNaissance);
		this.numeroBureau = numeroBureau;
		this.listeConselliers = listeConselliers;
		this.agence = agence;
	}
	public Gerant(String nom, String prenom, Date dateDeNaissance) {
		super(nom, prenom, dateDeNaissance);
	}
	
	/* getters et setters */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumeroBureau() {
		return numeroBureau;
	}
	public void setNumeroBureau(String numeroBureau) {
		this.numeroBureau = numeroBureau;
	}
	public List<Conseiller> getListeConselliers() {
		return listeConselliers;
	}
	public void setListeConselliers(List<Conseiller> listeConselliers) {
		this.listeConselliers = listeConselliers;
	}
	public Agence getAgence() {
		return agence;
	}
	public void setAgence(Agence agence) {
		this.agence = agence;
	}
	
	
	@Override
	public String toString() {
		return "Gerant [id=" + id + ", numeroBureau=" + numeroBureau + ", listeConselliers=" + listeConselliers
				+ ", agence=" + agence + "]";
	}
	
	
	
}
