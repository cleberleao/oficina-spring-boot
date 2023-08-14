package com.cleberleao.oficina.springboot.dto;

import com.cleberleao.oficina.springboot.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO extends User {

    private Long id;

    private String nome;

}
