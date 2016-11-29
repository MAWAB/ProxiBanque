package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Compte;

public interface ICompteDao <C extends Compte> {
	
	/**
	 * Obtenir un compte à partir de son id
	 * @param compte
	 * @return
	 */
	public C getCompteByIdDao(C compte);
	
	/**
	 * Obtenir le compte courant d'un client par idClient
	 * @param id
	 * @return
	 */
	public C getComptesCourantByIdClientDao(int id);
	
	/**
	 * Obtenir le compte épargne d'un client par idClient
	 * @param id
	 * @return
	 */
	public C getComptesEpargneByIdClientDao(int id);
	
	/**
	 * Liste des comptes courants d'une agence par idAgence
	 * @param id
	 * @return
	 */
	public List<C> getComptesCourantByIdAgenceDao(int id);
	
	/**
	 * Liste des comptes épargnes d'une agence par idAgence
	 * @param id
	 * @return
	 */
	public List<C> getComptesEpargneByIdAgenceDao(int id);
	
	
	/**
	 * Ajouter un compte
	 * @param compte
	 */
	public void ajouterCompteDao(C  compte);
	
	/**
	 * Modifier les informations un compte
	 * @param compte
	 */
	public void modifierCompteDao(C  compte);
	
	/**
	 * Supprimer un compte
	 * @param compte
	 */
	public void supprimerCompteDao(C  compte);
	

	/**
	 * Réaliser un virement de compte à compte (hors compte épargne à compte épargne)
	 * @param compte1
	 * @param compte2
	 * @param somme
	 */
	public void virementDao(C compte1,C compte2, double somme);
	
	/**
	 * Retrait d'une somme sur un compte
	 * @param compte
	 * @param somme
	 */
	public void retraitDao(C compte,double somme);
	
	/**
	 * Déposer une somme sur un compte
	 * @param compte
	 * @param somme
	 */
	public void depotDao(C compte,double somme);
	
}
