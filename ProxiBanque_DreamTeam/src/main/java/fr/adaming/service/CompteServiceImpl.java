package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICompteDao;
import fr.adaming.model.Compte;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.CompteEpargne;

@Service("cmpServiceBean")
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
	public int virementService(C compte1, C compte2, double somme) {
		compteDao.virementDao(compte1, compte2, somme);
		
		if (compte1 instanceof CompteCourant && compte2 instanceof CompteCourant) {
			CompteCourant cc1=(CompteCourant) compteDao.getCompteByIdDao(compte1);
			
			if(cc1.getSolde()-somme >= -5000){
				compteDao.virementDao(compte1, compte2, somme);
				return 1;
			}else{
				return -1;
			}
			
		}else if (compte1 instanceof CompteCourant && compte2 instanceof CompteEpargne) {
			CompteCourant cc1=(CompteCourant) compteDao.getCompteByIdDao(compte1);
			
			if(cc1.getSolde()-somme >= -5000){
				compteDao.virementDao(compte1, compte2, somme);
				return 1;
			}else{
				return -1;
			}
			
		}else if (compte1 instanceof CompteEpargne && compte2 instanceof CompteCourant) {
			CompteEpargne ce1=(CompteEpargne) compteDao.getCompteByIdDao(compte1);
			
			if(ce1.getSolde()-somme >= 10){
				compteDao.virementDao(compte1, compte2, somme);
				return 1;
			}else{
				return -1;
			}
		}
		
		return 0;
		
	}

	@Override
	public int retraitService(C compte, double somme) {
		if (compte instanceof CompteCourant) {
			CompteCourant compte1=(CompteCourant) compteDao.getCompteByIdDao(compte);
			
			if(compte1.getSolde()-somme >= -5000){
				compteDao.retraitDao(compte, somme);
				return 1;
			}else{
				return -1;
			}
		}else if (compte instanceof CompteEpargne) {
			CompteEpargne compte1=(CompteEpargne) compteDao.getCompteByIdDao(compte);
			
			if(compte1.getSolde()-somme >= 10){
				compteDao.retraitDao(compte, somme);
				return 1;
			}else{
				return -1;
			}
		}
		return 0;
		
	}



	@Override
	public void depotService(C compte, double somme) {
		compteDao.depotDao(compte, somme);
		
	}

}
