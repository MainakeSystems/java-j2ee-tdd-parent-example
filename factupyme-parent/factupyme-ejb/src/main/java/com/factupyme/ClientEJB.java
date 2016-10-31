/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factupyme;

import com.factupyme.interfaces.IClientDAO;
import java.sql.Connection;
import javax.ejb.Stateless;
import javax.inject.Inject;


@Stateless(name="ClientEJB")
public class ClientEJB implements IClientLogic {

    //@Inject
    private IClientDAO clientDAO;


    @Override
    public ClientDTO getClientByAccountNumber(String accountNumber) throws Exception {
        Connection connection = null;
        ClientDTO clientFound = null;
        
        try {
            connection = ConnectionDB.getConnection(ConnectionDBConstants.POOL_CONTEXT,
                                                    ConnectionDBConstants.POOL_NAME);
            
            
            clientFound = this.clientDAO.getClientByAccountNumber(accountNumber, connection);
            
            return clientFound;

        } catch(Exception ex) {
            throw ex;
        }
    }
    
    /**
     *
     * @param clientDAOInyection
     */
    @Inject
    public void setClientDAO(IClientDAO clientDAOInyection) {
        this.clientDAO = clientDAOInyection;
    }

}
