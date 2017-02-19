package com.jars.shopping.REST;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

/**
 * Created by marcinpankowski on 04.02.17.
 */
@Stateless
public class ClientForAPI {

    public List<UserData> getDataFromAPI(LocalDate fromDate, LocalDate toDate) throws MalformedURLException, URISyntaxException {
        //LocalDate date = LocalDate.now();
        ZoneId zoneId = ZoneId.systemDefault();
        long epochFromDate = fromDate.atStartOfDay(zoneId).toEpochSecond();
        long epochToDate = toDate.atStartOfDay(zoneId).toEpochSecond();

        // URL url = new URL("localhost:8081");
        URL url = new URL("http://10.58.78.70:8080");

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
