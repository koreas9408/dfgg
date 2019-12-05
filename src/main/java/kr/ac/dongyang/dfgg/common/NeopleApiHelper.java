package kr.ac.dongyang.dfgg.common;

import kr.ac.dongyang.dfgg.neople.vo.SearchVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URLEncoder;

public class NeopleApiHelper {
    private final String NEOPLEAPI_KEY = "148WcOavLdl8lvkSFw9kRy746ED4e1M1";

    private static final String API_SERVER_HOST  = "https://api.neople.co.kr/df";

    public ResponseEntity<String> getSearchPlaceByKeyword(SearchVO searchVO) throws Exception {
        String encodeURL = URLEncoder.encode(searchVO.getCharacterName(), "UTF-8");
        String queryString = "/servers/"+ searchVO.getServerId() + "/characters?characterName=" + encodeURL + "&wordType=full&limit=20";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.add("apikey", NEOPLEAPI_KEY);
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

        URI url = URI.create(API_SERVER_HOST+queryString);
        RequestEntity<String> rq = new RequestEntity<>(headers, HttpMethod.GET, url);
        ResponseEntity<String> re = restTemplate.exchange(rq, String.class);

        return re;
    }

    public ResponseEntity<String> getCharacterView(SearchVO searchVO) throws Exception {
        String encodeURL = URLEncoder.encode(searchVO.getCharacterName(), "UTF-8");
        String queryString = "/servers/"+ searchVO.getServerId() + "/characters/" + encodeURL;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.add("apikey", NEOPLEAPI_KEY);
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

        URI url = URI.create(API_SERVER_HOST+queryString);
        RequestEntity<String> rq = new RequestEntity<>(headers, HttpMethod.GET, url);
        ResponseEntity<String> re = restTemplate.exchange(rq, String.class);

        return re;
    }

}
