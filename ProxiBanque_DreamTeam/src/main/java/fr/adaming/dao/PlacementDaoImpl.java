/**
 * 
 */
package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Placement;

/**
 * @author inti0302
 *
 */
@Repository("placementDaoImpl")
public class PlacementDaoImpl implements IPlacementDao {

	@Autowired
	private EntityManagerFactory emf;

	/**
	 * @param emf
	 *            the emf to set
	 */
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.adaming.dao.IPlacementDao#addPlacement(fr.adaming.model.Placement)
	 */
	@Override
	public void addPlacement(Placement placement) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(placement);
		em.getTransaction().commit();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.adaming.dao.IPlacementDao#updatePlacement(fr.adaming.model.Placement)
	 */
	@Override
	public void updatePlacement(Placement placement) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			String req = "SELECT pl FROM Placement pl WHERE pl.idPlacement=:aId";
			Query query = em.createQuery(req);
			query.setParameter("aId", placement.getIdPlacement());

			Placement pl = (Placement) query.getSingleResult();
			pl.setSomme(placement.getSomme());
			em.merge(pl);
			em.getTransaction().commit();
		} catch (NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.dao.IPlacementDao#deletePlacement(int)
	 */
	@Override
	public void deletePlacement(int id) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			String req = "SELECT pl FROM Placement pl WHERE pl.idPlacement=:aId";
			Query query = em.createQuery(req);
			query.setParameter("aId", id);

			Placement pl = (Placement) query.getSingleResult();

			em.remove(pl);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.dao.IPlacementDao#getAllPlacements()
	 */
	@Override
	public List<Placement> getAllPlacements() {
		EntityManager em = emf.createEntityManager();
		try {
			String req = "SELECT pl FROM Placement pl";
			Query query = em.createQuery(req);

			@SuppressWarnings("unchecked")
			List<Placement> listePlacement = query.getResultList();
			return listePlacement;
		} catch (NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.dao.IPlacementDao#getAllPlacementsByIdPlace(int)
	 */
	@Override
	public List<Placement> getAllPlacementsByIdPlace(int id) {
		EntityManager em = emf.createEntityManager();
		try {
			String req = "SELECT pl FROM Placement pl WHERE pl.place.idPlace=:aId";
			Query query = em.createQuery(req);
			query.setParameter("aId", id);

			@SuppressWarnings("unchecked")
			List<Placement> listePlacement = query.getResultList();
			return listePlacement;
		} catch (NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.dao.IPlacementDao#getAllPlacementByIdClient(int)
	 */
	@Override
	public List<Placement> getAllPlacementByIdClient(int id) {
		EntityManager em = emf.createEntityManager();
		try {
			String req = "SELECT pl FROM Placement pl WHERE pl.client.idClient=:aId";
			Query query = em.createQuery(req);
			query.setParameter("aId", id);

			@SuppressWarnings("unchecked")
			List<Placement> listePlacement = query.getResultList();
			return listePlacement;
		} catch (NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.dao.IPlacementDao#getPlacementById(int)
	 */
	@Override
	public Placement getPlacementById(int id) {
		EntityManager em = emf.createEntityManager();
		try {
			String req = "SELECT pl FROM Placement pl WHERE pl.idPlacement=:aId";
			Query query = em.createQuery(req);
			query.setParameter("aId", id);

			Placement pl = (Placement) query.getSingleResult();

			return pl;
		} catch (NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

}
