package kr.ac.dongyang.dfgg.member.service;

import kr.ac.dongyang.dfgg.member.model.MemberDTO;

public interface MemberService {
    public MemberDTO findByMemberId(String account, String password) throws Exception;
    public void insertMember(MemberDTO member) throws Exception;
}
