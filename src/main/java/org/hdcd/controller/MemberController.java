package org.hdcd.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.hdcd.domain.Board;
import org.hdcd.domain.Member;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* chcp 65001
 */
@Slf4j
@RestController
@Api(tags = "멤버테스트")
public class MemberController {

    @GetMapping("/register/{userId}")
    public ResponseEntity<String> register01(@PathVariable("userId") String  userId ) {
        log.info("userId = {}", userId);
        ResponseEntity<String>  entity = new ResponseEntity<String >("SUCCESS", HttpStatus.OK);
        return entity;
    }

    @PostMapping("/register/{userId}/{password}")
    public ResponseEntity<String> register(@PathVariable("userId") String userId,@PathVariable("password") String password) {
        log.info("userId = {} {}", userId, password);
        ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        return entity;
    }

    @PostMapping("/register01")
    public ResponseEntity<String> register01(@RequestBody Member member) {
        log.info("userId = {} {}", member.getUserId(), member.getPassword());

        ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        return entity;
    }
    @PostMapping("/register02")
    public ResponseEntity<String> register02(@RequestBody List<Member> members) {
        for (Member member :members) {
            log.info("userId = {} {}", member.getUserId(), member.getPassword());
        }

        ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        return entity;
    }

    @PostMapping("/register03")
    public ResponseEntity<String> register03(@RequestBody List<Member> members) {
        for (Member member :members) {
            log.info("userId = {} {}", member.getUserId(), member.getPassword());
        }

        ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        return entity;
    }

    @Value("${app.upload.dir:${user.home}}")
    private String uploadDir;
    @PostMapping(value = "/upload", produces = "text/plain;charset=UTF-8")
    public ResponseEntity<String> upload(MultipartFile file) {
        String originalFileName = file.getOriginalFilename();
        log.info("original filename {}", originalFileName);

        Path copyOfLocation = Paths.get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
        try {
            Files.copy(file.getInputStream(), copyOfLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ResponseEntity<String> entity = new ResponseEntity<>("UPLOAD SUCCESS " + originalFileName, HttpStatus.OK);
        return entity;
    }
}
