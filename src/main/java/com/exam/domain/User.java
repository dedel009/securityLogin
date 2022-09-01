package com.exam.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "exam_user")
public class User {

    @Id
    private String id;

    private String name;

    private String phone;

}
