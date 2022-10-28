package com.exam.controller.user;

import com.exam.domain.Board;
import com.exam.domain.admin.ExamAdmin;
import com.exam.domain.user.ExamUser;
import com.exam.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice(basePackages = {"com.exam.controller.user"})
public class UserControllerAdvice {

    @Autowired
    private BoardRepository boardRepository;

    @ModelAttribute("admin")
    public ExamAdmin getAdmin(@AuthenticationPrincipal ExamAdmin examAdmin){
        return examAdmin;
    }

    @ModelAttribute("user")
    public ExamUser getUser(@AuthenticationPrincipal ExamUser examUser){
        return examUser;
    }

    @ModelAttribute("boardList")
    public List<Board> getBoardList(){
        List<Board> boardList = boardRepository.findAll();
        return boardList;
    }

}
