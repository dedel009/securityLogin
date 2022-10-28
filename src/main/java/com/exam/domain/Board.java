package com.exam.domain;

import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "exam_board")
public class Board {

    @Id //PK임을 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment 컬럼임을 명시
    private Integer id;

    @Comment(value = "게시판명")
    private String name;

    @Comment(value = "게시판스킨")
    private String skin;

    @Comment(value = "게시판사용유무")
    @Column(name = "use_board")
    private Boolean useBoard;

//    @Comment("게시글아이디")
//    @OneToMany
//    private List<Article> articles;
}

