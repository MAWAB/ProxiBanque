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
	
	public void addClient(Client client);
	
	public void updateClient(Client client);
	
	public void deleteClient(int id);
	
	public List<Client> getAllClients();
	
	public List<Client> getAllClientsByIdConseiller(int id);
	
	public List<Client> getAllClientsByIdAgence(int id);
	
	public Client getClientById(int id);

}
