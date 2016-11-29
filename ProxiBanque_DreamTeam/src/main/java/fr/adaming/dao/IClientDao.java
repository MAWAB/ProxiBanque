/**
 * 
 */
package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Client;

/**
 * @author inti0302
 *
 */
public interface IClientDao {
	
	/**
	 * Ajouter un client
	 * @param client
	 */
	public void addClient(Client client);
	
	/**
	 * Modifier un client
	 * @param client
	 */
	public void updateClient(Client client);
	
	/**
	 * Supprimer un client
	 * @param id
	 */
	public void deleteClient(int id);
	
	/**
	 * Obtenir la liste de tous les clients
	 * @return
	 */
	public List<Client> getAllClients();
	
	/**
	 * Obtenir la liste de tous les clients d'un conseiller par l'idConseiller
	 * @param id
	 * @return
	 */
	public List<Client> getAllClientsByIdConseiller(int id);
	
	/**
	 * Obtenir la liste de tous les clients d'une agence par l'idAgence
	 * @param id
	 * @return
	 */
	public List<Client> getAllClientsByIdAgence(int id);
	
	/**
	 * Obtenir un client par son id
	 * @param id
	 * @return
	 */
	public Client getClientById(int id);

}
