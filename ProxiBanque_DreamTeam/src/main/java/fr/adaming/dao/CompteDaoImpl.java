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
	
	
/*
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
	*/

	@Override
	public C getCompteByIdDao(C compte) {
		EntityManager em = emf.createEntityManager();
		
		if(compte instanceof CompteCourant ){
			
			try {
				String req = "SELECT * FROM CompteCourant cmpC WHERE cmpC.idCompte=:cmp_id";
				Query query = em.createQuery(req);
				query.setParameter("cmp_id", ((CompteCourant) compte).getIdCompte());

				CompteCourant cmp = (CompteCourant) query.getSingleResult();
				return (C) cmp;
				
			} catch (NullPointerException | IllegalArgumentException e) {
				e.printStackTrace();
			}
			
						
		}else if(compte instanceof CompteEpargne ){
			try {
				String req = "SELECT * FROM CompteEpargne cmpE WHERE cmpC.idCompte=:cmp_id";
				Query query = em.createQuery(req);
				query.setParameter("cmp_id", ((CompteEpargne) compte).getIdCompte());

				CompteEpargne cmp = (CompteEpargne) query.getSingleResult();
				return (C) cmp;
				
			} catch (NullPointerException | IllegalArgumentException e) {
				e.printStackTrace();
			}	
		}
		return null;
	}

	@Override
	public List<C> getComptesCourantByIdClientDao(int id) {
		EntityManager em = emf.createEntityManager();
						
		try {
			String req = "SELECT * FROM CompteCourant cmp WHERE cmp.client.idClient=:cl_id";
			Query query = em.createQuery(req);
			query.setParameter("cl_id", id);
	
			@SuppressWarnings("unchecked")
			List<CompteCourant> listeCompteC = query.getResultList();
			return (List<C>) listeCompteC;
		} catch (NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	@Override
	public List<C> getComptesEpargneByIdClientDao(int id) {
		EntityManager em = emf.createEntityManager();
		
		try {
			String req = "SELECT * FROM CompteEpargne cmp WHERE cmp.client.idClient=:cl_id";
			Query query = em.createQuery(req);
			query.setParameter("cl_id", id);
	
			@SuppressWarnings("unchecked")
			List<CompteEpargne> listeCompteE = query.getResultList();
			return (List<C>) listeCompteE;
		} catch (NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		
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
	public void virementDao(C compte1, C compte2, double somme) {
		EntityManager em = emf.createEntityManager();
		
		if(compte1 instanceof CompteCourant && compte2 instanceof CompteCourant){
			try {
				String req1 = "SELECT cmpC FROM CompteCourant cmpC WHERE cmpC.idCompte=:cmp_id1";
				Query query1 = em.createQuery(req1);
				query1.setParameter("cmp_id1", ((CompteCourant) compte1).getIdCompte());
		
				CompteCourant cmpC1 = (CompteCourant) query1.getSingleResult();
								
				cmpC1.setSolde(compte1.getSolde()-somme);
				em.merge(cmpC1);
				
				
				String req2 = "SELECT cmpC FROM CompteCourant cmpC WHERE cmpC.idCompte=:cmp_id2";
				Query query2 = em.createQuery(req2);
				query2.setParameter("cmp_id2", ((CompteCourant) compte2).getIdCompte());
		
				CompteCourant cmpC2 = (CompteCourant) query2.getSingleResult();
								
				cmpC2.setSolde(compte2.getSolde()+somme);
				em.merge(cmpC2);
				
			} catch (NullPointerException | IllegalArgumentException e) {
				e.printStackTrace();
			}
			
		}else if(compte1 instanceof CompteCourant && compte2 instanceof CompteEpargne ){
			try {
				String req1 = "SELECT cmpC FROM CompteCourant cmpC WHERE cmpC.idCompte=:cmp_id1";
				Query query1 = em.createQuery(req1);
				query1.setParameter("cmp_id1", ((CompteCourant) compte1).getIdCompte());
		
				CompteCourant cmpC1 = (CompteCourant) query1.getSingleResult();
								
				cmpC1.setSolde(compte1.getSolde()-somme);
				em.merge(cmpC1);
				
				
				String req2 = "SELECT cmpC FROM CompteCourant cmpC WHERE cmpC.idCompte=:cmp_id2";
				Query query2 = em.createQuery(req2);
				query2.setParameter("cmp_id2", ((CompteCourant) compte2).getIdCompte());
		
				CompteCourant cmpC2 = (CompteCourant) query2.getSingleResult();
								
				cmpC2.setSolde(compte2.getSolde()+somme);
				em.merge(cmpC2);
				
			} catch (NullPointerException | IllegalArgumentException e) {
				e.printStackTrace();
			}
			
			
		}else if(compte1 instanceof CompteEpargne && compte2 instanceof CompteCourant){
			try {
				String req1 = "SELECT cmpC FROM CompteCourant cmpC WHERE cmpC.idCompte=:cmp_id1";
				Query query1 = em.createQuery(req1);
				query1.setParameter("cmp_id1", ((CompteCourant) compte1).getIdCompte());
		
				CompteCourant cmpC1 = (CompteCourant) query1.getSingleResult();
								
				cmpC1.setSolde(compte1.getSolde()-somme);
				em.merge(cmpC1);
				
				
				String req2 = "SELECT cmpC FROM CompteCourant cmpC WHERE cmpC.idCompte=:cmp_id2";
				Query query2 = em.createQuery(req2);
				query2.setParameter("cmp_id2", ((CompteCourant) compte2).getIdCompte());
		
				CompteCourant cmpC2 = (CompteCourant) query2.getSingleResult();
								
				cmpC2.setSolde(compte2.getSolde()+somme);
				em.merge(cmpC2);
				
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
