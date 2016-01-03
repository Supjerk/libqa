package com.libqa.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class IndexController {

    @RequestMapping({"/", "/index"})
    public ModelAndView index(HttpServletRequest request) {
        log.info("request.get = {}", request.getAttribute("isLogin"));
        log.info("request.get = {}", request.getAttribute("userEmail"));
        log.info("request.get = {}", request.getAttribute("userRole"));

        ModelAndView mav = new ModelAndView("/index");

        mav.addObject("isLogin", request.getAttribute("isLogin"));
        return mav;
    }
}
