package kr.ac.dongyang.dfgg.neople.controller;

import kr.ac.dongyang.dfgg.common.NeopleApiHelper;
import kr.ac.dongyang.dfgg.config.auth.LoginUser;
import kr.ac.dongyang.dfgg.config.auth.model.SessionMember;
import kr.ac.dongyang.dfgg.member.model.MemberDTO;
import kr.ac.dongyang.dfgg.neople.vo.SearchVO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Log4j2
@Controller
public class IndexController {

    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionMember member) {

        // @LoginUser 어노테이션 사용
        // SessionMember member = (SessionMember) httpSession.getAttribute("member");

        if (member != null) {
            model.addAttribute("memberName", member.getNickname());
        }

        return "main/index";

    }

    @GetMapping("/search")
    public ResponseEntity<String> test(@RequestParam("characterName") String characterName) throws Exception {
        log.info("Recived client : " + characterName);
        NeopleApiHelper apiHelper = new NeopleApiHelper();
        return apiHelper.getSearchPlaceByKeyword(new SearchVO("all", characterName));
    }

    @GetMapping("/view")
    public String characterView(
            @RequestParam("serverId") String serverId
            , @RequestParam("characterId") String characterId, Model model) throws Exception {

        log.info("Recived param : " + "serverId : " + serverId + "\t" + "characterId : " + characterId);
        NeopleApiHelper apiHelper = new NeopleApiHelper();
        model.addAttribute("detail", apiHelper.getCharacterView(new SearchVO(serverId, characterId)));
        model.addAttribute("serverId", serverId);
        return "main/view";
    }

    // SecurityConfig에서 설정한 deniedException페이지
    @GetMapping("/error403")
    public String accessDeniedPage() {
        return "error/error403";
    }

}
