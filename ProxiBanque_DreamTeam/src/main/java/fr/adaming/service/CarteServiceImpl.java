package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICarteDao;
import fr.adaming.model.Carte;

@Service("carteService")
@Transactional
public class CarteServiceImpl <T extends Carte> implements ICarteService<T> {
	
	@Autowired
	@Qualifier("carteDao")
	private ICarteDao<Carte> carteDao;
	
	
	
	/**
	 * @param carteDao the carteDao to set
	 */
	public void setCarteDao(ICarteDao<Carte> carteDao) {
		this.carteDao = carteDao;
	}

	@Override
	public T getCarteByIdService(T carte) {
		return (T) carteDao.getCarteByIdDao(carte);
	}

	@Override
	public T getCarteByIdCompteService(int id, T carte) {
		return (T) carteDao.getCarteByIdCompteDao(id, carte);
	}

	@Override
	public void ajouterCarteService(T carte) {
		carteDao.ajouterCarteDao(carte);
		
	}

	@Override
	public void modifierCarteService(T carte) {
		carteDao.modifierCarteDao(carte);
		
	}

	@Override
	public void supprimerCarteService(T carte) {
		supprimerCarteService(carte);
		
	}
	

}
