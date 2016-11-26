package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Conseiller;

@Repository("conseillerDaoImpl")
public class ConseillerDaoImpl implements IConseillerDao {

	@Autowired
	private EntityManagerFactory emf;

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	

	@Override
	public Conseiller getConseillerByIdDao(int id) {
		EntityManager em = emf.createEntityManager();
		Conseiller cons = em.find(Conseiller.class, id);

		return cons;
	}

	@Override
	public List<Conseiller> getAllConseillerDao() {
		EntityManager em = emf.createEntityManager();
		String req = "SELECT c FROM Conseiller c";
		Query query = em.createQuery(req);
		List<Conseiller> liste = query.getResultList();
		
		return liste;
	}

	@Override
	public Conseiller addConseillerDao(Conseiller conseiller) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(conseiller);
	
		em.getTransaction().commit();
		return conseiller;
	}

	@Override
	public void deleteConseillerDao(Conseiller conseiller) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.getReference(Conseiller.class, conseiller.getIdConseiller()));
		em.getTransaction().commit();
	}

	@Override
	public Conseiller updateConseillerDao(Conseiller conseiller) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		System.out.println("----------------Dao après begin transaction------------------------");
		String req = "SELECT c FROM Conseiller c WHERE c.idConseiller=:id";
		Query query = em.createQuery(req);
		query.setParameter("id", conseiller.getIdConseiller());
		
		Conseiller c = (Conseiller) query.getSingleResult();
		System.out.println("--------------Avant set-----------------"+c.getPrenom());
		
		c.setNom(conseiller.getNom());
		c.setPrenom(conseiller.getPrenom());
		c.setDateDeNaissance(conseiller.getDateDeNaissance());
		c.setAdresse(conseiller.getAdresse());
		c.setNomDuService(conseiller.getNomDuService());
		c.setNumeroImmatriculation(conseiller.getNumeroImmatriculation());
		c.setMotDePasse(conseiller.getMotDePasse());
		c.setGerant(conseiller.getGerant());
		c.setListeClients(conseiller.getListeClients());
		
		System.out.println("------------Après set--------------"+c.getPrenom());
		em.detach(c);
		System.out.println("------------Detach-------------");
		em.merge(c);
		System.out.println("-----------------merge----------------");
		em.getTransaction().commit();
		
		return conseiller;
	}



	@Override
	public List<Conseiller> getConseillerByAgenceDao(int id) {

		EntityManager em = emf.createEntityManager();
		String req = "SELECT c FROM Conseiller c WHERE c.gerant.agence.idAgence=:id";
		Query query = em.createQuery(req);
		query.setParameter("id", id);
		
		return query.getResultList();
	}

}
