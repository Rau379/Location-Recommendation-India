package com.tvsmotor.Authservice.Filter;

import com.tvsmotor.Authservice.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.ExpiredJwtException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

	   @Autowired
	    private JwtUtil jwtUtil;

	    @Override
	    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	            throws ServletException, IOException {

	        String authorizationHeader = request.getHeader("Authorization");

	        String token = null;
	        String username = null;

	        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
	            token = authorizationHeader.substring(7);
	            username = jwtUtil.extractUsername(token);  // Implement this method in JwtUtil to extract username from token
	        }

	        // Add additional validation logic for the token here if needed

	        filterChain.doFilter(request, response);
	    }
}
