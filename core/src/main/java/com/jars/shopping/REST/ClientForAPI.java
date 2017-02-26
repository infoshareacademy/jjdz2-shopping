package com.jars.shopping.REST;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

/**
 * Created by marcinpankowski on 04.02.17.
 */
@Stateless
public class ClientForAPI {

    public List<UserData> getDataFromAPI(long epochFromDate, long epochToDate) throws MalformedURLException, URISyntaxException {

        URL url = new URL("localhost:8081");
        //URL url = new URL("http://10.58.78.96:8081");

        Client client = ClientBuilder.newClient();


        List<UserData> userDatas = client.target(url.toURI())
                .path("api")
                .path("logins")
                .queryParam("fromdate", epochFromDate)
                .queryParam("todate", epochToDate)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<UserData>>() {
                });

        System.out.println(">> " + userDatas);

        return userDatas;
    }


}
