package com.cleberleao.oficina.springboot.service;

import com.cleberleao.oficina.springboot.config.security.SecurityConfigurations;
import com.cleberleao.oficina.springboot.entity.User;
import com.cleberleao.oficina.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * @author CleberLeão
 */
@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private SecurityConfigurations securityConfig;
    public User criar(User dto) {
        dto.setPassword((new BCryptPasswordEncoder()).encode(dto.getPassword()));;
        return repository.save(dto);
    }

    public User alterar(User dto) {
        return repository.save(dto);
    }

    public User apagar(Long id) {
        Optional<User> user2 = repository.findById(id);
        repository.delete(user2.get());
        return user2.get();
    }

    public User buscarUsuario(Long id) {
        return repository.findById(id).get();
    }

    public List<User> buscarTodos() {
        return repository.findAll();
    }
}
