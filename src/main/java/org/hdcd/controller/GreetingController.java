package org.hdcd.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.util.Locale;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/greetings")
@Api(tags = "메세지테스트")

public class GreetingController {
    private final MessageSource messageSource;

    @GetMapping(value = "/welcome", produces = "text/plain;charset=UTF-8")
    public ResponseEntity<String> welcome() {
        String[] args = {"홍길동"};
        String message = messageSource.getMessage("welcome.message", args, Locale.KOREAN);
        log.info(message);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }
}
