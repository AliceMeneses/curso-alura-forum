package br.com.alura.forum.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.alura.forum.modelo.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${forum.jwt.expiration}")
	private String expiration;
	
	@Value("${forum.jwt.secret}")
	private String secret;

	public String gerarToken(Authentication autenticacao) {
		
		Usuario usuarioLogado = (Usuario) autenticacao.getPrincipal();
		
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
		
		return Jwts.builder()
					.setIssuer("API do Fórum da Alura")
					.setIssuedAt(hoje)
					.setSubject(usuarioLogado.getId().toString())
					.setExpiration(dataExpiracao)
					.signWith(SignatureAlgorithm.HS256, secret)
					.compact();
	}
	
	public Boolean isTokenValido(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
			
		} catch(Exception ex) {
			return false;
		}
	}

	public Long getIdUsuario(String token) {
		 Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		 
		 return Long.parseLong(claims.getSubject());
	}
}
