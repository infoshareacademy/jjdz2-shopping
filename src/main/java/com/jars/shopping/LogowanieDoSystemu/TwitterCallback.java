package com.jars.shopping.LogowanieDoSystemu;

import com.github.scribejava.apis.TwitterApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.*;
import com.github.scribejava.core.oauth.OAuthService;
import com.google.gson.Gson;
import com.jars.shopping.LogowanieDoSystemu.SessionData.UserDao;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.jars.shopping.LogowanieDoSystemu.TwitterLogin.consumerKey;
import static com.jars.shopping.LogowanieDoSystemu.TwitterLogin.consumerSecret;

@WebServlet(urlPatterns = "/twittercallback")
public class TwitterCallback extends HttpServlet {



    private static final String PROTECTED_RESOURCE_URL = "https://api.twitter.com/1.1/account/verify_credentials.json";

    private ServiceBuilder createService() {
        return new ServiceBuilder()
                .provider(TwitterApi.class)
                .apiKey(consumerKey)
                .apiSecret(consumerSecret);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Twitter call back");
        System.out.println(req.getAuthType());
        System.out.println("acces token: "+req.getParameter("oauth_token"));
        System.out.println("Verifier "+req.getParameter("oauth_verifier"));
        OAuthService service = createService().build();
        Token requestToken = new Token(req.getParameter("oauth_token"), req.getParameter("oauth_verifier"));
        Verifier verifier = new Verifier(req.getParameter("oauth_verifier"));
        Token accessToken = service.getAccessToken(requestToken, verifier);
        OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL, service);
        service.signRequest(accessToken, request);
        final OAuthRequest request1 = new OAuthRequest(Verb.GET, "https://api.twitter.com/1.1/account/verify_credentials.json", service);
        service.signRequest(accessToken, request1); // the access token from step 4
        final Response response = request1.send();
        System.out.println(response.getBody());

    }
}
