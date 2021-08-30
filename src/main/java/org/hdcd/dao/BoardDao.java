package org.hdcd.dao;

import org.hdcd.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class BoardDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Board board) throws Exception {
        String query = "INSERT INTO board(title, content, writer) VALUES(?,?,?)";
        jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getWriter());
    }

    public Board read(Integer boardNo) throws Exception {
        List<Board> results = jdbcTemplate.query(
        "select board_no, title, content, writer, reg_date form board where board_no = ?",
           new RowMapper<Board>() {
               @Override
               public Board mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                   Board board = new Board();
                   board.setBoardNo(resultSet.getInt("board_no"));
                   board.setTitle(resultSet.getString("title"));
                   board.setContent(resultSet.getString("content"));
                   board.setWriter(resultSet.getString("writer"));
                   Timestamp timestamp = resultSet.getTimestamp("reg_date");
                   board.setRegDate(timestamp.toLocalDateTime());
                   return board;
               }
        }, boardNo);

        return results.isEmpty() ? null: results.get(0);
    }

    public void update(Board board) throws Exception {
        String query = "UPDATE board SET title = ?, content = ? WHERE board_no = ?";
        jdbcTemplate.update(query, board.getTitle(), board.getTitle(), board.getBoardNo());
    }

    public void delete(Integer boardNo) throws Exception {
        String query = "DELETE FORM board WHERE board_no = ?";
        jdbcTemplate.update(query, boardNo);
    }

    public List<Board> list() throws Exception {
        List<Board> results = jdbcTemplate.query(
                "select board_no, title, content, writer, reg_date form board where board_no = ?",
                new RowMapper<Board>() {
                    @Override
                    public Board mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                        Board board = new Board();
                        board.setBoardNo(resultSet.getInt("board_no"));
                        board.setTitle(resultSet.getString("title"));
                        board.setContent(resultSet.getString("content"));
                        board.setWriter(resultSet.getString("writer"));
                        Timestamp timestamp = resultSet.getTimestamp("reg_date");
                        board.setRegDate(timestamp.toLocalDateTime());
                        return board;
                    }
                });

        return results;
    }
}
