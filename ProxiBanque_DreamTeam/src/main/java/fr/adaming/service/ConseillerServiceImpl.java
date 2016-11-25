package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.dao.IConseillerDao;
import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;

@Service("conseillerService")
@Transactional
public class ConseillerServiceImpl implements IConseillerService {

	@Autowired
	@Qualifier("conseillerDaoImpl")
	IConseillerDao conseillerDao;

	@Autowired
	@Qualifier("clientDaoImpl")
	IClientDao clientDao;

	@Override
	public Conseiller getConseillerByIdService(int id) {

		return conseillerDao.getConseillerByIdDao(id);
	}

	@Override
	public List<Conseiller> getAllConseillerService() {

		return conseillerDao.getAllConseillerDao();
	}

	@Override
	public Conseiller addConseillerService(Conseiller conseiller) {
		System.out.println("-----------------Add ConseillerServiceImpl------------------");
		return conseillerDao.addConseillerDao(conseiller);
	}

	@Override
	public int deleteConseillerService(Conseiller conseiller) { 		// retourne 0 si la méthode fonctionne
																		// retourne 1 s'il n'est pas possible de supprimer le conseiller

		// Nombre de clients sous le conseiller que l'on veut supprimer
		int nb = clientDao.getAllClientsByIdConseiller(conseiller.getIdConseiller()).size();

		if (nb == 0) { // S'il n'y a pas de client, pas de soucis pour supprimer

			conseillerDao.deleteConseillerDao(conseiller);
			return 0;

		} else { // Si il a des clients

			int nbConseillers = conseillerDao.getConseillerByAgenceDao(conseiller.getGerant().getAgence().getIdAgence()).size();
			int nbClient = clientDao.getAllClientsByIdAgence(conseiller.getGerant().getAgence().getIdAgence()).size();

			if (nbClient / (nbConseillers - 1) > 10) { // Si il y a trop de clients pour le nombre de conseiller

				return 1;

			} else { // Dispatcher les clients du conseiller avant de le supprimer

				List<Client> clients = clientDao.getAllClientsByIdConseiller(conseiller.getIdConseiller());
				List<Conseiller> conseillers = conseillerDao
						.getConseillerByAgenceDao(conseiller.getGerant().getAgence().getIdAgence());

				// Retirer le conseiller de la liste
				conseillers.remove(conseiller);

				// Placer ses clients aux autres conseillers
				for (Client cl : clients) {

					int place = 0;
					int i = 0;
					while (place == 0) { // tant que le client n'est pas placé, parcourir la liste des conseillers

						Conseiller c = conseillers.get(i);

						if (clientDao.getAllClientsByIdConseiller(c.getIdConseiller()).size() < 10) { // Si le conseiller à moins de 10 clients
							cl.setConseiller(c); // Modifier le conseiller du client
							clientDao.updateClient(cl); // màj la BDD
							place = 1; 	// Sortir du while
							
						} else {	// Si le conseiller a déjà 10 clients
							i++;	// passer au conseiller suivant
						}
					}
				}

				conseillerDao.deleteConseillerDao(conseiller);
				return 0; // La méthode se termine correctement
			}

		}
	}

	@Override
	public Conseiller updateConseillerService(Conseiller conseiller) {

		return conseillerDao.updateConseillerDao(conseiller);
	}

	@Override
	public List<Conseiller> getConseillerByAgenceService(int id) {

		return conseillerDao.getConseillerByAgenceDao(id);
	}

}
