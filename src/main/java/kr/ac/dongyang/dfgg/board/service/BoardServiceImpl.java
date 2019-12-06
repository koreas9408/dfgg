package kr.ac.dongyang.dfgg.board.service;

import kr.ac.dongyang.dfgg.board.dao.BoardDAO;
import kr.ac.dongyang.dfgg.board.model.BoardDTO;
import kr.ac.dongyang.dfgg.common.Criteria;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
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

    @Override
    public List<BoardDTO> listPaging(Criteria criteria) throws Exception {

        return boardDAO.listPaging(criteria);
    }

    @Override
    public int countBoard(Criteria criteria) throws Exception {
        return boardDAO.countBoard(criteria);
    }
}
