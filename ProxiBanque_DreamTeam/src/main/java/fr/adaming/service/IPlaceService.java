/**
 * 
 */
package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Place;

/**
 * @author inti0302
 *
 */
public interface IPlaceService {
	
	public void updatePlaceService(Place place);

	public List<Place> getAllPlaceService();
	
	public Place getPlaceByIdClientService(int id);
	
	public Place getPlaceByIdPlacementService(int id);
	
	public Place getPlaceByIdService(int id);

}
