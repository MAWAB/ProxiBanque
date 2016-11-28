package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Placement;

public interface IPlacementDao {
	
	public void addPlacement(Placement placement);
	
	public void updatePlacement(Placement placement);
	
	public void deletePlacement(int id);
	
	public List<Placement> getAllPlacements();
	
	public List<Placement> getAllPlacementsByIdPlace(int id);
	
	public List<Placement> getAllPlacementByIdClient(int id);
	
	public Placement getPlacementById(int id);
}
