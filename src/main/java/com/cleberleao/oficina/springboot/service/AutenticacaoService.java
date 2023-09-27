package com.cleberleao.oficina.springboot.service;

import com.cleberleao.oficina.springboot.entity.User;
import com.cleberleao.oficina.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author CleberLeão
 */
@Service
public class AutenticacaoService implements UserDetailsService {
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User usuario = repository.findByEmail(email);
		if (usuario.getEmail().equals(email)) {
			return (UserDetails) usuario;
		}
			throw new UsernameNotFoundException("Dados de usuário e senha são inválidos!");
	}
}
