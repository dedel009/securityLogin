package com.exam.service;

import com.exam.controller.MainController;
import com.exam.domain.Admin;
import com.exam.domain.ExamAdmin;
import com.exam.repository.AdminRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AdminDetailService implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private AdminRepository adminRepository;

    public UserDetails loadUserByUsername(String adminId) throws UsernameNotFoundException{
        logger.debug("adminId === "+adminId);
        Admin admin = adminRepository.findOneById(adminId);
        if(admin == null){
            throw new UsernameNotFoundException("해당 관리자가 없습니다.");
        }
        ExamAdmin examAdmin = new ExamAdmin(admin, buildAdminAuthority());

        return examAdmin;
    }

    private Set<GrantedAuthority> buildAdminAuthority() {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        setAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        return setAuths;
    }
}
