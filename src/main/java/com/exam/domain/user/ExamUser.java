package com.exam.domain.user;

import com.exam.domain.admin.Admin;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
public class ExamUser extends User {
    String id;
    String name;

    public ExamUser(com.exam.domain.user.User user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getId(), user.getPassword(), authorities);
        this.id = user.getId();
        this.name = user.getName();
    }
}
