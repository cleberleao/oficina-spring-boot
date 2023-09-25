package com.cleberleao.oficina.springboot.config.security;

import com.cleberleao.oficina.springboot.model.User;
import com.cleberleao.oficina.springboot.repository.UserRepository;
import com.cleberleao.oficina.springboot.service.TokenService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author CleberLeão
 */
@NoArgsConstructor
@AllArgsConstructor
public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {
	@Autowired
	private TokenService tokenService;
	@Autowired
	private UserRepository repository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String token = this.recuperarToken(request);
		boolean valido = this.tokenService.tokenEhValido(token);
		if (valido) {
			this.autenticarCliente(token);
		}

		filterChain.doFilter(request, response);
	}

	private void autenticarCliente(String token) {
		Long idUsuario = this.tokenService.getIdUsuario(token);
		User user = this.repository.findById(idUsuario).get();
		Collection<? extends GrantedAuthority> perfil = new ArrayList<>();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, (Object)null, perfil);
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		return token != null && !token.isEmpty() && token.startsWith("Bearer ") ? token.substring(7, token.length()) : null;
	}
}