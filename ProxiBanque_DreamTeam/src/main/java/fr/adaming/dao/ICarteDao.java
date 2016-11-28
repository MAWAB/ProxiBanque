package fr.adaming.dao;

import fr.adaming.model.Carte;

public interface ICarteDao <T extends Carte> {
	
	public T getCarteByIdDao(T carte);
	
	public T getVisaElectronByIdCompteDao(int id);
	
	public T getVisaPremiumByIdCompteDao(int id);
	
	public void ajouterCarteDao(T carte);
	
	public void modifierCarteDao(T carte);
	
	public void supprimerCarteDao(T carte);

}
