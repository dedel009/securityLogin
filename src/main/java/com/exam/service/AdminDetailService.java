package com.exam.service;

import com.exam.domain.admin.Admin;
import com.exam.domain.admin.ExamAdmin;
import com.exam.repository.AdminRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AdminDetailService implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(AdminDetailService.class);

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String adminId) throws UsernameNotFoundException{
        logger.info("adminId === "+adminId);
        Admin admin = adminRepository.findOneById(adminId);
        if(admin == null){
            throw new UsernameNotFoundException("해당 관리자가 없습니다.");
        }
//        String password = passwordEncoder.encode(admin.getPassword());
//        logger.info("password ==="+password);
//        if(passwordEncoder.matches(admin.getPassword(),password)){
//            logger.info("비밀번호 일치");
//        }else{
//            logger.info("비밀번호 불일치");
//        }
//        admin.setPassword(password);

        ExamAdmin examAdmin = new ExamAdmin(admin, buildAdminAuthority());

        return examAdmin;
    }

    private Set<GrantedAuthority> buildAdminAuthority() {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        setAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        return setAuths;
    }
}
