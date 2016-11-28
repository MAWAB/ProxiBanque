/**
 * 
 */
package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IPlaceDao;
import fr.adaming.model.Place;

/**
 * @author inti0302
 *
 */
@Service("placeServiceImpl")
@Transactional
public class PlaceServiceImpl implements IPlaceService {

	@Autowired
	@Qualifier("placeDaoImpl")
	IPlaceDao placeDao;
	
	/* (non-Javadoc)
	 * @see fr.adaming.service.IPlaceService#updatePlaceService(fr.adaming.model.Place)
	 */
	@Override
	public void updatePlaceService(Place place) {
		placeDao.updatePlace(place);

	}

	/* (non-Javadoc)
	 * @see fr.adaming.service.IPlaceService#getAllPlaceService()
	 */
	@Override
	public List<Place> getAllPlaceService() {
		return placeDao.getAllPlace();
	}

	/* (non-Javadoc)
	 * @see fr.adaming.service.IPlaceService#getPlaceByIdClientService(int)
	 */
	@Override
	public Place getPlaceByIdClientService(int id) {
		return placeDao.getPlaceByIdClient(id);
	}

	/* (non-Javadoc)
	 * @see fr.adaming.service.IPlaceService#getPlaceByIdPlacementService(int)
	 */
	@Override
	public Place getPlaceByIdPlacementService(int id) {
		return placeDao.getPlaceByIdPlacement(id);
	}

	/* (non-Javadoc)
	 * @see fr.adaming.service.IPlaceService#getPlaceByIdService(int)
	 */
	@Override
	public Place getPlaceByIdService(int id) {
		return placeDao.getPlaceById(id);
	}

}
