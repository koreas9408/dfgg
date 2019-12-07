package kr.ac.dongyang.dfgg.config.auth;

import kr.ac.dongyang.dfgg.config.auth.model.OAuthAttributes;
import kr.ac.dongyang.dfgg.config.auth.model.SessionMember;
import kr.ac.dongyang.dfgg.member.dao.MemberDAO;
import kr.ac.dongyang.dfgg.member.model.MemberDTO;
import kr.ac.dongyang.dfgg.member.model.Role;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final MemberDAO memberDAO;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(oAuth2UserRequest);

        String registrationId = oAuth2UserRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = oAuth2UserRequest.getClientRegistration().getProviderDetails()
                .getUserInfoEndpoint().getUserNameAttributeName();

        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName,
                oAuth2User.getAttributes());

        MemberDTO member = saveOrUpdate(attributes);
        System.out.println("MemberDTO : " + member);
        httpSession.setAttribute("member", new SessionMember(member));


        return new DefaultOAuth2User(Collections.singleton(
                new SimpleGrantedAuthority(member.getRoleKey())),
                attributes.getAttributes(),
                attributes.getNameAttributekey());

    }

    private MemberDTO saveOrUpdate(OAuthAttributes attributes) {
        String account = attributes.getAccount();
        System.out.println("Google Attribute : " + attributes);

        MemberDTO memberDTO = memberDAO.findByMember(account);
        if (memberDTO == null) {
            memberDAO.insertMember(attributes.toEntity());

            return memberDAO.findByMember(attributes.getAccount());
        }

        if (memberDAO.findByMember(account).getAccount().equals(account)) {

            return memberDAO.findByMember(attributes.getAccount());
        }

        return memberDTO;
    }
}
