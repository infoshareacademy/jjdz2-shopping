package com.jars.shopping.LogowanieDoSystemu;

import com.github.scribejava.apis.FacebookApi;
import com.github.scribejava.apis.TwitterApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.*;
import com.github.scribejava.core.oauth.OAuthService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jars.shopping.LogowanieDoSystemu.SessionData.SessionData;
import com.jars.shopping.LogowanieDoSystemu.SessionData.UserDao;
import com.jars.shopping.Users.User;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import static com.jars.shopping.LogowanieDoSystemu.FacebookLogin.FACEBOOKLOGGER;
import static com.jars.shopping.LogowanieDoSystemu.FacebookLogin.FACEBOOKLOGIN;


@WebServlet(urlPatterns = "/facebookcallback")
public class FacebookCallback extends HttpServlet{

    @Inject
    UserDao userDao;

    @Inject
    SessionData sessionData;

    private String code;

    /*
    * This requires rerouting port 80 to 8080 for detail on how to quickly do that, call me :) kkubicki2@gmail.com
    *
    * */


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        OAuthService service = new ServiceBuilder()
                .provider(FacebookApi.class)
                .apiKey("693169580831907")
                .apiSecret("33429cb2d1c1fd80842cd1679925d8be")
                .callback("http://localhost/facebookcallback")
                .build();
        Enumeration<String> parameterNames = req.getParameterNames();

        if (parameterNames.hasMoreElements()) {
            System.out.println(parameterNames.nextElement());
            code = req.getParameter("code");
        }
        else try {
            throw new IllegalAccessException("Brak kodu do verifier'a :( ");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            FACEBOOKLOGGER.error(FACEBOOKLOGIN," Brak kodu do verifiera!");
        }
        Verifier verifier = new Verifier(code);

        Token accessToken = service.getAccessToken(FacebookLogin.EMPTY_TOKEN, verifier);
        OAuthRequest request = new OAuthRequest(Verb.GET, FacebookLogin.PROTECTED_RESOURCE_URL, service);
        service.signRequest(accessToken, request);
        Response response = request.send();
        String jsonid = response.getBody();
        JsonObject jobj = new Gson().fromJson(jsonid, JsonObject.class);
        String name = jobj.get("name").getAsString();
        FACEBOOKLOGGER.info(FACEBOOKLOGIN," User logged and his/her user name "+name);
        userDao.saveUserInDataBase(new User(name));


        sessionData.setLogged(true);
        sessionData.setName(name);
        sessionData.setLoggedFrom("Facebook");
        req.setAttribute("name", name);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/facebookcallback.jsp");
        dispatcher.forward(req, resp);
    }
}
