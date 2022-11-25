package com.exam.service;

import org.springframework.ui.Model;

public interface ArticleService {

    String getArticleList(Integer boardId, Model model);

    String insertOrUpdateArticle(Integer articleId, Model model);

}