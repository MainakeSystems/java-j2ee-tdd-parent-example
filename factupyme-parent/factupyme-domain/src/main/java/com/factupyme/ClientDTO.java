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
public class ClientDTO {
    private String name;
    private Integer id;
    private String accountNumber;
    
    public ClientDTO() {
        this.name = null;
        this.id = null;
        this.accountNumber = null;
    }
    
    public void setName(String clientName) {
        this.name = clientName;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setId(Integer clientId) {
        this.id = clientId;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public String getAccountNumber() {
        return this.accountNumber;
    }
    
    public void setAccountNumber(String account) {
        this.accountNumber = account;
    }
    
}
