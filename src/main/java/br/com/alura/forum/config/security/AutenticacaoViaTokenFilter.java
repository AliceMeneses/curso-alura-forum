package br.com.alura.forum.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = recuperarToken(request);
		
		System.out.println(token);
		
		filterChain.doFilter(request, response);
	}

	private String recuperarToken(HttpServletRequest request) {

		String authorization = request.getHeader("Authorization");
		
		if(authorization == null || authorization.isEmpty() || !authorization.startsWith("Bearer ")) {
			return null;
		}
		
		return authorization.substring(7, authorization.length());
	}
	
}