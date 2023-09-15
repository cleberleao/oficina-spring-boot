package com.cleberleao.oficina.springboot.dto;

import lombok.*;
/**
 * @author CleberLeão
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Token {
    private String token;
    private String tipo;
    private String roles;
}
