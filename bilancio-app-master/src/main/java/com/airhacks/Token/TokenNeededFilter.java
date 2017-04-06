/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.Token;



import java.io.IOException;
import java.util.List;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@TokenNeeded
@Provider
public class TokenNeededFilter implements ContainerRequestFilter
{
    
    @Override
    public void filter(ContainerRequestContext requestContext)throws IOException{
        outHeaders(requestContext.getHeaders());
      List<String> id_token=  requestContext.getHeaders().get("id_token");
      if(id_token==null || id_token.isEmpty()){
      requestContext.
              abortWith(Response.
                      status(Response.Status.UNAUTHORIZED).
                      build());
      }
   // System.out.println("TokenNeededFilter in action...");
    }

    private void outHeaders(MultivaluedMap<String, String> headers) {
       headers.keySet().forEach(k -> System.out.println(k + "->"+headers.get(k)));
    }   
}
