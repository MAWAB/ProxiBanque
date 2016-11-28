package fr.adaming.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.model.Carte;
import fr.adaming.model.VisaElectron;
import fr.adaming.model.VisaPremium;

public class CarteDaoImpl <T extends Carte> implements ICarteDao<T> {
	
	@Autowired
	private EntityManagerFactory emf;
	
	
	
	/**
	 * @param emf the emf to set
	 */
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public T getCarteByIdDao(T carte) {
		EntityManager em = emf.createEntityManager();
		
		if(carte instanceof VisaElectron){
			
			try{
				String req = "SELECT * FROM VisaElectron vE WHERE vE.idVisaElectron =: vE_id";
				Query query = em.createQuery(req);
				query.setParameter("vE_id", ((VisaElectron) carte).getIdVisaElectron());
				
				return (T) query.getSingleResult();
				
			}catch (NullPointerException | IllegalArgumentException e){
				e.printStackTrace();
				
			}
			
		}else if(carte instanceof VisaPremium){
		
			try{
				String req = "SELECT * FROM VisaPremium vE WHERE vE.idVisaPremium=:vE_id";
				Query query = em.createQuery(req);
				query.setParameter("vE_id", ((VisaPremium) carte).getIdVisaPremium());
				
				return (T) query.getSingleResult();
				
			}catch (NullPointerException | IllegalArgumentException e){
				e.printStackTrace();
			}
		}
		return null;
		
	}

	@Override
	public T getVisaElectronByIdCompteDao(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getVisaPremiumByIdCompteDao(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajouterCarteDao(T carte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierCarteDao(T carte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerCarteDao(T carte) {
		// TODO Auto-generated method stub
		
	}

}
