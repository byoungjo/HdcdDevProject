package org.hdcd.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

@Slf4j
@Controller
public class HomeController {

    @GetMapping("/ajaxHome")
    public String ajaxHome() {
        return "ajaxHome";
    }

    @GetMapping("/registerForm")
    public String registerForm() {
        return "registerForm";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model){
        log.info("locale = {}", locale);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        log.info("formattedDate = {}", formattedDate);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일 (E) a h시 m분 s초");
        String formattedNow = now.format(formatter);
        model.addAttribute("serverTime", formattedNow);
        model.addAttribute("testName", "테스트8");
        
        return "home";
    }
}
