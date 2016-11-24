package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Compte;

public interface ICompteDao <C extends Compte> {
	
	public List<C> getAllCompteDao();
	
	public C getCompteByIdDao(int id_cn);

	public List<C> getComptesByIdClientDao(int id_client);
	
	
	public void ajouterCompteDao(C  compte);
	
	public void modifierCompteDao(C  compte);
	
	public void supprimerCompteDao(C  compte);
	

	
	public void virementDao(C compe1,C compte1, double somme);
	
	public void retraitDao(C compte,double somme);
	
	public void depotDao(C compte,double somme);
	
}
