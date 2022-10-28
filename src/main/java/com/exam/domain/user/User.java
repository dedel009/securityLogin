package com.exam.domain.user;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "exam_user")
public class User {

    @Id
    private String id;

    private String password;

    private String name;

    private String phone;

}
