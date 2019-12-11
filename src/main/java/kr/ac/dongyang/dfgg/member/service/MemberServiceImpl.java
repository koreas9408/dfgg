package kr.ac.dongyang.dfgg.member.service;

import kr.ac.dongyang.dfgg.member.dao.MemberDAO;
import kr.ac.dongyang.dfgg.member.model.MemberDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDAO memberDAO;


    @Override
    public MemberDTO findByMember(String account, String password) throws Exception {
        log.info("MemberServiceImpl - findByMember called ... ! ");
        int result = memberDAO.findByAccount(account);
        boolean isMember = false;

        if (result == 1) {
            String encodePassword = memberDAO.findByPassword(account);
            System.out.println("계정 : " + account + " DB 패스워드 : " + encodePassword);
            isMember = new BCryptPasswordEncoder().matches(password, encodePassword);
        }

        if (result == 1 && isMember) {
            MemberDTO member = memberDAO.findByMember(account);
            return member;
        }

        return null;
    }

    @Override
    public void insertMember(MemberDTO member) throws Exception{
        log.info("MemberServiceImpl - insertMember called ... ! ");
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodePassword = bCryptPasswordEncoder.encode(member.getPassword());
        member.setPassword(encodePassword);
        memberDAO.insertMember(member);
    }

}
