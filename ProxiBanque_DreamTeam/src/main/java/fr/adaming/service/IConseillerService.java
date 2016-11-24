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

	public Conseiller getConseillerByIdDao(int id);
	public List<Conseiller> getAllConseillerDao();
	public Conseiller addConseillerDao(Conseiller conseiller);
	public void deleteConseillerDao(Conseiller conseiller);
	public Conseiller updateConseillerDao(Conseiller conseiller);
	
}
