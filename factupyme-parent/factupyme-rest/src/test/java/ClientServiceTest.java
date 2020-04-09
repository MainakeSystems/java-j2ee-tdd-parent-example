
import com.factupyme.ClientDTO;
import com.factupyme.ClientService;
import com.factupyme.IClientLogic;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import javax.ws.rs.core.Response;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author student
 */
@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {
    @Mock
    private IClientLogic iClientEJB;
    
    @InjectMocks
    private ClientService clientService;
    
    private static ClientEJBTestHelper serviceEJBHelper;
    
    @BeforeAll
    public static void setUpClass() {
        serviceEJBHelper = new ClientEJBTestHelper();
    }
    
    @BeforeEach
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
