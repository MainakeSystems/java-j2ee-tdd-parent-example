
import com.factupyme.ClientDTO;
import com.factupyme.ClientEJB;
import com.factupyme.interfaces.IClientDAO;
import java.sql.Connection;
import java.sql.SQLException;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isNull;
import static org.mockito.Matchers.isNull;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
@RunWith(MockitoJUnitRunner.class)
public class ClientEJBTest {
    
    @Mock
    private IClientDAO iClientDAO;
    
    @InjectMocks
    private ClientEJB ejb;
    
    private static ClientDAOTestHelper DAOHelper;
    
    @BeforeClass
    public static void setUpClass() {
        DAOHelper = new ClientDAOTestHelper();
    }
    
    @Before
    public void setUp() throws SQLException, Exception {
        ejb.setClientDAO(iClientDAO);
        this.initializeMocks();   
    }
    
    @Ignore
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
        when(this.iClientDAO.getClientByAccountNumber(eq(DAOHelper.getClientFoundWithAccountC1().getAccountNumber()),
                                                        any(Connection.class)))
                .thenReturn(DAOHelper.getClientFoundWithAccountC1());
        
        when(this.iClientDAO.getClientByAccountNumber(eq(DAOHelper.getClientFoundWithAccountX9().getAccountNumber()),
                                                        any(Connection.class)))
                .thenReturn(DAOHelper.getClientFoundWithAccountX9());
        
        when(this.iClientDAO.getClientByAccountNumber(isNull(String.class),
                                                      any(Connection.class)))
                .thenReturn(DAOHelper.getClientNotFound());         
    }
    
}
