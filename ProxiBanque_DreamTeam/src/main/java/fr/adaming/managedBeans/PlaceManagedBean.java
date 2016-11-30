/**
 * 
 */
package fr.adaming.managedBeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.Place;
import fr.adaming.model.Placement;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICompteService;
import fr.adaming.service.IPlaceService;
import fr.adaming.service.IPlacementService;

/**
 * @author inti0302
 *
 */
@ManagedBean(name = "placeMB")
@ViewScoped
public class PlaceManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{clientServiceImpl}")
	IClientService clientService;

	@ManagedProperty(value = "#{placeServiceImpl}")
	IPlaceService placeService;

	@ManagedProperty(value = "#{placementServiceImpl}")
	IPlacementService placementService;

	@ManagedProperty(value = "#{cmpServiceBean}")
	ICompteService<Compte> compteService;

	private Boolean fondInsuff;
	private int place = 0;
	private int somme = 0;
	private Client client;
	private List<Placement> listePlacements;
	private Placement placementTmp;

	HttpSession session;

	/**
	 * 
	 */
	public PlaceManagedBean() {
		super();
	}

	/**
	 * @return the fondInsuff
	 */
	public Boolean getFondInsuff() {
		return fondInsuff;
	}

	/**
	 * @param fondInsuff
	 *            the fondInsuff to set
	 */
	public void setFondInsuff(Boolean fondInsuff) {
		this.fondInsuff = fondInsuff;
	}

	/**
	 * @return the compteService
	 */
	public ICompteService<Compte> getCompteService() {
		return compteService;
	}

	/**
	 * @param compteService
	 *            the compteService to set
	 */
	public void setCompteService(ICompteService<Compte> compteService) {
		this.compteService = compteService;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the placeService
	 */
	public IPlaceService getPlaceService() {
		return placeService;
	}

	/**
	 * @param placeService
	 *            the placeService to set
	 */
	public void setPlaceService(IPlaceService placeService) {
		this.placeService = placeService;
	}

	/**
	 * @return the place
	 */
	public int getPlace() {
		return place;
	}

	/**
	 * @param place
	 *            the place to set
	 */
	public void setPlace(int place) {
		this.place = place;
	}

	/**
	 * @return the somme
	 */
	public int getSomme() {
		return somme;
	}

	/**
	 * @param somme
	 *            the somme to set
	 */
	public void setSomme(int somme) {
		this.somme = somme;
	}

	/**
	 * @return the clientService
	 */
	public IClientService getClientService() {
		return clientService;
	}

	/**
	 * @param clientService
	 *            the clientService to set
	 */
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	/**
	 * @return the placementService
	 */
	public IPlacementService getPlacementService() {
		return placementService;
	}

	/**
	 * @param placementService
	 *            the placementService to set
	 */
	public void setPlacementService(IPlacementService placementService) {
		this.placementService = placementService;
	}

	/**
	 * @return the listePlacements
	 */
	public List<Placement> getListePlacements() {
		return listePlacements;
	}

	/**
	 * @param listePlacements
	 *            the listePlacements to set
	 */
	public void setListePlacements(List<Placement> listePlacements) {
		this.listePlacements = listePlacements;
	}

	/**
	 * @return the placementTmp
	 */
	public Placement getPlacementTmp() {
		return placementTmp;
	}

	/**
	 * @param placementTmp
	 *            the placementTmp to set
	 */
	public void setPlacementTmp(Placement placementTmp) {
		this.placementTmp = placementTmp;
	}

	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		session = (HttpSession) facesContext.getExternalContext().getSession(false);

		this.client = (Client) session.getAttribute("client");
		this.fondInsuff = (Boolean) session.getAttribute("fondInsuff");

		if (this.client.getPlace() != null) {
			this.listePlacements = placementService.getAllPlacementByIdClientService(this.client.getIdClient());
		}
	}

	public void placer() throws IOException {

		Client cl = clientService.getClientByIdService(this.client.getIdClient());
		Place placeTmp = new Place();
		Placement placement = new Placement();

		if (this.place == 0) {
			// Id pour Paris dans la DB = 1
			placeTmp = placeService.getPlaceByIdService(1);
		} else if (this.place == 1) {
			// Id pour New-York dans la DB = 2
			placeTmp = placeService.getPlaceByIdService(2);
		} else if (this.place == 2) {
			// Id pour Tokyo dans la DB = 3
			placeTmp = placeService.getPlaceByIdService(3);
		}

		if (this.somme <= cl.getCompteEpargne().getSolde()) {
			this.fondInsuff = false;
			cl.setPlace(placeTmp);
			compteService.retraitService(cl.getCompteEpargne(), this.somme);
			clientService.updateClientService(cl);

			placement.setSomme(this.somme);
			placement.setClient(cl);
			placement.setPlace(placeTmp);

			placementService.addPlacementService(placement);

			this.client = clientService.getClientByIdService(cl.getIdClient());

		} else {
			this.fondInsuff = true;
		}
		session.setAttribute("client", this.client);
		session.setAttribute("fondInsuff", this.fondInsuff);

		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());

	}

	public void nouveauPlacement() throws IOException {

		Client cl = clientService.getClientByIdService(this.client.getIdClient());

		Place place = this.client.getPlace();

		Placement placement = new Placement();
		if (this.somme <= cl.getCompteEpargne().getSolde()) {
			this.fondInsuff = false;
			compteService.retraitService(cl.getCompteEpargne(), this.somme);

			placement.setSomme(this.somme);
			placement.setClient(cl);
			placement.setPlace(place);
			placementService.addPlacementService(placement);

			this.client = clientService.getClientByIdService(cl.getIdClient());
		} else {

			this.fondInsuff = true;
		}
		session.setAttribute("client", this.client);
		session.setAttribute("fondInsuff", this.fondInsuff);

		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
	}

	public void supprimerPlacement() throws IOException {

		Client cl = clientService.getClientByIdService(this.client.getIdClient());
		compteService.depotService(cl.getCompteEpargne(), this.placementTmp.getSomme());

		placementService.deletePlacementService(this.placementTmp.getIdPlacement());

		if (placementService.getAllPlacementByIdClientService(this.client.getIdClient()).size() == 0) {
			this.client.setPlace(null);
			clientService.updateClientService(this.client);
		}

		this.client = clientService.getClientByIdService(cl.getIdClient());
		session.setAttribute("client", this.client);
		session.setAttribute("fondInsuff", false);

		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
	}

	public String retourClient() {
		session.setAttribute("client", this.client);
		return "infosClient.xhtml";
	}
	
	public String retourClientGerant() {
		session.setAttribute("client", this.client);
		return "infosClientsGerant.xhtml";
	}
}
