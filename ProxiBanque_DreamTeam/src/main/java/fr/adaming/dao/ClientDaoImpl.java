/**
 * 
 */
package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;

/**
 * @author inti0302
 *
 */
@Repository("clientDaoImpl")
public class ClientDaoImpl implements IClientDao {

	@PersistenceContext
	private EntityManager em;

	/**
	 * @param emf
	 *            the emf to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.dao.IClientDao#addClient(fr.adaming.model.Client)
	 */
	@Override
	public void addClient(Client client) {

		em.persist(client);
	
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.dao.IClientDao#updateClient(fr.adaming.model.Client)
	 */
	@Override
	public void updateClient(Client client) {
		
		try {
			
			String req = "SELECT cl FROM Client cl WHERE cl.idClient=:aId";
			Query query = em.createQuery(req);
			query.setParameter("aId", client.getIdClient());

			Client cl = (Client) query.getSingleResult();
			cl.setDateDeNaissance(client.getDateDeNaissance());
			cl.setNom(client.getNom());
			cl.setNumeroClient(client.getNumeroClient());
			cl.setPrenom(client.getPrenom());
			cl.setTelephone(client.getTelephone());
			cl.setAdresse(client.getAdresse());
			cl.setPlace(client.getPlace());
			em.merge(cl);
		
		} catch (NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.dao.IClientDao#deleteClient(int)
	 */
	@Override
	public void deleteClient(int id) {

		try {

			String req = "SELECT cl FROM Client cl WHERE cl.idClient=:aId";
			Query query = em.createQuery(req);
			query.setParameter("aId", id);

			Client cl = (Client) query.getSingleResult();
			
			em.remove(cl);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.dao.IClientDao#getAllClients()
	 */
	@Override
	public List<Client> getAllClients() {
	
		try {
			String req = "SELECT cl FROM Client cl";
			Query query = em.createQuery(req);

			@SuppressWarnings("unchecked")
			List<Client> listeClient = query.getResultList();
			return listeClient;
		} catch (NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.dao.IClientDao#getAllClientsByIdConseiller()
	 */
	@Override
	public List<Client> getAllClientsByIdConseiller(int id) {
	
		try {
			String req = "SELECT cl FROM Client cl WHERE cl.conseiller.idConseiller=:aId";
			Query query = em.createQuery(req);
			query.setParameter("aId", id);

			@SuppressWarnings("unchecked")
			List<Client> listeClient = query.getResultList();
			return listeClient;
		} catch (NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.dao.IClientDao#getAllClientsByIdConseiller()
	 */
	@Override
	public List<Client> getAllClientsByIdAgence(int id) {
	
		try {
			String req = "SELECT cl FROM Client cl WHERE cl.conseiller.gerant.agence.idAgence=:aId";
			Query query = em.createQuery(req);
			query.setParameter("aId", id);

			@SuppressWarnings("unchecked")
			List<Client> listeClient = query.getResultList();
			return listeClient;
		} catch (NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.dao.IClientDao#getClientById(int)
	 */
	@Override
	public Client getClientById(int id) {
	
		try {
			String req = "SELECT cl FROM Client cl WHERE cl.idClient=:aId";
			Query query = em.createQuery(req);
			query.setParameter("aId", id);

			Client cl = (Client) query.getSingleResult();
			return cl;
		} catch (NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

}
