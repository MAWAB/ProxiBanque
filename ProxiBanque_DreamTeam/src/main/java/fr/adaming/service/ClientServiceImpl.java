/**
 * 
 */
package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

/**
 * @author inti0302
 *
 */
@Service("clientServiceImpl")
@Transactional
public class ClientServiceImpl implements IClientService {

	@Autowired
	@Qualifier("clientDaoImpl")
	IClientDao clientDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.service.IClientService#addClientService(fr.adaming.model.
	 * Client)
	 */
	@Override
	public int addClientService(Client client) {
		if (client.getConseiller().getListeClients().size() < 10) {
			clientDao.addClient(client);
			return 1;
		} else {
			return 0;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.adaming.service.IClientService#updateClientService(fr.adaming.model.
	 * Client)
	 */
	@Override
	public void updateClientService(Client client) {
		clientDao.updateClient(client);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.service.IClientService#deleteClientService(int)
	 */
	@Override
	public void deleteClientService(int id) {
		clientDao.deleteClient(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.service.IClientService#getAllClientsService()
	 */
	@Override
	public List<Client> getAllClientsService() {
		return clientDao.getAllClients();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.adaming.service.IClientService#getAllClientsByIdConseillerService(int)
	 */
	@Override
	public List<Client> getAllClientsByIdConseillerService(int id) {
		return clientDao.getAllClientsByIdConseiller(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.adaming.service.IClientService#getAllClientsByIdAgenceService(int)
	 */
	@Override
	public List<Client> getAllClientsByIdAgenceService(int id) {
		return clientDao.getAllClientsByIdAgence(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.service.IClientService#getClientByIdService(int)
	 */
	@Override
	public Client getClientByIdService(int id) {
		return clientDao.getClientById(id);
	}

}
