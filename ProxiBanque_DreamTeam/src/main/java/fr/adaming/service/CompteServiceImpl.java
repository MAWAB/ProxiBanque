package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.dao.ICompteDao;
import fr.adaming.model.Compte;

public class CompteServiceImpl <C extends Compte> implements ICompteService<C>{

	@Autowired
	private ICompteDao compteDao;
	
	
	
	public void setCompteDao(ICompteDao compteDao) {
		this.compteDao = compteDao;
	}

	
	
	@Override
	public List<C> getAllCompteService() {
		return compteDao.getAllCompteDao();
	}

	@Override
	public C getCompteByIdService(int id_cn) {
		return (C) compteDao.getCompteByIdDao(id_cn);
	}

	@Override
	public List<C> getComptesByIdClientService(int id_client) {
		return compteDao.getComptesByIdClientDao(id_client);
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
