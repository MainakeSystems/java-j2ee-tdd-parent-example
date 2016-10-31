/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.factupyme.security;


import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
public class CorsResponseInterceptor implements ContainerResponseFilter {

    	private static final String ACCESS_CONTROL_REQUEST_HEADERS = "Access-Control-Request-Headers";
        private static final String ACCESS_CONTROL_REQUEST_METHOD = "Access-Control-Request-Method";
        private static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
        private static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
        private static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
        private static final String ACCESS_CONTROL_ALLOW_ORIGIN_ANYONE = "*"; 

    @Override
    public void filter(final ContainerRequestContext requestCtx, 
                       final ContainerResponseContext responseCtx) throws IOException {
        
        
         String requestHeaders = requestCtx.getHeaderString(ACCESS_CONTROL_REQUEST_HEADERS);
         String requestMethods = requestCtx.getHeaderString(ACCESS_CONTROL_REQUEST_METHOD); 
        
        if (requestHeaders != null)
          responseCtx.getHeaders().add(ACCESS_CONTROL_ALLOW_HEADERS, requestHeaders);

        if (requestMethods != null)
            responseCtx.getHeaders().add(ACCESS_CONTROL_ALLOW_METHODS, requestMethods);

        // TODO: development only, too permissive 
        responseCtx.getHeaders().add(ACCESS_CONTROL_ALLOW_ORIGIN, "http://machine2:2514");
        
    }

}
