package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.model.Conseiller;

public class ConseillerDaoImpl implements IConseillerDao {

	@Autowired
	private EntityManagerFactory emf;

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	EntityManager em = emf.createEntityManager();

	@Override
	public Conseiller getConseillerByIdDao(int id) {

		Conseiller cons = em.find(Conseiller.class, id);

		return cons;
	}

	@Override
	public List<Conseiller> getAllConseillerDao() {

		String req = "SELECT c FROM Conseiller";
		Query query = em.createQuery(req);

		return query.getResultList();
	}

	@Override
	public Conseiller addConseillerDao(Conseiller conseiller) {

		em.persist(conseiller);

		return conseiller;
	}

	@Override
	public void deleteConseillerDao(Conseiller conseiller) {

		em.remove(conseiller);
	}

	@Override
	public Conseiller updateConseillerDao(Conseiller conseiller) {

		String req = "UPDATE Conseiller c SET c.nom=:nom, c.prenom=:prenom, c.dateDeNaissance=:dN, c.adresse=:adresse, c.nomDuService=:serv, c.numeroImmatriculation=:imm, c.motDePasse=:mdp WHERE c.idConseiller=:id";
		Query query = em.createQuery(req);
		query.setParameter("nom", conseiller.getNom());
		query.setParameter("prenom", conseiller.getPrenom());
		query.setParameter("dN", conseiller.getDateDeNaissance());
		query.setParameter("adresse", conseiller.getAdresse());
		query.setParameter("serv", conseiller.getNomDuService());
		query.setParameter("imm", conseiller.getNumeroImmatriculation());
		query.setParameter("mdp", conseiller.getMotDePasse());
		
		return conseiller;
	}

}
