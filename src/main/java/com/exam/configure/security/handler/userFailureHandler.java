package com.exam.configure.security.handler;

import com.exam.configure.security.service.AdminDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class userFailureHandler implements AuthenticationFailureHandler {

    private final Logger logger = LoggerFactory.getLogger(userFailureHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        //로그인 실패로직
        logger.info("로그인 실패입니다.");
    }
}
