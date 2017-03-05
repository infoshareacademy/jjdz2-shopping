package com.jars.shopping.REST;

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
public class DataToApiSenderTest {

    public void shouldPostDataUser() throws URISyntaxException, MalformedURLException {
        URL url = new URL("http://10.58.78.70:8080");
        //URL url = new URL("localhost:8081");
        long number = 123;
        Client client = ClientBuilder.newClient();

        JsonObject jsonObject = Json.createObjectBuilder()
                .add("username", "Pankowski")
                .add("date", number)
                .build();
        Response response = client.target(url.toURI())
                .path("api")
                .path("logins")
                .request()
                .post(Entity.json(jsonObject.toString()));


        System.out.println("response = " + response.readEntity(String.class));
    }


}