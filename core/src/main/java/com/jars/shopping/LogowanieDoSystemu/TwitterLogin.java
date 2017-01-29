package com.jars.shopping.LogowanieDoSystemu;

import com.github.scribejava.apis.TwitterApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.Token;
import com.github.scribejava.core.oauth.OAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

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

    public static final Logger TWITTERLOGGER = LoggerFactory.getLogger(TwitterLogin.class);
    public static final Marker TWITTERLOGIN = MarkerFactory.getMarker("TWITTER_LOGIN");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        OAuthService service = createService()
                .callback("http://localhost:8080/twittercallback")
                .build();
        Token requestToken = service.getRequestToken();
        TWITTERLOGGER.info(TWITTERLOGIN," Request token create to be sent to Twitter for Authentication");
        String authURL = service.getAuthorizationUrl(requestToken);
        req.setAttribute("authURL", authURL);
        resp.sendRedirect(authURL);
    }

    private ServiceBuilder createService() {
        return new ServiceBuilder()
                .provider(TwitterApi.class)
                .apiKey(consumerKey)
                .apiSecret(consumerSecret);
    }
}
