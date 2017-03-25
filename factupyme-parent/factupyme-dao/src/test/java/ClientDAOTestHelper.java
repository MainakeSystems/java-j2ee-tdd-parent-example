
import com.factupyme.ClientDTO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
public class ClientDAOTestHelper {
    private ClientDTO clientFoundWithAccountC1;
    private ClientDTO clientFoundWithAccountX9;
    private ClientDTO clientNotFound;
    
    public ClientDAOTestHelper() {
        this.clientFoundWithAccountC1 = null;
        this.clientFoundWithAccountX9 = null;
        this.clientNotFound = null;
        this.initData();
    }
    
    private void initData() {
        this.initClientFoundWithAccountC1();
        this.initClientFoundWithAccountX9();
        this.initClientNotFound();
    }
    
    private void initClientNotFound() {
        this.clientNotFound = null;
    }
    
    private void initClientFoundWithAccountC1() {
        this.clientFoundWithAccountC1 = new ClientDTO();
        this.clientFoundWithAccountC1.setId(2);
        this.clientFoundWithAccountC1.setName("Jhon");
        this.clientFoundWithAccountC1.setAccountNumber("C1");
    }
    
    private void initClientFoundWithAccountX9() {
        this.clientFoundWithAccountX9 = new ClientDTO();
        this.clientFoundWithAccountX9.setId(32);
        this.clientFoundWithAccountX9.setName("Andrew");
        this.clientFoundWithAccountX9.setAccountNumber("X9");
    }
    
    public ClientDTO getClientFoundWithAccountC1() {
        return this.clientFoundWithAccountC1;
    }
    
    public ClientDTO getClientFoundWithAccountX9() {
        return this.clientFoundWithAccountX9;
    }
    
    public ClientDTO getClientNotFound() {
        return this.clientNotFound;
    }
    
}
