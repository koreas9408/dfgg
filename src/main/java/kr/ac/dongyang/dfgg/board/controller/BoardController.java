package kr.ac.dongyang.dfgg.board.controller;

import kr.ac.dongyang.dfgg.board.model.BoardDTO;
import kr.ac.dongyang.dfgg.board.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;


@Controller
@Log4j2
@RequestMapping(value = "/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("")
    public String findAll(Model model) throws Exception{
        List<BoardDTO> boardList = boardService.findAll();
        model.addAttribute("list", boardList);
        log.info("BoardController findAll called ... ");

        // 왜 LocalDateTime 이 null이 찍힐까??
        return "board/index";
    }
    @GetMapping("/{bno}")
    public String findByBoardId(@PathVariable Long bno, Model model) throws Exception {
        log.info("BoardController findByBoardId Method called.....");
        BoardDTO boardDTO = boardService.findByBoardId(bno);
        model.addAttribute("boardDTO", boardDTO);
        return "board/view";
    }
    @GetMapping("/write")
    public String writeBoard() {
        return "board/write";
    }

    @PostMapping("/write")
    public String insertBoard(BoardDTO boardDTO, RedirectAttributes rttr) throws Exception {
        // 객체(BoardDTO boardDTO)로 전달받는다.
        log.info("BoardController - insertBoard Method Called....");
        log.info("전달받은 BoardDTO : " + boardDTO);

        if (boardService.insertBoard(boardDTO) == 1) {
            return "redirect:/board/";
        } else {
            return "/";
        }
    }
}
