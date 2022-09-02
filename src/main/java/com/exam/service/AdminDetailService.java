package com.exam.service;

import com.exam.domain.Admin;
import com.exam.domain.ExamAdmin;
import com.exam.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
//public class AdminDetailService implements UserDetailsService {
//
//    @Autowired
//    private AdminRepository adminRepository;
//
//    public UserDetails loadUserByUsername(String adminId) throws UsernameNotFoundException{
//        Admin admin = adminRepository.findOneById(adminId);
//        if(admin == null){
//            throw new UsernameNotFoundException("해당 관리자가 없습니다.");
//        }
//        ExamAdmin examAdmin = new ExamAdmin(admin, )
//
//        return
//    }
//
//
//}
