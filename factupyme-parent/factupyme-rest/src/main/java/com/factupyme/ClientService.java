/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.factupyme;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author student
 */
@Stateless(name="ClientService")
@Path("/")
public class ClientService {
    
    private IClientLogic clientLogic;
    
    @Inject
    public void setClientLogic(IClientLogic clientBusinnessLogic) {
        this.clientLogic = clientBusinnessLogic;
    }
        
    @GET
    @PermitAll
    @Path(ClientServicesName.GET_CLIENTS_SERVICE)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClients(@QueryParam("account_number") String accountNumber) {
        ClientDTO clientFound = null;
        Response httpResponse = null;
        
        try {
            clientFound = null;
            clientFound = this.clientLogic.getClientByAccountNumber(accountNumber);
            
            if (clientFound == null) {
                httpResponse = Response.status(Response.Status.NOT_FOUND).entity("NOT FOUND!").build();
            } else {
                httpResponse = Response.status(Response.Status.OK).entity(clientFound).build();
            }
            
        } catch(Exception ex) {
            httpResponse = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        
        return httpResponse;
    }
}
