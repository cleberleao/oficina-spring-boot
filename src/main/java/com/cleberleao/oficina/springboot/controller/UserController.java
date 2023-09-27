package com.cleberleao.oficina.springboot.controller;

import com.cleberleao.oficina.springboot.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.cleberleao.oficina.springboot.service.UserService;
/**
 * @author CleberLeão
 */
@RestController
@RequestMapping(value = "user")
@CrossOrigin(value = "*")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody UserDto dto){
        return ResponseEntity.ok().body(service.criar(dto));
    }

    @PutMapping
    public ResponseEntity<?> alterar(@RequestBody UserDto dto){
        return ResponseEntity.ok().body(service.alterar(dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> apagar(@PathVariable Long id){
        return ResponseEntity.ok().body(service.apagar((id)));
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> buscarUsuario(@PathVariable Long id){
        return ResponseEntity.ok().body(service.buscarUsuario(id));
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> buscarTodos(){
            return ResponseEntity.ok().body(service.buscarTodos());
    }

}
