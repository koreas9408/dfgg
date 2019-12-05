package kr.ac.dongyang.dfgg.member.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberDTO {

    private Long id;
    private String account;
    private String password;
    private String nickname;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
