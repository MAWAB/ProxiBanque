/**
 * 
 */
package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Place;

/**
 * @author inti0302
 *
 */
public interface IPlaceDao {
	
	/**
	 * Modifier une place
	 * @param place
	 */
	public void updatePlace(Place place);

	/**
	 * Obtenir liste de toutes les places
	 * @return
	 */
	public List<Place> getAllPlace();
	
	/**
	 * Obtenir une place d'un client par l'idClient
	 * @param id
	 * @return
	 */
	public Place getPlaceByIdClient(int id);
	
	/**
	 * Obtenir une place d'un placement par l'idPlacement
	 * @param id
	 * @return
	 */
	public Place getPlaceByIdPlacement(int id);
	
	/**
	 * Obtenir une place par son id
	 * @param id
	 * @return
	 */
	public Place getPlaceById(int id);

}
