package com.exam.repository;

import com.exam.domain.Admin;
import com.exam.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String>{
    Admin findOneById(String id);
}
