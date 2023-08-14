package com.cleberleao.oficina.springboot.service;

import com.cleberleao.oficina.springboot.dto.UserDTO;
import com.cleberleao.oficina.springboot.entity.User;
import com.cleberleao.oficina.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

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
        User user = new User(dto);
        return (UserDTO) repository.save(user);
    }

    public Object apagar(Long id) {
        User user = (User) repository.findAllById(Collections.singleton(id));
        repository.delete(user);
        return user;
    }

    public Object buscarUsuario(Long id) {
        return repository.findAllById(Collections.singleton(id));
    }

    public List<User> buscarTodos() {
        return repository.findAll();
    }
}
