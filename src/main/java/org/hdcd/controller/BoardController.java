package org.hdcd.controller;

import lombok.extern.slf4j.Slf4j;
import org.hdcd.domain.Board;
import org.hdcd.domain.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/boards")
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
    public ResponseEntity<Void> register06() {
        log.info("register06");
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
