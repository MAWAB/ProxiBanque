package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAgenceDao;
import fr.adaming.model.Agence;


@Service("agenceServiceImpl")
@Transactional
public class AgenceServiceImpl implements IAgenceService {

	@Autowired
	@Qualifier("agenceDaoImpl")
	IAgenceDao agenceDao;
	@Override
	public List<Agence> getAllAgences() {
		
		return agenceDao.getAllAgences();
	}

	@Override
	public Agence getAgenceById(int id_agence) {
		
		return agenceDao.getAgenceById(id_agence);
	}

}
