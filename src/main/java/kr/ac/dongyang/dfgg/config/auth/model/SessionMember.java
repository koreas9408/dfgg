package kr.ac.dongyang.dfgg.config.auth.model;

import kr.ac.dongyang.dfgg.member.model.MemberDTO;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionMember implements Serializable {

    private String nickname;
    private String account;

    public SessionMember(MemberDTO member) {
        this.nickname = member.getNickname();
        this.account = member.getAccount();
    }
}
