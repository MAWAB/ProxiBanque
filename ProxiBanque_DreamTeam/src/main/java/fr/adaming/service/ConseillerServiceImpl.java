package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IConseillerDao;
import fr.adaming.model.Conseiller;


@Service("conseillerService")
@Transactional
public class ConseillerServiceImpl implements IConseillerService {

	@Autowired
	IConseillerDao conseillerDao;

	@Override
	public Conseiller getConseillerByIdService(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Conseiller> getAllConseillerService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Conseiller addConseillerService(Conseiller conseiller) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteConseillerService(Conseiller conseiller) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Conseiller updateConseillerService(Conseiller conseiller) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Conseiller> getConseillerByAgenceService(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
