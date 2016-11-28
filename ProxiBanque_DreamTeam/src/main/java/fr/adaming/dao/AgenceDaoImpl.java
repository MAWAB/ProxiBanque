package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Agence;
import fr.adaming.model.Client;

@Repository("agenceDaoImpl")
public class AgenceDaoImpl implements IAgenceDao{

	@Autowired
	private EntityManagerFactory emf;
	
	@Override
	public List<Agence> getAllAgences() {
		EntityManager em = emf.createEntityManager();
		try {
			String req = "SELECT a FROM Agence a";
			Query query = em.createQuery(req);

			@SuppressWarnings("unchecked")
			List<Agence> listeAgence = query.getResultList();
			return listeAgence;
		} catch (NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Agence getAgenceById(int id_agence) {


		
		EntityManager em = emf.createEntityManager();
		try {
			String req = "SELECT a FROM Agence a WHERE a.idAgence=:aId";
			Query query = em.createQuery(req);
			query.setParameter("aId", id_agence);

			Agence agence = (Agence) query.getSingleResult();
			return agence;
		} catch (NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}
		
	/**
	 * @param emf the emf to set
	 */
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	
}
