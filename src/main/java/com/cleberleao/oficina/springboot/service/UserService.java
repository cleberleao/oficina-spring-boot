package com.cleberleao.oficina.springboot.service;

import com.cleberleao.oficina.springboot.dto.UserDTO;
import com.cleberleao.oficina.springboot.entity.User;
import com.cleberleao.oficina.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    public Object criar(UserDTO dto) {
        User user = new User();
        user.setNome(dto.getNome());
        return repository.save(user);
    }


    public Object alterar(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setNome(dto.getNome());
        return repository.save(user);
    }

    public Object apagar(Long id) {
        List<User> user = repository.findAllById(Collections.singleton(id));
        repository.deleteAll(user);
        return user;
    }

    public Object buscarUsuario(Long id) {
        return repository.findAllById(Collections.singleton(id));
    }

    public List<User> buscarTodos() {
        return repository.findAll();
    }
}
