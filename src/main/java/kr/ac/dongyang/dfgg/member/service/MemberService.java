package kr.ac.dongyang.dfgg.member.service;

import kr.ac.dongyang.dfgg.member.model.MemberDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService {
    public MemberDTO findByMember(String account, String password) throws Exception;
    public void insertMember(MemberDTO member) throws Exception;

}
