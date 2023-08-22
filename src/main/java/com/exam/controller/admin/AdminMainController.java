package com.exam.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminMainController {

    private final Logger logger = LoggerFactory.getLogger(AdminMainController.class);

    @GetMapping
    public String main(Model model){
        return "admin/index";
    }

    @GetMapping("/login")
    public String login(){
        logger.info("관리자 로그인화면");
        return "admin/login";
    }
}
