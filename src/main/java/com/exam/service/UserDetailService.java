package com.exam.service;

import com.exam.domain.admin.ExamAdmin;
import com.exam.domain.user.ExamUser;
import com.exam.domain.user.User;
import com.exam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(UserDetailService.class);

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException{
        logger.info("userId === "+userId);
        User user = userRepository.findOneById(userId);
        if(user == null){
            throw new UsernameNotFoundException("해당 유저가 없습니다.");
        }

        ExamUser examUser = new ExamUser(user, buildAdminAuthority());

        return examUser;
    }

    private Set<GrantedAuthority> buildAdminAuthority() {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        setAuths.add(new SimpleGrantedAuthority("ROLE_USER"));

        return setAuths;
    }
}
