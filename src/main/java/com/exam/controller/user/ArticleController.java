package com.exam.controller.user;

import com.exam.domain.Board;
import com.exam.repository.BoardRepository;
import com.exam.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/article/{boardId}")
public class ArticleController {

    private final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    @Autowired
    private BoardRepository boardRepository;

    @ModelAttribute("board")
    public Board getBoard(@PathVariable("boardId") Integer boardId){
        return boardRepository.findOneById(boardId);
    }

    @GetMapping
    public String getArticleList(@PathVariable("boardId") Integer boardId, Model model){
        return articleService.getArticleList(boardId, model);
    }

    @GetMapping("/insert")
    public String insertArticle(){
        return "user/article/insertOrUpdate";
    }

    @GetMapping("/{articleId}")
    public String updateArticle(@PathVariable("articleId") Integer articleId, Model model){
        return articleService.insertOrUpdateArticle(articleId, model);
    }
}
