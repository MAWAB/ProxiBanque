package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Compte;

public interface ICompteService <C extends Compte> {
	
	public List<C> getAllCompteService();
	
	public C getCompteByIdService(int id_cn);

	public List<C> getComptesByIdClientService(int id_client);
	
	
	public void ajouterCompteService(C  compte);
	
	public void modifierCompteService(C  compte);
	
	public void supprimerCompteService(C  compte);
	

	
	public void virementService(C compe1,C compte1, double somme);
	
	public void retraitService(C compte,double somme);
	
	public void depotService(C compte, double somme);
	
}
