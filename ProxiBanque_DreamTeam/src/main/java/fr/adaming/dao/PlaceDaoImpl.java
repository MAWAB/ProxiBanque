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

import fr.adaming.model.Place;

/**
 * @author inti0302
 *
 */
@Repository("placeDaoImpl")
public class PlaceDaoImpl implements IPlaceDao {

	@Autowired
	private EntityManagerFactory emf;

	/**
	 * @param emf
	 *            the emf to set
	 */
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	/* (non-Javadoc)
	 * @see fr.adaming.dao.IPlaceDao#updatePlace(fr.adaming.model.Place)
	 */
	@Override
	public void updatePlace(Place place) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			String req = "SELECT pl FROM Place pl WHERE pl.idPlace=:aId";
			Query query = em.createQuery(req);
			query.setParameter("aId", place.getIdPlace());

			Place pl = (Place) query.getSingleResult();
			pl.setListeCl(place.getListeCl());
			pl.setListePl(place.getListePl());
			em.merge(pl);
			em.getTransaction().commit();
		} catch (NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * @see fr.adaming.dao.IPlaceDao#getAllPlace()
	 */
	@Override
	public List<Place> getAllPlace() {
		EntityManager em = emf.createEntityManager();
		try {
			String req = "SELECT pl FROM Place pl";
			Query query = em.createQuery(req);

			@SuppressWarnings("unchecked")
			List<Place> listePlace = query.getResultList();
			return listePlace;
		} catch (NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.adaming.dao.IPlaceDao#getPlaceByIdClient(int)
	 */
	@Override
	public Place getPlaceByIdClient(int id) {
		EntityManager em = emf.createEntityManager();
		try {
			String req = "SELECT pl FROM Place pl JOIN pl.listeCl c WHERE c.idClient=:aId";
			Query query = em.createQuery(req);
			query.setParameter("aId", id);

			Place pl = (Place) query.getSingleResult();
			return pl;
		} catch (NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.adaming.dao.IPlaceDao#getPlaceByIdPlacement(int)
	 */
	@Override
	public Place getPlaceByIdPlacement(int id) {
		EntityManager em = emf.createEntityManager();
		try {
			String req = "SELECT pl FROM Place pl JOIN pl.listePl p WHERE p.idPlacement=:aId";
			Query query = em.createQuery(req);
			query.setParameter("aId", id);

			Place pl = (Place) query.getSingleResult();
			return pl;
		} catch (NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.adaming.dao.IPlaceDao#getPlaceById(int)
	 */
	@Override
	public Place getPlaceById(int id) {
		EntityManager em = emf.createEntityManager();
		try {
			String req = "SELECT pl FROM Place pl WHERE pl.idPlace=:aId";
			Query query = em.createQuery(req);
			query.setParameter("aId", id);

			Place pl = (Place) query.getSingleResult();

			return pl;
		} catch (NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

}
