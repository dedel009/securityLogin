package com.exam.controller.user;

import com.exam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping
public class UserMainController {

    private final Logger logger = LoggerFactory.getLogger(UserMainController.class);

    private final UserRepository userRepository;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "user/index";
    }

    @GetMapping("/login")
    public String login(){
        logger.info("로그인화면");
        return "user/login";
    }
}
