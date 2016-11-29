package fr.adaming.service;

import java.util.List;

import com.sun.jersey.api.client.Client;

import fr.adaming.model.Agence;

public interface IAuditRestService {

	public List<Agence> getAllAgences();
	public Agence getAgenceById(int id_agence);
	public List<Client> getAllClients();

}
