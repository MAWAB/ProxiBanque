package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Adresse;
import fr.adaming.model.Conseiller;

@Repository("conseillerDaoImpl")
public class ConseillerDaoImpl implements IConseillerDao {

	@PersistenceContext
	private EntityManager em;

	/**
	 * @param em the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Conseiller getConseillerByIdDao(int id) {
		Conseiller cons = em.find(Conseiller.class, id);

		return cons;
	}

	@Override
	public List<Conseiller> getAllConseillerDao() {
		String req = "SELECT c FROM Conseiller c";
		Query query = em.createQuery(req);
		List<Conseiller> liste = query.getResultList();
		
		return liste;
	}

	@Override
	public Conseiller addConseillerDao(Conseiller conseiller) {
		em.persist(conseiller);
		return conseiller;
	}

	@Override
	public void deleteConseillerDao(Conseiller conseiller) {
		em.remove(em.getReference(Conseiller.class, conseiller.getIdConseiller()));
	}

	@Override
	public Conseiller updateConseillerDao(Conseiller conseiller) {
		
		String req = "SELECT c FROM Conseiller c WHERE c.idConseiller=:id";
		Query query = em.createQuery(req);
		query.setParameter("id", conseiller.getIdConseiller());
		
		Conseiller c = (Conseiller) query.getSingleResult();
		
		Adresse adresse = conseiller.getAdresse();
		em.merge(adresse);
		
		c.setNom(conseiller.getNom());
		c.setPrenom(conseiller.getPrenom());
		c.setDateDeNaissance(conseiller.getDateDeNaissance());
		//c.setAdresse(conseiller.getAdresse());
		c.setNomDuService(conseiller.getNomDuService());
		c.setNumeroImmatriculation(conseiller.getNumeroImmatriculation());
		c.setMotDePasse(conseiller.getMotDePasse());
		//c.setGerant(conseiller.getGerant());
		//c.setListeClients(conseiller.getListeClients());
		 
		em.detach(c);
		em.merge(c);
		
		return conseiller;
	}



	@Override
	public List<Conseiller> getConseillerByAgenceDao(int id) {

		String req = "SELECT c FROM Conseiller c WHERE c.gerant.agence.idAgence=:id";
		Query query = em.createQuery(req);
		query.setParameter("id", id);
		
		return query.getResultList();
	}

}
