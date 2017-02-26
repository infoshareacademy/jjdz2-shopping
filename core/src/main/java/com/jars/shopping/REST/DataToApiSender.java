package com.jars.shopping.REST;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by marcinpankowski on 04.02.17.
 */
@Stateless
public class DataToApiSender {

    public void postNewUser(@Observes UserData event) throws MalformedURLException, URISyntaxException {

        URL url = new URL("localhost:8081");
        //URL url = new URL("http://10.58.78.96:8081");

        Client client = ClientBuilder.newClient();

        JsonObject jsonObject = Json.createObjectBuilder()
                .add("username", event.getUsername())
                .add("date", event.getDate())
                .build();

        Response response = client.target(url.toURI())
                .path("api")
                .path("logins")
                .request()
                .post(Entity.json(jsonObject.toString()));

    }
}