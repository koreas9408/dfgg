package kr.ac.dongyang.dfgg.board.service;

import kr.ac.dongyang.dfgg.board.model.BoardDTO;
import kr.ac.dongyang.dfgg.common.Criteria;

import java.util.List;

public interface BoardService {
    public List<BoardDTO> findAll() throws Exception;

    public int insertBoard(BoardDTO boardDTO) throws Exception;

    public BoardDTO findByBoardId(Long bno) throws Exception;

    public List<BoardDTO> listPaging(Criteria criteria) throws Exception;

    public int countBoard(Criteria criteria) throws Exception;
}
