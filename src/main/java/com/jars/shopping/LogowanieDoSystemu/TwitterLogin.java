package com.jars.shopping.LogowanieDoSystemu;

import com.github.scribejava.apis.TwitterApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.Token;
import com.github.scribejava.core.oauth.OAuthService;

import javax.enterprise.inject.Produces;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import java.io.IOException;
import java.net.URI;


@WebServlet(urlPatterns = "/twitter")
public class TwitterLogin extends HttpServlet {


    public static final String consumerKey = "Tu6Y44peV4dZqhwCKzy93zHMO";
    public static final String consumerSecret = "vg6QkPwxPtjcgjQDEuyPHxqBHfSxthoPqRs6uXKttkFDyjOih8";
    private static final String PROTECTED_RESOURCE_URL = "https://api.twitter.com/1.1/account/verify_credentials.json";
    //private final AppConfig config;




    @Override
    //@Produces(MediaType.TEXT_PLAIN)
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Twitter = doGET");

        OAuthService service = createService()
                .callback("https://localhost:8080/twittercallback")
                .build();
        Token requestToken = service.getRequestToken();
        System.out.println(requestToken.toString());
        String authURL = service.getAuthorizationUrl(requestToken);
        System.out.println(authURL);

        req.setAttribute("authURL", authURL);
        System.out.println("req.setAttribute");
        //Response response = Response.seeOther(URI.create(authURL)).build();

        //response.getLocation();

        resp.sendRedirect(authURL);
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/twittercallback");
//        dispatcher.forward(req, resp);
//        System.out.println("Dispatcher forward");
    }

    private ServiceBuilder createService() {
        return new ServiceBuilder()
                .provider(TwitterApi.class)
                .apiKey(consumerKey)
                .apiSecret(consumerSecret);
    }
}
