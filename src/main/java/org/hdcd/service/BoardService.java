package org.hdcd.service;

import org.hdcd.domain.Board;

public interface BoardService {
    public void register(Board board) throws Exception;

    public Board read(Integer boardNo) throws Exception;

    public Board modify(Board board) throws Exception;

}
