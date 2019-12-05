package kr.ac.dongyang.dfgg.board.service;

import kr.ac.dongyang.dfgg.board.dao.BoardDAO;
import kr.ac.dongyang.dfgg.board.model.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardDAO boardDAO;

    @Override
    public List<BoardDTO> findAll() throws Exception{
        return boardDAO.findAll();
    }

    @Override
    public int insertBoard(BoardDTO boardDTO) throws Exception {
        if (boardDAO.insertBoard(boardDTO) == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public BoardDTO findByBoardId(Long bno) throws Exception {
        return boardDAO.findByBoardId(bno);
    }
}
