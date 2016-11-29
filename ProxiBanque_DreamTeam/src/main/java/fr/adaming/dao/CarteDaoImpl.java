package fr.adaming.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Carte;
import fr.adaming.model.VisaElectron;
import fr.adaming.model.VisaPremium;

@Repository("carteDao")
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
				String req = "SELECT vE FROM VisaElectron vE WHERE vE.idVisaElectron=:vE_id";
				Query query = em.createQuery(req);
				query.setParameter("vE_id", ((VisaElectron) carte).getIdVisaElectron());
				
				return (T) query.getSingleResult();
				
			}catch (NullPointerException | IllegalArgumentException e){
				e.printStackTrace();
				
			}
			
		}else if(carte instanceof VisaPremium){
		
			try{
				String req = "SELECT vP FROM VisaPremium vP WHERE vP.idVisaPremium=:vP_id";
				Query query = em.createQuery(req);
				query.setParameter("vP_id", ((VisaPremium) carte).getIdVisaPremium());
				
				return (T) query.getSingleResult();
				
			}catch (NullPointerException | IllegalArgumentException e){
				e.printStackTrace();
			}
		}
		return null;
		
	}

	/** T correspond au type de carte*/
	@Override
	public T getCarteByIdCompteDao(int id_compte, T carte) {
	EntityManager em = emf.createEntityManager();
		
		if(carte instanceof VisaElectron){
			
			try{
				String req = "SELECT vE FROM VisaElectron vE WHERE vE.compteCourant.idCompte=:c_id";
				Query query = em.createQuery(req);
				query.setParameter("c_id", ((VisaElectron) carte).getCompteCourant().getIdCompte());
				
				return (T) query.getSingleResult();
				
			}catch (NullPointerException | IllegalArgumentException e){
				e.printStackTrace();
				
			}
			
		}else if(carte instanceof VisaPremium){
		
			try{
				String req = "SELECT vP FROM VisaPremium vP WHERE vP.compteCourant.idCompte=:c_id";
				Query query = em.createQuery(req);
				query.setParameter("c_id", ((VisaPremium) carte).getCompteCourant().getIdCompte());
				
				return (T) query.getSingleResult();
				
			}catch (NullPointerException | IllegalArgumentException e){
				e.printStackTrace();
			}
		}
		return null;
		
	}
	

	

	@Override
	public void ajouterCarteDao(T carte) {
		EntityManager em = emf.createEntityManager();
		if(carte instanceof VisaElectron){
			try{
				em.getTransaction().begin();
				em.persist(carte);
				em.getTransaction().commit();
				
			}catch (NullPointerException | IllegalArgumentException e){
				e.printStackTrace();
			}
			
			
		}else if (carte instanceof VisaPremium) {
			try{
				em.getTransaction().begin();
				em.persist(carte);
				em.getTransaction().commit();
				
			} catch (NullPointerException | IllegalArgumentException e){
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public void modifierCarteDao(T carte) {
		EntityManager em = emf.createEntityManager();
		if(carte instanceof VisaElectron){
			try{
				em.getTransaction().begin();
				String req = "SELECT vE FROM VisaElectron vE WHERE vE.idVisaElectron=:vE_id";
				Query query = em.createQuery(req);
				query.setParameter("vE_id", ((VisaElectron) carte).getIdVisaElectron());
				
				VisaElectron vE=(VisaElectron) query.getSingleResult();
				
				vE.setActive(carte.getActive());
				vE.setCodePin(carte.getCodePin());
				vE.setCompteCourant(((VisaElectron) carte).getCompteCourant());
				vE.setDateExpiration(((VisaElectron) carte).getDateExpiration());
				vE.setNumeroCarte(carte.getNumeroCarte());
				vE.setPlafondCredit(((VisaElectron) carte).getPlafondCredit());
				
				em.merge(vE);
				em.getTransaction().commit();
				
				
			}catch(NullPointerException | IllegalArgumentException e){
				e.printStackTrace();
			}
		}else if (carte instanceof VisaPremium) {
			try{
				em.getTransaction().begin();
				String req = "SELECT vP FROM VisaPremium vP WHERE vP.idVisaPremium=:vP_id";
				Query query = em.createQuery(req);
				query.setParameter("vP_id", ((VisaPremium) carte).getIdVisaPremium());
				
				VisaPremium vP = (VisaPremium) query.getSingleResult();
				
				vP.setActive(carte.getActive());
				vP.setCodePin(carte.getCodePin());
				vP.setCompteCourant(((VisaPremium) carte).getCompteCourant());
				vP.setDateExpiration(((VisaPremium) carte).getDateExpiration());
				vP.setNumeroCarte(carte.getNumeroCarte());
				vP.setPlafondRetrait(((VisaPremium) carte).getPlafondRetrait());
				
				em.merge(vP);
				em.getTransaction().commit();
				
				
			}catch(NullPointerException | IllegalArgumentException e){
				e.printStackTrace();
			
		}
		
	}
}

	@Override
	public void supprimerCarteDao(T carte) {
		EntityManager em = emf.createEntityManager();
		
		if(carte instanceof VisaElectron){
			try{
				em.getTransaction().begin();
				String req = "SELECT vE FROM VisaElectron vE WHERE vE.idVisaElectron=:vE_id";
				Query query = em.createQuery(req);
				query.setParameter("vE_id", ((VisaElectron) carte).getIdVisaElectron());
				
				VisaElectron vE = (VisaElectron) query.getSingleResult();
				
				vE.setActive(false);
				
				em.merge(vE);
				em.getTransaction().commit();
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if (carte instanceof VisaPremium) {
			try{
				em.getTransaction().begin();
				String req = "SELECT vP FROM VisaPremium vP WHERE vP.idVisaPremium=:vP_id";
				Query query = em.createQuery(req);
				query.setParameter("vP_id", ((VisaPremium) carte).getIdVisaPremium());
				
				VisaPremium vP = (VisaPremium) query.getSingleResult();
				
				vP.setActive(false);
				
				em.merge(vP);
				em.getTransaction().commit();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
	}

}
