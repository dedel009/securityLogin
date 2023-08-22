package com.exam.configure.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private final Logger logger = LoggerFactory.getLogger(UserFailureHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        logger.info("로그인 실패!!");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        logger.info("username === "+username);
        logger.info("password === "+password);

        String errorMessage = "";
        logger.info("exception message === "+exception.getMessage());
        logger.info("exception class === "+exception.getClass());
        if(exception instanceof BadCredentialsException){
            errorMessage = "아이디 또는 비밀번호를 잘못입력하셨습니다.";
        }

        setDefaultFailureUrl("/login?error=true");
        super.onAuthenticationFailure(request,response,exception);
    }
}
