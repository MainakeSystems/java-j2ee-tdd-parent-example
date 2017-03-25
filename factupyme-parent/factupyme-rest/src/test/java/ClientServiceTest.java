
import com.factupyme.ClientDTO;
import com.factupyme.ClientService;
import com.factupyme.IClientLogic;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.eq;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import javax.ws.rs.core.Response;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tomi
 */
@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {
    @Mock
    private IClientLogic iClientEJB;
    
    @InjectMocks
    private ClientService clientService;
    
    private static ClientEJBTestHelper serviceEJBHelper;
    
    @BeforeClass
    public static void setUpClass() {
        serviceEJBHelper = new ClientEJBTestHelper();
    }
    
    @Before
    public void setUp() throws Exception {
        clientService.setClientLogic(iClientEJB);
        this.initializeMocks();   
    }
   
    
    private void initializeMocks() throws Exception {
        this.initializeEJBMocks();
    }
    
    @Test
    public void getClientsWithAccountNumberC1() throws Exception {
        ClientDTO clientInstance = null;
        Response serviceResponse = null;
        String clientAccountExpected = "C1";
        
        
        serviceResponse = clientService.getClients(clientAccountExpected);
        
        assertTrue(serviceResponse != null);
        
        assertTrue(serviceResponse.getStatus() == 200);
        
        assertTrue(serviceResponse.getEntity() != null);
        
        clientInstance = (ClientDTO) serviceResponse.getEntity();
        
        assertTrue(clientInstance.getAccountNumber().equals(clientAccountExpected));
    }
    
     private void initializeEJBMocks() throws Exception {
        when(this.iClientEJB.getClientByAccountNumber(eq(serviceEJBHelper.getIdAccountC1())))
                .thenReturn(serviceEJBHelper.getClientFoundWithAccountC1());
    }
}
