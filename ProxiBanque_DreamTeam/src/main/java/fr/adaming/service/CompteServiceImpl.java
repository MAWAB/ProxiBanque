package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICompteDao;
import fr.adaming.model.Compte;

@Service
@Transactional
public class CompteServiceImpl <C extends Compte> implements ICompteService<C>{

	@Autowired
	private ICompteDao compteDao;
	
	
	
	public void setCompteDao(ICompteDao compteDao) {
		this.compteDao = compteDao;
	}

		


	@Override
	public C getCompteByIdService(C compte) {		
		return (C) compteDao.getCompteByIdDao(compte);
	}


	@Override
	public C getComptesCourantByIdClientService(int id) {
		return (C) compteDao.getComptesCourantByIdClientDao(id);
	}


	@Override
	public C getComptesEpargneByIdClientService(int id) {
		return (C) compteDao.getComptesEpargneByIdClientDao(id);
	}


	@Override
	public List<C> getComptesCourantByIdAgenceService(int id) {
		return compteDao.getComptesCourantByIdAgenceDao(id);
	}


	@Override
	public List<C> getComptesEpargneByIdAgenceService(int id) {
		return compteDao.getComptesEpargneByIdAgenceDao(id);
	}
	
	

	@Override
	public void ajouterCompteService(C compte) {
		compteDao.ajouterCompteDao(compte);
		
	}

	@Override
	public void modifierCompteService(C compte) {
		compteDao.modifierCompteDao(compte);
		
	}

	@Override
	public void supprimerCompteService(C compte) {
		compteDao.supprimerCompteDao(compte);
		
	}

	@Override
	public void virementService(C compe1, C compte1, double somme) {
		compteDao.virementDao(compe1, compte1, somme);
		
	}

	@Override
	public void retraitService(C compte, double somme) {
		compteDao.retraitDao(compte, somme);
		
	}



	@Override
	public void depotService(C compte, double somme) {
		compteDao.depotDao(compte, somme);
		
	}

}
