package fr.adaming.dao;

import fr.adaming.model.Carte;

public interface ICarteDao <T extends Carte> {
	
	/**
	 * Obtenir une carte par son id
	 * @param carte
	 * @return
	 */
	public T getCarteByIdDao(T carte);
	
	/**
	 * Obtenir la carte d'un compte par l'idCompte
	 * @param id
	 * @param carte
	 * @return
	 */
	public T getCarteByIdCompteDao(int id, T carte);
	
	/**
	 * Ajouter une carte
	 * @param carte
	 */
	public void ajouterCarteDao(T carte);
	
	/**
	 * Modifier une carte
	 * @param carte
	 */
	public void modifierCarteDao(T carte);
	
	/**
	 * Supprimer une carte
	 * @param carte
	 */
	public void supprimerCarteDao(T carte);

}
