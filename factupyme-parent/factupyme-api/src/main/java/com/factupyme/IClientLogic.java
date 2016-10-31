/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.factupyme;

/**
 *
 * @author student
 */
public interface IClientLogic {
    public ClientDTO getClientByAccountNumber(String clientId) throws Exception;
}
