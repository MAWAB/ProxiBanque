package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Compte;

public interface ICompteService <C extends Compte> {
	
	public C getCompteByIdService(C compte);
	
	public C getComptesCourantByIdClientService(int id);
	
	public C getComptesEpargneByIdClientService(int id);
	
	public List<C> getComptesCourantByIdAgenceService(int id);
	
	public List<C> getComptesEpargneByIdAgenceService(int id);
	
	
	public void ajouterCompteService(C  compte);
	
	public void modifierCompteService(C  compte);
	
	public void supprimerCompteService(C  compte);
	

	/**
	 * Virement conditionnel limiter à la limite de découvert
	 * @param compte1
	 * @param compte2
	 * @param somme
	 * @return
	 */
	public int virementService(C compte1,C compte2, double somme);
	
	/**
	 * Retrait conditionnel limiter à la limite de découvert
	 * @param compte
	 * @param somme
	 * @return
	 */
	public int retraitService(C compte,double somme);
	
	public void depotService(C compte, double somme);
	
}
