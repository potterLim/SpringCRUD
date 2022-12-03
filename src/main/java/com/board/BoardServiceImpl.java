package com.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{
    @Autowired
    BoardDao boardDao;

    @Override
    public int insertBoard(BoardVO vo) {
        return boardDao.insertBoard(vo);
    }

    @Override
    public int deleteBoard(int seq) {
        return boardDao.deleteBoard(seq);
    }

    @Override
    public int updateBoard(BoardVO vo) {
        return boardDao.updateBoard(vo);
    }

    @Override
    public BoardVO getBoard(int seq) {
        return boardDao.getBoard(seq);
    }

    @Override
    public List<BoardVO> getBoardList() {
        return boardDao.getBoardList();
    }
}
