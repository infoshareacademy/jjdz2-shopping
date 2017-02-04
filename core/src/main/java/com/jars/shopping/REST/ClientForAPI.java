package com.jars.shopping.REST;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 * Created by marcinpankowski on 04.02.17.
 */
public class ClientForAPI {

        public void getDataFromAPI(LocalDate fromDate, LocalDate toDate) throws MalformedURLException, URISyntaxException {
            //LocalDate date = LocalDate.now();
            ZoneId zoneId = ZoneId.systemDefault();
            long epochFromDate = fromDate.atStartOfDay(zoneId).toEpochSecond();
            long epochToDate = toDate.atStartOfDay(zoneId).toEpochSecond();

            URL url = new URL("localhost:8081");

            Client client = ClientBuilder.newClient();

            Response response = client.target(url.toURI())
                    .path("api")
                    .path("logins")
                    .queryParam("fromdate",epochFromDate)
                    .queryParam("todate",epochToDate)
                    .request()
                    .get();

            System.out.println("response = " + response.readEntity(String.class));

        }


}
