package com.cleberleao.oficina.springboot.service;

import com.cleberleao.oficina.springboot.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;
/**
 * @author CleberLeão
 */
@Service
public class TokenService {
	@Value("${jwt.expiration}")
	private String expiration;
	@Value("${jwt.secret}")
	private String secret;

	public TokenService() {
	}

	public String gerarToken(Authentication authentication) {
		User logado = (User)authentication.getPrincipal();
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(this.expiration));
		return Jwts.builder()
				.setIssuer("API Oficina Java")
				.setSubject(logado.getId().toString())
				.setIssuedAt(hoje).setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, this.secret)
				.compact();
	}

	public boolean tokenEhValido(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Long getIdUsuario(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
	}
}