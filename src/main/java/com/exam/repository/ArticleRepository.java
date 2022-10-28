package com.exam.repository;

import com.exam.domain.Article;
import com.exam.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer>{
    List<Article> findByBoardId(Integer boardId);

    Article findOneById(Integer articleId);
}
