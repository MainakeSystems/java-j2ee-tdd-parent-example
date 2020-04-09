import com.factupyme.ClientDTO;
import com.factupyme.ClientEJB;
import com.factupyme.interfaces.IClientDAO;
import java.sql.Connection;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.lenient;
import org.mockito.junit.jupiter.MockitoExtension;


/**
 *
 * @author student
 */
@ExtendWith(MockitoExtension.class)
public class ClientEJBTest {
    
    @Mock
    private IClientDAO iClientDAO;
    
    @InjectMocks
    private ClientEJB ejb;
    
    private static ClientDAOTestHelper DAOHelper;
    
    @BeforeAll
    public static void setUpClass() {
        DAOHelper = new ClientDAOTestHelper();
    }
    
    @BeforeEach
    public void setUp() throws SQLException, Exception {
        ejb.setClientDAO(iClientDAO);
        this.initializeMocks();   
    }
    
    @Disabled
    @Test
    public void searchClientNotFound() throws Exception {
        ClientDTO clientInstance = null;
        String clientAccountExpected = null;

        clientInstance = ejb.getClientByAccountNumber(clientAccountExpected);
        
        assertTrue(clientInstance == null);
    }
    
    @Test
    public void searchClientFoundWithAccountNumberC1() throws Exception {
        ClientDTO clientInstance = null;
        String clientAccountExpected = "C1";
        
        
        clientInstance = ejb.getClientByAccountNumber(clientAccountExpected);
        
        assertTrue(clientInstance != null);
        
        assertTrue(clientInstance.getAccountNumber().equals(clientAccountExpected));
    }
    
    @Test
    public void searchClientFoundWithAccountNumberX9() throws Exception {
        ClientDTO clientInstance = null;
        String clientAccountExpected = "X9";
        
        
        clientInstance = ejb.getClientByAccountNumber(clientAccountExpected);
        
        assertTrue(clientInstance != null);
        assertTrue(clientInstance.getAccountNumber().equals(clientAccountExpected));
    }
    
    private void initializeMocks() throws Exception {
        this.initializeDAOMocks();
    }
    
    private void initializeDAOMocks() throws Exception {
         lenient().when(this.iClientDAO.getClientByAccountNumber(eq(DAOHelper.getClientFoundWithAccountC1().getAccountNumber()), 
                                                        (Connection) isNull()))
                .thenReturn(DAOHelper.getClientFoundWithAccountC1());
        
        lenient().when(this.iClientDAO.getClientByAccountNumber(eq(DAOHelper.getClientFoundWithAccountX9().getAccountNumber()),
                                                        (Connection) isNull()))
                .thenReturn(DAOHelper.getClientFoundWithAccountX9());
        
        lenient().when(this.iClientDAO.getClientByAccountNumber((String) isNull(),
                                                      (Connection) isNull()))
                .thenReturn(DAOHelper.getClientNotFound());
    }
    
}
