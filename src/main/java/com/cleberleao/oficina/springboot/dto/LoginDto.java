package com.cleberleao.oficina.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
/**
 * @author CleberLeão
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    private String email;
    private String password;

    public UsernamePasswordAuthenticationToken converter() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}
