package org.ebi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CorsFilter extends OncePerRequestFilter {

    @Value("${uiConfig.frontendUrl}")
    private String frontendUrl;
    @Value("${uiConfig.enableCors}")
    private boolean enableCors;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {
        if (enableCors)
        {
            response.setHeader("Access-Control-Allow-Origin", frontendUrl);
            response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "Authorization, content-type");
            response.addHeader("Access-Control-Expose-Headers", "Authorization, content-type");

            if ("OPTIONS".equals(request.getMethod()))
                response.setStatus(HttpServletResponse.SC_OK);
            else
            {
                filterChain.doFilter(request, response);
            }
        }
    }

}
