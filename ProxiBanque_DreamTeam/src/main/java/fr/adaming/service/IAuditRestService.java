package fr.adaming.service;

import java.util.List;
import fr.adaming.model.Agence;
import fr.adaming.model.Conseiller;

public interface IAuditRestService {

	public List<Agence> getAllAgences();
	public Agence getAgenceById(int id_agence);
	public List<fr.adaming.model.Client> getAllClients();
	public int getNumberCompteEpargne();
	public int getNumberCompteCourant();
	public int getNumberCompteEpargneValorisee();
	public int getNumberCompteCourantEnDefaut();
	public int getNumberClients();
	public List<Conseiller> getAllConseillers();
	public int getNumberConseillers();
}
