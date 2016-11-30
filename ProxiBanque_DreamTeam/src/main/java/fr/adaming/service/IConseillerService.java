/**
 * 
 */
package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Conseiller;

/**
 * @author inti0302
 *
 */
public interface IConseillerService {
	
	public int isExistService(String numeroImmatriculation, String motDePasse);
	//public int isExistService(String numeroImmatriculation, String motDePasse);
	public Conseiller getConseillerByIdService(int id);
	public List<Conseiller> getAllConseillerService();
	public Conseiller addConseillerService(Conseiller conseiller);
	public int deleteConseillerService(Conseiller conseiller);
	public Conseiller updateConseillerService(Conseiller conseiller);
	public List<Conseiller> getConseillerByAgenceService(int id);
	public List<Conseiller> getConseillerWithLess10ClientByAgenceService(int id);
	
}
