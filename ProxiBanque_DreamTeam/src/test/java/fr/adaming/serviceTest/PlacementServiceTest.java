//package fr.adaming.serviceTest;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import fr.adaming.model.Client;
//import fr.adaming.model.Place;
//import fr.adaming.model.Placement;
//import fr.adaming.service.IClientService;
//import fr.adaming.service.IPlaceService;
//import fr.adaming.service.IPlacementService;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/application-context.xml")
//public class PlacementServiceTest {
//
//	
//	@Autowired
//	private IClientService clientService;
//	
//	@Autowired
//	private IPlacementService placementService;
//	
//	@Autowired
//	private IPlaceService placeService;
//	
//	@Test
//	public void testNouveauPlacement(){
//		
//		Client cl = clientService.getClientByIdService(1);
//		Place place = placeService.getPlaceByIdService(1);
//		cl.setPlace(place);
//		clientService.updateClientService(cl);
//		
//		Placement placement = new Placement();
//		
//		placement.setSomme(100000);
//		placement.setClient(cl);
//		placement.setPlace(place);
//		
//		placementService.addPlacementService(placement);
//	}
//}
