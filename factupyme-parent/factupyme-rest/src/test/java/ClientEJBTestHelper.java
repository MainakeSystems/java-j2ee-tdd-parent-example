
import com.factupyme.ClientDTO;

/**
 *
 * @author tomi
 */
public class ClientEJBTestHelper {
    private String idAccountC1;
    private ClientDTO clientFoundWithAccountC1;
    
    public ClientEJBTestHelper() {
        this.idAccountC1 = null;
        this.initData();
    }
    
    private void initData() {
        this.initAccountC1();
        initClientFoundWithAccountC1();
    }
    
    private void initClientFoundWithAccountC1() {
        this.clientFoundWithAccountC1 = new ClientDTO();
        this.clientFoundWithAccountC1.setId(2);
        this.clientFoundWithAccountC1.setName("Jhon");
        this.clientFoundWithAccountC1.setAccountNumber("C1");
    }
    
    private void initAccountC1() {
        this.idAccountC1 = "C1";
    }
    
    public String getIdAccountC1() {
        return this.idAccountC1;
    }
    
    public ClientDTO getClientFoundWithAccountC1() {
        return this.clientFoundWithAccountC1;
    }
}
