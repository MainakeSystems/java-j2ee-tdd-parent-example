
import com.factupyme.ClientDTO;
import com.factupyme.dao.ClientDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.InjectMocks;

import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
@ExtendWith(MockitoExtension.class)
public class ClientDAOTest {
    
    @Mock
    private Connection connection;
    
    @Mock
    private ResultSet resultSet;
    
    @Mock
    private PreparedStatement preparedStatement;
    
    @InjectMocks
    private ClientDAO clientDAO;
    
    private static ClientDAOTestHelper DAOHelper;
    
    @BeforeAll
    public static void setUpClass() {
        DAOHelper = new ClientDAOTestHelper();
    }
    
    @BeforeEach
    public void setUp() throws SQLException, Exception {
        //clientDAO.setClientDAO(connection);
        this.initializeMocks();   
    }
   
    
    @Test
    public void searchClientFoundWithAccountNumberC1() throws Exception {
        ClientDTO clientInstance = null;
        String clientAccountExpected = "C1";
                
        
        clientInstance = clientDAO.getClientByAccountNumber(clientAccountExpected, this.connection);
        
        assertTrue(clientInstance != null);
        
        assertTrue(clientInstance.getAccountNumber().equals(clientAccountExpected));
    }
    
    
    private void initializeMocks() throws Exception {
        this.initializeDAOMocks();
    }
    
    private void initializeDAOMocks() throws Exception {
        StringBuilder select = null;
         select = new StringBuilder();
         
         select.append("SELECT ");
         select.append("client.id,");
         select.append("client.name, ");
         select.append("client.account_number");
         select.append(" FROM ");
         select.append(" client ");
         select.append(" WHERE ");
         select.append(" client.account_number = ?");
         
         
         /** Mocking the preparedStament
          */
        when(this.connection.prepareStatement(eq(select.toString())))
                .thenReturn(this.preparedStatement);
        
        /** Mocking the executionQuery
         */
        when(this.preparedStatement.executeQuery())
                .thenReturn(this.resultSet);
        
        /** Mocking the resultSet Iterator
         */
        when(this.resultSet.next())
                .thenReturn(true)
                    .thenReturn(false);
        
        /** Mocking the resultSet parameters
         */
        when(this.resultSet.getString("name"))
                .thenReturn(DAOHelper.getClientFoundWithAccountC1().getName());
        
        when(this.resultSet.getInt("id"))
                .thenReturn(DAOHelper.getClientFoundWithAccountC1().getId());
        
        when(this.resultSet.getString("account_number"))
                .thenReturn(DAOHelper.getClientFoundWithAccountC1().getAccountNumber());
    }
    
}
