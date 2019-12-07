package kr.ac.dongyang.dfgg.config.auth.model;

import kr.ac.dongyang.dfgg.member.model.MemberDTO;
import kr.ac.dongyang.dfgg.member.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OAuthAttributes {

    private Map<String, Object> attributes;
    private String nameAttributekey;
    private String nickname;
    private String account;
    private String picture;

    public static OAuthAttributes of(String registrationId, String userNameAttributeName,
                                     Map<String, Object> attributes) {
        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        OAuthAttributes oAuthAttributes = new OAuthAttributes();
        oAuthAttributes.setNickname((String) attributes.get("name"));
        oAuthAttributes.setAccount((String) attributes.get("email"));
        oAuthAttributes.setPicture((String) attributes.get("picture"));
        oAuthAttributes.setAttributes(attributes);
        oAuthAttributes.setNameAttributekey(userNameAttributeName);

        return oAuthAttributes;
    }

    public MemberDTO toEntity() {
        MemberDTO member = new MemberDTO();
        member.setPassword("1234");
        member.setAccount(account);
        member.setNickname(nickname);
        member.setRole(Role.GUEST);

        return member;
    }


}
