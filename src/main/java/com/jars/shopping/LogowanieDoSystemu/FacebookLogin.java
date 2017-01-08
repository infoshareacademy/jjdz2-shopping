package com.jars.shopping.LogowanieDoSystemu;

import com.github.scribejava.apis.FacebookApi;

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
import java.io.IOException;


@WebServlet(urlPatterns = "/facebook")
public class FacebookLogin extends HttpServlet {

    protected static final String NETWORK_NAME = "Facebook";
    protected static final String PROTECTED_RESOURCE_URL = "https://graph.facebook.com/me";
    protected static final Token EMPTY_TOKEN = null;
    public static final Logger FACEBOOKLOGGER = LoggerFactory.getLogger(FacebookLogin.class);
    public static final Marker FACEBOOKLOGIN = MarkerFactory.getMarker("FACEBOOK_LOGIN");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        OAuthService service = new ServiceBuilder()
                .provider(FacebookApi.class)
                .apiKey("693169580831907")
                .apiSecret("33429cb2d1c1fd80842cd1679925d8be")
                .callback("http://localhost/facebookcallback")
                .build();

        String authorizationUrl = service.getAuthorizationUrl(EMPTY_TOKEN);
        System.out.println("Authorization URL : "+authorizationUrl);
        FACEBOOKLOGGER.info(FACEBOOKLOGIN," Request token sent to Facebook");
        resp.sendRedirect(authorizationUrl);
    }
}
