/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicioRest;

import javax.inject.Singleton;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author david
 */
@Singleton
@Path("servicio")//es la direc del servicio
public class RestService {

    @Context
    private UriInfo context;
    private String message="_";
    /**
     * Creates a new instance of RestService
     */
    public RestService() {
    }

    /**
     * Retrieves representation of an instance of servicioRest.RestService
     * @return an instance of java.lang.String
     */
//    @GET
//    @Produces("application/xml")
//    public String getXml() {
//        //TODO return proper representation object
//        throw new UnsupportedOperationException();
//    }
    
    @GET    
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(){
    return "Hello "+ message;
    }
    
     @Path("post")
    @POST   
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public void helloSir(String sir){
        message=sir;
    String respuesta="Hello Sir "+sir+" is connected";
    System.out.println(respuesta);
    }

    /**
     * PUT method for updating or creating an instance of RestService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
