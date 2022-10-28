package com.exam.domain.admin;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "exam_admin")
public class Admin {

    @Id
    private String id;

    private String password;

    private String name;

    private String phone;
}
