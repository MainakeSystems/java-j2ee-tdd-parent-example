/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.factupyme.dao;

import com.factupyme.ClientDTO;
import com.factupyme.interfaces.IClientDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

/**
 *
 * @author student
 */
@Stateless(name="ClientDAO")
@Default
public class ClientDAO implements IClientDAO {

    @Override
    public ClientDTO getClientByAccountNumber(String accountNumber, Connection connectionReference) throws Exception {
        StringBuilder select = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ClientDTO clientFound = null;
        Integer auxiliaryInteger = null;
        
        try {
         select = new StringBuilder();
         
         select.append("SELECT ");
         select.append("client.id,");
         select.append("client.name, ");
         select.append("client.account_number");
         select.append(" FROM ");
         select.append(" client ");
         select.append(" WHERE ");
         select.append(" client.account_number = ?");
         
         preparedStatement = connectionReference.prepareStatement(select.toString());
         preparedStatement.setString(1, accountNumber);
         
         resultSet = preparedStatement.executeQuery();
         
         while (resultSet.next()) {
             clientFound = new ClientDTO();
             
             auxiliaryInteger = resultSet.getInt("id");
             
             if (!resultSet.wasNull()) {
                 clientFound.setId(auxiliaryInteger);
             }
             
             clientFound.setName(resultSet.getString("name"));
             clientFound.setAccountNumber(resultSet.getString("account_number"));
         }
         
         return clientFound;
            
        } catch(Exception ex) {
            throw ex;
        }
    }
    
}
