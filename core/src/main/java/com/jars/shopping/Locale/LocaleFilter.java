package com.jars.shopping.Locale;


        import com.jars.shopping.LogowanieDoSystemu.SessionData.SessionData;

        import javax.inject.Inject;
        import javax.servlet.*;
        import javax.servlet.annotation.WebFilter;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import javax.servlet.jsp.jstl.core.Config;
        import java.io.IOException;
        import java.util.Locale;

@WebFilter(urlPatterns = { "/*"})
public class LocaleFilter implements Filter {

    @Inject
    SessionData sessionData;

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String locale = request.getParameter("locale");

        if (locale != null && !locale.isEmpty()) {
            sessionData.setLocale(new Locale(locale));
        }

        if (sessionData.getLocale() != null) {
            Config.set(servletRequest, Config.FMT_LOCALE, sessionData.getLocale());
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}