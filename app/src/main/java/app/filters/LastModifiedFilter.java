package app.filters;

import app.utils.Config;
import app.utils.ResponseManager;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LastModifiedFilter implements Filter{
    public void init(FilterConfig arg0) throws ServletException {}
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        Long requestModified = httpRequest.getDateHeader("If-Modified-Since");
        Long lastModified = (Long) httpRequest.getSession().getAttribute(Config.LAST_MODIFIED_ATTRIBUTE);
        if (lastModified == null || requestModified == -1 || requestModified <= lastModified) {
            chain.doFilter(request, response); //sends request to next resource
        }
        else{
            ResponseManager responseManager = new ResponseManager((HttpServletResponse) response, 304);
            responseManager.send();
        }
    }
}