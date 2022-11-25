package com.exam.service;

import com.exam.domain.Article;
import com.exam.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminArticleServiceImpl implements ArticleService{

    private final Logger logger = LoggerFactory.getLogger(AdminArticleServiceImpl.class);

    private final ArticleRepository articleRepository;

    @Override
    public String getArticleList(Integer boardId, Model model){
        List<Article> articleList = articleRepository.findByBoardId(boardId);
        model.addAttribute("articleList",articleList);
        logger.info("게시글 목록 출력");
        return "user/article/article";
    }

    @Override
    public String insertOrUpdateArticle(Integer articleId, Model model){
        if(articleId != null){
            //수정 시
            model.addAttribute("article",articleRepository.findOneById(articleId));
        }
        return "user/article/insertOrUpdate";
    }
}
