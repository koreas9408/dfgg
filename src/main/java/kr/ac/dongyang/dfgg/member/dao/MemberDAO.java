package kr.ac.dongyang.dfgg.member.dao;

import kr.ac.dongyang.dfgg.member.model.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberDAO {
    public void insertMember(MemberDTO member);
    public MemberDTO findByMember(String account);
    public int findByAccount(String account);
    public String findByPassword(String password);


}
