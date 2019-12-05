package kr.ac.dongyang.dfgg.neople.controller;

import kr.ac.dongyang.dfgg.common.NeopleApiHelper;
import kr.ac.dongyang.dfgg.neople.vo.SearchVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
public class IndexController {

    @GetMapping("/")
    public String index() {
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

}
