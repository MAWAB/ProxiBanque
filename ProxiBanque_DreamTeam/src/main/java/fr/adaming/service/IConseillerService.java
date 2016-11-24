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

	public Conseiller getConseillerByIdService(int id);
	public List<Conseiller> getAllConseillerService();
	public Conseiller addConseillerService(Conseiller conseiller);
	public void deleteConseillerService(Conseiller conseiller);
	public Conseiller updateConseillerService(Conseiller conseiller);
	
}
