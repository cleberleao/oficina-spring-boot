package com.cleberleao.oficina.springboot.controller;


import com.cleberleao.oficina.springboot.dto.LoginDto;
import com.cleberleao.oficina.springboot.dto.TokenDto;
import com.cleberleao.oficina.springboot.entity.User;
import com.cleberleao.oficina.springboot.service.TokenService;
import com.cleberleao.oficina.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


/**
 * @author CleberLeão
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping({"/auth"})
public class AuthController {
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private TokenService tokenService;
	@Autowired
	private UserService service;

	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Valid LoginDto login) {
		UsernamePasswordAuthenticationToken dadosLogin = login.converter();

		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			Long id =tokenService.getIdUsuario(token);
			String roles ="ADMIN";
			return ResponseEntity.ok(new TokenDto(token, "Bearer", roles));
		} catch (AuthenticationException var5) {
			return 	ResponseEntity.status(HttpStatus.BAD_REQUEST).body(var5.toString());
		}
	}
	@PostMapping("/user")
	public ResponseEntity<?> criar(@RequestBody User dto){
		return ResponseEntity.ok().body(service.criar(dto));
	}
}
