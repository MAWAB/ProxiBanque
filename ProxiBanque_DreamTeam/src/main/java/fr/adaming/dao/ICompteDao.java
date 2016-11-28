package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Compte;

public interface ICompteDao <C extends Compte> {
	
	public C getCompteByIdDao(C compte);
	
	public C getComptesCourantByIdClientDao(int id);
	
	public C getComptesEpargneByIdClientDao(int id);
	
	public List<C> getComptesCourantByIdAgenceDao(int id);
	
	public List<C> getComptesEpargneByIdAgenceDao(int id);
	
	
	public void ajouterCompteDao(C  compte);
	
	public void modifierCompteDao(C  compte);
	
	public void supprimerCompteDao(C  compte);
	

	
	public void virementDao(C compte1,C compte2, double somme);
	
	public void retraitDao(C compte,double somme);
	
	public void depotDao(C compte,double somme);
	
}
