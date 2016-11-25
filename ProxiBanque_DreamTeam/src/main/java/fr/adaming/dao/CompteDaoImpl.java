package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.CompteEpargne;

@Repository
public class CompteDaoImpl <C extends Compte> implements ICompteDao<C>{

	@Autowired
	private EntityManagerFactory emf;	
	
	/**
	 * @param emf the emf to set
	 */
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	

	@Override
	public List<C> getAllCompteCourantDao() {
		
		EntityManager em = emf.createEntityManager();
		
		try {
			String req = "SELECT * FROM CompteCourant cmpC";
			Query query = em.createQuery(req);

			@SuppressWarnings("unchecked")
			List<CompteCourant> listeCompteC = query.getResultList();
			return (List<C>) listeCompteC;
			
		} catch (NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<C> getAllCompteEpargneDao() {
		
		EntityManager em = emf.createEntityManager();
		
		try {
			String req = "SELECT * FROM CompteEpargne cmpC";
			Query query = em.createQuery(req);

			@SuppressWarnings("unchecked")
			List<CompteEpargne> listeCompteE = query.getResultList();
			return (List<C>) listeCompteE;
			
		} catch (NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public C getCompteByIdDao(int id_cn) {
		EntityManager em = emf.createEntityManager();
		try {
			String req = "SELECT * FROM Client cl WHERE cl.idClient=:aId";
			Query query = em.createQuery(req);
			query.setParameter("aId", id);

			Client cl = (Client) query.getSingleResult();
			return cl;
		} catch (NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<C> getComptesByIdClientDao(int id_client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajouterCompteDao(C compte) {
		EntityManager em = emf.createEntityManager();
		
		if(compte instanceof CompteCourant ){
			em.persist(compte);
			
		}else if(compte instanceof CompteEpargne ){
			em.persist(compte);
		}
		
		
	}

	@Override
	public void modifierCompteDao(C compte) {
		EntityManager em = emf.createEntityManager();
		
		if(compte instanceof CompteCourant ){
			try {
				String req = "SELECT cmpC FROM CompteCourant cmpC WHERE cmpC.idCompte=:cmp_id";
				Query query = em.createQuery(req);
				query.setParameter("cmp_id", ((CompteCourant) compte).getIdCompte());
		
				CompteCourant cmpC = (CompteCourant) query.getSingleResult();
				
				cmpC.setClient(((CompteCourant) compte).getClient());
				cmpC.setDateCreation(((CompteCourant) compte).getDateCreation());
				cmpC.setDecouvert(((CompteCourant) compte).getDecouvert());
				cmpC.setVisaElectron(((CompteCourant) compte).getVisaElectron());
				cmpC.setVisaPremium(((CompteCourant) compte).getVisaPremium());
				cmpC.setNumeroCompte(compte.getNumeroCompte());
				cmpC.setSolde(compte.getSolde());
				em.merge(cmpC);
				
			} catch (NullPointerException | IllegalArgumentException e) {
				e.printStackTrace();
			}
			
		}else if(compte instanceof CompteEpargne ){
			try {
				String req = "SELECT cmpE FROM CompteEpargne cmpE WHERE cmpE.idCompte=:cmp_id";
				Query query = em.createQuery(req);
				query.setParameter("cmp_id", ((CompteEpargne) compte).getIdCompte());
		
				CompteEpargne cmpE = (CompteEpargne) query.getSingleResult();
				
				cmpE.setClient(((CompteEpargne) compte).getClient());
				cmpE.setDateCreation(((CompteEpargne) compte).getDateCreation());
				cmpE.setTauxRenumeration(((CompteEpargne) compte).getTauxRenumeration());
				cmpE.setNumeroCompte(compte.getNumeroCompte());
				cmpE.setSolde(compte.getSolde());
				em.merge(cmpE);
				
			} catch (NullPointerException | IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void supprimerCompteDao(C compte) {
		EntityManager em = emf.createEntityManager();
		
		if(compte instanceof CompteCourant ){
			try {
				String req = "SELECT cmpC FROM CompteCourant cmpC WHERE cmpC.idCompte=:cmp_id";
				Query query = em.createQuery(req);
				query.setParameter("cmp_id", ((CompteCourant) compte).getIdCompte());

				CompteCourant cmpC = (CompteCourant) query.getSingleResult();
				em.remove(cmpC);
				
			} catch (Exception e) {
				e.printStackTrace();
			}			
			
						
		}else if(compte instanceof CompteEpargne ){
			try {
				String req = "SELECT cmpE FROM CompteEpargne cmpE WHERE cmpE.idCompte=:cmp_id";
				Query query = em.createQuery(req);
				query.setParameter("cmp_id", ((CompteEpargne) compte).getIdCompte());

				CompteEpargne cmpE = (CompteEpargne) query.getSingleResult();
				em.remove(cmpE);
				
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		
		
		
	}

	@Override
	public void virementDao(C compe1, C compte2, double somme) {
EntityManager em = emf.createEntityManager();
		
		if(compte instanceof CompteCourant ){
			try {
				String req = "SELECT cmpC FROM CompteCourant cmpC WHERE cmpC.idCompte=:cmp_id";
				Query query = em.createQuery(req);
				query.setParameter("cmp_id", ((CompteCourant) compte).getIdCompte());
		
				CompteCourant cmpC = (CompteCourant) query.getSingleResult();
								
				cmpC.setSolde(compte.getSolde()+somme);
				em.merge(cmpC);
				
			} catch (NullPointerException | IllegalArgumentException e) {
				e.printStackTrace();
			}
			
		}else if(compte instanceof CompteEpargne ){
			try {
				String req = "SELECT cmpE FROM CompteEpargne cmpE WHERE cmpE.idCompte=:cmp_id";
				Query query = em.createQuery(req);
				query.setParameter("cmp_id", ((CompteEpargne) compte).getIdCompte());
		
				CompteEpargne cmpE = (CompteEpargne) query.getSingleResult();
				
				cmpE.setSolde(compte.getSolde()+somme);
				em.merge(cmpE);
				
			} catch (NullPointerException | IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void retraitDao(C compte, double somme) {
		EntityManager em = emf.createEntityManager();
		
		if(compte instanceof CompteCourant ){
			try {
				String req = "SELECT cmpC FROM CompteCourant cmpC WHERE cmpC.idCompte=:cmp_id";
				Query query = em.createQuery(req);
				query.setParameter("cmp_id", ((CompteCourant) compte).getIdCompte());
		
				CompteCourant cmpC = (CompteCourant) query.getSingleResult();
								
				cmpC.setSolde(compte.getSolde()-somme);
				em.merge(cmpC);
				
			} catch (NullPointerException | IllegalArgumentException e) {
				e.printStackTrace();
			}
			
		}else if(compte instanceof CompteEpargne ){
			try {
				String req = "SELECT cmpE FROM CompteEpargne cmpE WHERE cmpE.idCompte=:cmp_id";
				Query query = em.createQuery(req);
				query.setParameter("cmp_id", ((CompteEpargne) compte).getIdCompte());
		
				CompteEpargne cmpE = (CompteEpargne) query.getSingleResult();
				
				cmpE.setSolde(compte.getSolde()-somme);
				em.merge(cmpE);
				
			} catch (NullPointerException | IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void depotDao(C compte, double somme) {
		EntityManager em = emf.createEntityManager();
		
		if(compte instanceof CompteCourant ){
			try {
				String req = "SELECT cmpC FROM CompteCourant cmpC WHERE cmpC.idCompte=:cmp_id";
				Query query = em.createQuery(req);
				query.setParameter("cmp_id", ((CompteCourant) compte).getIdCompte());
		
				CompteCourant cmpC = (CompteCourant) query.getSingleResult();
								
				cmpC.setSolde(compte.getSolde()+somme);
				em.merge(cmpC);
				
			} catch (NullPointerException | IllegalArgumentException e) {
				e.printStackTrace();
			}
			
		}else if(compte instanceof CompteEpargne ){
			try {
				String req = "SELECT cmpE FROM CompteEpargne cmpE WHERE cmpE.idCompte=:cmp_id";
				Query query = em.createQuery(req);
				query.setParameter("cmp_id", ((CompteEpargne) compte).getIdCompte());
		
				CompteEpargne cmpE = (CompteEpargne) query.getSingleResult();
				
				cmpE.setSolde(compte.getSolde()+somme);
				em.merge(cmpE);
				
			} catch (NullPointerException | IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		
	}

}
