package kr.ac.dongyang.dfgg.board.dao;

import kr.ac.dongyang.dfgg.board.model.BoardDTO;
import kr.ac.dongyang.dfgg.common.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
@Mapper
public interface BoardDAO {
    public List<BoardDTO> findAll() throws Exception;

    public int insertBoard(BoardDTO boardDTO) throws Exception;

    public BoardDTO findByBoardId(Long bno) throws Exception;

    public List<BoardDTO> listPaging(Criteria criteria) throws Exception;

    public int countBoard(Criteria criteria) throws Exception;
}
