package com.cleberleao.oficina.springboot.dto;

import lombok.*;
/**
 * @author CleberLeão
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenDto {
    private String token;
    private String tipo;
    private String roles;
}
