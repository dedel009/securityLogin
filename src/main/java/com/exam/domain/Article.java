package com.exam.domain;

import lombok.Data;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "exam_article")
public class Article {

    @Id //PK임을 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment 컬럼임을 명시
    private Integer id;

    @Comment(value = "게시글제목")
    private String title;

    @Lob    //text 타입
    @Comment(value = "게시글내용")
    private String content;

    @Comment(value = "작성시간")
    @CreatedDate
    private LocalDateTime createdDate;

    @Comment(value = "작성자")
    @CreatedBy
    private String createdById;

    @Comment(value = "수정시간")
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @Comment(value = "수정자")
    @LastModifiedBy
    private String lastModifiedById;

    @Comment(value = "게시판아이디")
    @JoinColumn(name = "board_id")
    @ManyToOne
    private Board board;

}

