/*
package com.jars.shopping.LogowanieDoSystemu.Google;

import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.gson.Gson;

import javax.ejb.Stateless;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

*/
/**
 * Created by keehoo on 01.11.16.
 *//*


@Stateless
public class Signin {

    private static final HttpTransport TRANSPORT = new NetHttpTransport();
    private static final JacksonFactory JSON_FACTORY = new JacksonFactory();
    private static final Gson GSON = new Gson();
    private static GoogleClientSecrets clientSecrets;
    static {
        try {
            Reader reader = new FileReader("client_secrets.json");
            clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, reader);
        } catch (IOException e) {
            throw new Error("No client_secrets.json found", e);
        }
    }

    private static final String CLIENT_ID = clientSecrets.getWeb().getClientId();
    private static final String CLIENT_SECRET = clientSecrets.getWeb().getClientSecret();
    private static final String APPLICATION_NAME = "Google+ Java Quickstart";


    public static void connect() throws Exception {

    }
*/
