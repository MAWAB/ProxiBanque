/**
 * 
 */
package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Conseiller;
import fr.adaming.model.Gerant;

/**
 * @author inti0302
 *
 */
public interface IConseillerDao {
	
	public Conseiller isExistDao(String numeroImmatriculation, String motDePasse);
//	public Gerant isExistGerantDao(String numeroImmatriculation, String motDePasse);
//	public Conseiller isExistConseillerDao(String numeroImmatriculation, String motDePasse);
	public Conseiller getConseillerByIdDao(int id);
	public List<Conseiller> getAllConseillerDao();
	public Conseiller addConseillerDao(Conseiller conseiller);
	public void deleteConseillerDao(Conseiller conseiller);
	public Conseiller updateConseillerDao(Conseiller conseiller);
	public List<Conseiller> getConseillerByAgenceDao(int id);
	
}
