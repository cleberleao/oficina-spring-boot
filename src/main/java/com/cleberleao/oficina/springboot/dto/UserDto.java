package com.cleberleao.oficina.springboot.dto;

import com.cleberleao.oficina.springboot.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/**
 * @author CleberLeão
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends User {

    private Long id;

    private String nome;

    private String email;

    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || HibernateProxy.class.isAssignableFrom(o.getClass())) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id);
    }

}
