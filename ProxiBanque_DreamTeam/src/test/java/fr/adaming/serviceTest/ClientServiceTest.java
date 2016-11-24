/**
 * 
 */
package fr.adaming.serviceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.service.IClientService;

/**
 * @author inti0302
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/application-context.xml")
public class ClientServiceTest {

	@Autowired
	private IClientService clientService;
	
	@Test
	public void testAjouterClient(){
		
	}
	
}
