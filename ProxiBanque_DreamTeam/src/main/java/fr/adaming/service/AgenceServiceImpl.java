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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Agence getAgenceById(int id_agence) {
		// TODO Auto-generated method stub
		return null;
	}

}
