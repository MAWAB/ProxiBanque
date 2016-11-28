package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Placement;

public interface IPlacementService {

	public void addPlacementService(Placement placement);

	public void updatePlacementService(Placement placement);

	public void deletePlacementService(int id);

	public List<Placement> getAllPlacementsService();

	public List<Placement> getAllPlacementsByIdPlaceService(int id);

	public List<Placement> getAllPlacementByIdClientService(int id);

	public Placement getPlacementByIdService(int id);

}
