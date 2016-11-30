/**
 * 
 */
package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;

/**
 * @author inti0302
 *
 */
public interface IClientService {

	public int addClientService(Client client);

	public void updateClientService(Client client);

	public int deleteClientService(int id);

	public List<Client> getAllClientsService();

	public List<Client> getAllClientsByIdConseillerService(int id);

	public List<Client> getAllClientsByIdAgenceService(int id);

	public Client getClientByIdService(int id);

}
