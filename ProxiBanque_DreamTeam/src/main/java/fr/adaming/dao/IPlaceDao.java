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
	
	public void updatePlace(Place place);

	public List<Place> getAllPlace();
	
	public Place getPlaceByIdClient(int id);
	
	public Place getPlaceByIdPlacement(int id);
	
	public Place getPlaceById(int id);

}
