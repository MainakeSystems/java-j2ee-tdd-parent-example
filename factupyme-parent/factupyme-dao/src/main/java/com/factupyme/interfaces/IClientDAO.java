/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.factupyme.interfaces;

import com.factupyme.ClientDTO;
import java.sql.Connection;

/**
 *
 * @author student
 */
public interface IClientDAO {
    ClientDTO getClientByAccountNumber(String accountNumber, Connection connectionReference) throws Exception;
}
