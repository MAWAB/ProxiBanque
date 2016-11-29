package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Agence;

public interface IAgenceDao {

	/**
	 * Obtenir la liste de toutes les agences
	 * @return
	 */
	public List<Agence> getAllAgences();
	
	/**
	 * Obtenir une agence par son id
	 * @param id_agence
	 * @return
	 */
	public Agence getAgenceById(int id_agence);
}
