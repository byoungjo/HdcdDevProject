package org.hdcd.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.hdcd.domain.Board;
import org.hdcd.domain.Member;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.InputStream;
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
@RequestMapping("/boards")
@Api(tags = "보드테스트")
public class BoardController {
    @GetMapping
    public ResponseEntity<List<Board>> list() {
        log.info("list");
        List<Board> boardList = new ArrayList<>();
        Board board = new Board();
        board.setBoardNo(1);
        board.setTitle("인간실격");
        board.setContent("인간의 모순된 삶");
        board.setWriter("다자이오사무");
        board.setRegDate(LocalDateTime.now());
        boardList.add(board);
        board = new Board();
        board.setBoardNo(2);
        board.setTitle("파리대왕");
        board.setContent("위기의 순간에 심경변화");
        board.setWriter("윌리엄골딩");
        board.setRegDate(LocalDateTime.now());
        boardList.add(board);
        ResponseEntity<List<Board>> entity = new ResponseEntity<>(boardList, HttpStatus.OK);

        return entity;
    }

//    @PostMapping
//    public ResponseEntity<String> register(@RequestBody Board board) {
//        log.info("register");
//        log.info("body {} {}", board.getTitle(), board.getWriter());
//        ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
//        return entity;
//    }

    @PostMapping
    public ResponseEntity<String> register(Board board) {
        log.info("register");
        log.info("body {} {}", board.getTitle(), board.getWriter());
        ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        return entity;
    }

    @GetMapping("/{boardNo}")
    public ResponseEntity<Board> read(@PathVariable("boardNo") int boardNo) {
        log.info("read");
        Board board = new Board();
        board.setBoardNo(1);
        board.setTitle("인간실격");
        board.setContent("인간의 모순된 삶");
        board.setWriter("다자이오사무");
        board.setRegDate(LocalDateTime.now());

        ResponseEntity<Board> entity = new ResponseEntity<>(board, HttpStatus.OK);
        return entity;
    }

    @DeleteMapping("/{boardNo}")
    public ResponseEntity<String> remove(@PathVariable("boardNo") int boardNO) {
        log.info("remove");
        ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        return entity;
    }

    @PutMapping("/{boardNo}")
    public ResponseEntity<String> modify(@PathVariable("boardNo") int boardNo, @RequestBody Board board){
        log.info("modify");
        log.info("body {} {}", board.getTitle(), board.getWriter());
        ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        return entity;
    }
    @RequestMapping(value="/register")
    public void registerForm() {
        log.info("registerForm");
    }

    @GetMapping("/register05")
    @ApiOperation(value = "테스트05")
    public Map<String, Member> register05() {
        log.info("register05");
        Map<String, Member> memberMap = new HashMap<String , Member>();
        Member member = new Member();
        memberMap.put("key1", member);
        Member member2 = new Member();
        member2.setUserId("iron");
        memberMap.put("key2", member2);
        return memberMap;
    }

    @GetMapping("/register06")
    @ApiOperation(value = "테스트06")
    public ResponseEntity<Void> register06() {
        log.info("register06");
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/register07")
    @ApiOperation(value = "테스트07")
    public ResponseEntity<String > register07() {
        log.info("register07");
//        return new ResponseEntity<String >("Hello",HttpStatus.NOT_FOUND);
        return new ResponseEntity<String >("Hello",HttpStatus.OK);
    }
    @GetMapping("/register08")
    @ApiOperation(value = "테스트08")
    public ResponseEntity<Member> register08() {
        log.info("register08");
        Member member = new Member();

        return new ResponseEntity<Member>(member,HttpStatus.OK);
    }
    @GetMapping("/register09")
    @ApiOperation(value = "테스트09")
    public ResponseEntity<List<Member>> register09() {
        log.info("register09");
        List<Member> members = new ArrayList<>();
        Member member = new Member();
        members.add(member);
        Member member2 = new Member();
        members.add(member2);

        return new ResponseEntity<List<Member>>(members,HttpStatus.OK);
    }
    @GetMapping("/register10")
    @ApiOperation(value = "테스트10")
    public ResponseEntity<Map<String, Member>> register10() {
        log.info("register10");
        Map<String, Member> memberMap = new HashMap<String , Member>();
        Member member = new Member();
        memberMap.put("key1", member);
        Member member2 = new Member();
        member2.setUserId("iron");
        memberMap.put("key2", member2);
        return new ResponseEntity<Map<String, Member>>(memberMap,HttpStatus.OK);
    }
    @GetMapping("/register1101")
    @ApiOperation(value = "테스트1101")
    public ResponseEntity<byte[]> register1101() throws Exception {
        log.info("register1101");
        InputStream inputStream = null;
        ResponseEntity<byte[]> entity = null;

        try {
            HttpHeaders headers = new HttpHeaders();
            inputStream = new FileInputStream("D:\\temp\\20210806003-인텔리제이_Sonarlint.png");
            headers.setContentType(MediaType.IMAGE_PNG);
            entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(inputStream), headers, HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
        }
        finally {
            inputStream.close();
        }
        return entity;
    }

    @GetMapping("/register1102")
    @ApiOperation(value = "테스트1102")
    public ResponseEntity<byte[]> register1102() throws Exception {
        log.info("register1101");
        InputStream inputStream = null;
        ResponseEntity<byte[]> entity = null;

        try {
            HttpHeaders headers = new HttpHeaders();
            inputStream = new FileInputStream("D:\\temp\\20210806003-인텔리제이_Sonarlint.png");
            headers.setContentType(MediaType.IMAGE_PNG);
            entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(inputStream), headers, HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
        }
        finally {
            inputStream.close();
        }
        return entity;
    }
}
