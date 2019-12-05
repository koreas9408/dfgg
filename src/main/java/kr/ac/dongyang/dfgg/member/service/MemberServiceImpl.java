package kr.ac.dongyang.dfgg.member.service;

import kr.ac.dongyang.dfgg.member.dao.MemberDAO;
import kr.ac.dongyang.dfgg.member.model.MemberDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDAO memberDAO;

    @Override
    public MemberDTO findByMemberId(String account, String password) throws Exception{
        MemberDTO member = memberDAO.findByMemberIdandPassword(account, password);
        return member;
    }

    @Override
    public void insertMember(MemberDTO member) throws Exception{
        log.info("MemberServiceImpl - insertMember called ... ! ");
        memberDAO.insertMember(member);
    }
}
