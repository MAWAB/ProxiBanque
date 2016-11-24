package fr.adaming.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Conseiller extends Personne {
	
	private int idConseiller;
	private String nomDuService;
	private String numeroImmatriculation;
	private String motDePasse;
	// transormer l'agregation entre le conseiller et le gerant
	private Gerant gerant;

	// transormer l'agregation entre le conseiller et le gerant
	private List<Client> listeClients = new ArrayList<Client>();

	
}
