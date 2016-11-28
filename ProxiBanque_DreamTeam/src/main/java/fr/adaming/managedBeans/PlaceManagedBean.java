/**
 * 
 */
package fr.adaming.managedBeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Client;
import fr.adaming.service.IPlaceService;

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
	@ManagedProperty(value = "#{cmpServiceBean}")
	IPlaceService placeService;

	private int place = 0;
	private int somme = 0;
	private Client client;

	HttpSession session;

	/**
	 * 
	 */
	public PlaceManagedBean() {
		super();
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

	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		session = (HttpSession) facesContext.getExternalContext().getSession(false);

		this.client = (Client) session.getAttribute("client");
	}
}
