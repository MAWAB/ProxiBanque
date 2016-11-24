//package fr.adaming.model;
//
//import java.io.Serializable;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="roles")
//public class Role implements Serializable {
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private int id_role;
//	
//	private String roleName;
//	
	
	/* il faut attribuer un id pour deux types objets differents
	 * proposition de solution non exhaustive à réaliser lors de la mise en place de spring sécurity
	 * - mettre un rôle à l'entité Personne
	 * - créer une collection d'objet non définit (List<Object>)
	 * */
//	@ManyToOne
//	@JoinColumn(name="id_gestionnaire", referencedColumnName="id_gestionnaire")
//	// private Conseiller gestionnaire;
//	
//	
//
//	
//	
//}
