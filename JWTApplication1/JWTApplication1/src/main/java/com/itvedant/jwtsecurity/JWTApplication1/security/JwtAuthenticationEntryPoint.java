package com.itvedant.jwtsecurity.JWTApplication1.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint
{
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException
    {
         response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter pw = response.getWriter();
        pw.write("<h1>Access Denied !!"+ authException.getMessage()+"</h1>");
    }
}
