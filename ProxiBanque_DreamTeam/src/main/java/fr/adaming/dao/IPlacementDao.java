package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Placement;

public interface IPlacementDao {
	
	/**
	 * Ajouter un placement
	 * @param placement
	 */
	public void addPlacement(Placement placement);
	
	/**
	 * Modifier un placement
	 * @param placement
	 */
	public void updatePlacement(Placement placement);
	
	/**
	 * Supprimer un placement
	 * @param id
	 */
	public void deletePlacement(int id);
	
	/**
	 * Obtenir la liste de tous les placements
	 * @return
	 */
	public List<Placement> getAllPlacements();
	
	/**
	 * Obtenir la liste des placements d'une place par l'idPlace
	 * @param id
	 * @return
	 */
	public List<Placement> getAllPlacementsByIdPlace(int id);
	
	/**
	 * Obtenir la liste des placements d'un client par l'idClient
	 * @param id
	 * @return
	 */
	public List<Placement> getAllPlacementByIdClient(int id);
	
	/**
	 * Obtenir un placement par son id
	 * @param id
	 * @return
	 */
	public Placement getPlacementById(int id);
}
