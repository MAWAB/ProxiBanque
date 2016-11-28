package fr.adaming.service;

import org.springframework.stereotype.Service;

import fr.adaming.dao.ICarteDao;
import fr.adaming.model.Carte;


public interface ICarteService <T extends Carte> {
	
	public T getCarteByIdService(T carte);
	
	public T getCarteByIdCompteService(int id, T carte);
	
	public void ajouterCarteService(T carte);
	
	public void modifierCarteService(T carte);
	
	public void supprimerCarteService(T carte);

}
