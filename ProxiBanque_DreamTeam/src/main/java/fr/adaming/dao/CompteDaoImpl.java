package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Compte;

public class CompteDaoImpl <C extends Compte> implements ICompteDao<C>{

	@Override
	public List<C> getAllCompteDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public C getCompteByIdDao(int id_cn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<C> getComptesByIdClientDao(int id_client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajouterCompteDao(C compte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierCompteDao(C compte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerCompteDao(C compte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void virementDao(C compe1, C compte1, double somme) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retraitDao(C compte, double somme) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depotDao(C compte, double somme) {
		// TODO Auto-generated method stub
		
	}

}
