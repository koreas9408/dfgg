package kr.ac.dongyang.dfgg.member.controller;

import kr.ac.dongyang.dfgg.config.auth.LoginUser;
import kr.ac.dongyang.dfgg.config.auth.model.SessionMember;
import kr.ac.dongyang.dfgg.member.model.MemberDTO;
import kr.ac.dongyang.dfgg.member.service.MemberService;
import kr.ac.dongyang.dfgg.neople.controller.IndexController;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Log4j2
@RequestMapping(value = "/member")
@Controller
public class MemberController {

    private final MemberService memberService;

    private final HttpSession httpSession;

    @GetMapping("/login")
    public String getLogin() {

        return "member/login";
    }

    @GetMapping("/register")
    public String getRegister() {

        return "member/register";
    }

    @PostMapping("/login")
    public String login(@RequestParam("account") String account
                        , @RequestParam("password") String password) throws Exception {

        MemberDTO member = memberService.findByMember(account, password);

        if (member == null) {
            System.out.println("회원이 없습니다 !");
            return "redirect:/member/login";
        }

        System.out.println("조회한 회원 : " + member);
        SessionMember sessionMember = new SessionMember(member);
        httpSession.setAttribute("member", sessionMember);

        return "redirect:/";
    }

    @PostMapping("/register")
    public String register(MemberDTO member, RedirectAttributes rttr) throws Exception{
        log.info("MemberController - register called ... !");
        System.out.println("서버로 넘어온 Member 데이터 : " + member);
        memberService.insertMember(member);
        return "redirect:/";
    }

}
