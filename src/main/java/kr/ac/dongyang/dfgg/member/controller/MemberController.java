package kr.ac.dongyang.dfgg.member.controller;

import kr.ac.dongyang.dfgg.member.model.MemberDTO;
import kr.ac.dongyang.dfgg.member.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j2
@RequestMapping(value = "/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

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

        MemberDTO member = memberService.findByMemberId(account, password);

        if (member == null) {
            System.out.println("회원이 없습니다 !");
        } else {
            System.out.println("조회한 회원 : " + member);
        }

        return "";
    }

    @PostMapping("/register")
    public String register(MemberDTO member, RedirectAttributes rttr) throws Exception{
        log.info("MemberController - register called ... !");
        System.out.println("서버로 넘어온 Member 데이터 : " + member);
        memberService.insertMember(member);
        return "redirect:/";
    }

}
