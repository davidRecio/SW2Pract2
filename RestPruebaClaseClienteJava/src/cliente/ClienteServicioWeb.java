/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:RestService [servicio]<br>
 * USAGE:
 * <pre>
 *        ClienteServicioWeb client = new ClienteServicioWeb();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author darth
 */
public class ClienteServicioWeb {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/RESTPRUEBACLASE/webresources";

    public ClienteServicioWeb() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("servicio");
    }

    public ClienteServicioWeb(String username, String password) {
        this();
        setUsernamePassword(username, password);
    }

    public void helloSir(Object requestEntity) throws ClientErrorException {
        webTarget.path("post").request(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.TEXT_PLAIN));
    }

    public String hello() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public void putXml(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void close() {
        client.close();
    }

    public final void setUsernamePassword(String username, String password) {
        webTarget.register(new org.glassfish.jersey.client.filter.HttpBasicAuthFilter(username, password));
    }
    
}
