package com.exam.service;

import com.exam.domain.Article;
import com.exam.repository.ArticleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ArticleService {

    private final Logger logger = LoggerFactory.getLogger(ArticleService.class);

    @Autowired
    private ArticleRepository articleRepository;

    public String getArticleList(Integer boardId, Model model){
        List<Article> articleList = articleRepository.findByBoardId(boardId);
        model.addAttribute("articleList",articleList);
        logger.info("게시글 목록 출력");
        return "user/article/article";
    }

    public String insertOrUpdateArticle(Integer articleId, Model model){
        if(articleId != null){
            //수정 시
            model.addAttribute("article",articleRepository.findOneById(articleId));
        }
        return "user/article/insertOrUpdate";
    }
}
