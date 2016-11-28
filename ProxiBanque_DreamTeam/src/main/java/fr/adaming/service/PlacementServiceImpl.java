/**
 * 
 */
package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IPlacementDao;
import fr.adaming.model.Placement;

/**
 * @author inti0302
 *
 */
@Service("placementServiceImpl")
@Transactional
public class PlacementServiceImpl implements IPlacementService {

	@Autowired
	@Qualifier("placementDaoImpl")
	IPlacementDao placementDao;
	
	/* (non-Javadoc)
	 * @see fr.adaming.service.IPlacementService#addPlacementService(fr.adaming.model.Placement)
	 */
	@Override
	public void addPlacementService(Placement placement) {
		placementDao.addPlacement(placement);

	}

	/* (non-Javadoc)
	 * @see fr.adaming.service.IPlacementService#updatePlacementService(fr.adaming.model.Placement)
	 */
	@Override
	public void updatePlacementService(Placement placement) {
		placementDao.updatePlacement(placement);

	}

	/* (non-Javadoc)
	 * @see fr.adaming.service.IPlacementService#deletePlacementService(int)
	 */
	@Override
	public void deletePlacementService(int id) {
		placementDao.deletePlacement(id);
	}

	/* (non-Javadoc)
	 * @see fr.adaming.service.IPlacementService#getAllPlacementsService()
	 */
	@Override
	public List<Placement> getAllPlacementsService() {
		return placementDao.getAllPlacements();
	}

	/* (non-Javadoc)
	 * @see fr.adaming.service.IPlacementService#getAllPlacementsByIdPlaceService(int)
	 */
	@Override
	public List<Placement> getAllPlacementsByIdPlaceService(int id) {
		return placementDao.getAllPlacementsByIdPlace(id);
	}

	/* (non-Javadoc)
	 * @see fr.adaming.service.IPlacementService#getAllPlacementByIdClientService(int)
	 */
	@Override
	public List<Placement> getAllPlacementByIdClientService(int id) {
		return placementDao.getAllPlacementByIdClient(id);
	}

	/* (non-Javadoc)
	 * @see fr.adaming.service.IPlacementService#getPlacementByIdService(int)
	 */
	@Override
	public Placement getPlacementByIdService(int id) {
		return placementDao.getPlacementById(id);
	}

}
