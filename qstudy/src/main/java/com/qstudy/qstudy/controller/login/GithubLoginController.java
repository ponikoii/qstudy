package com.qstudy.qstudy.controller.login;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qstudy.qstudy.dto.login.Github;
import com.qstudy.qstudy.service.login.GithubLoginService;

@RestController
@CrossOrigin
public class GithubLoginController {
	private final GithubLoginService githubLoginService = new GithubLoginService();
	
	@GetMapping(value = "/login/github")
	 public ResponseEntity<?> LoginGithub(@RequestParam(name="code") String code){
		
		//Access Token 받아오는 기능
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Github body = new Github();
        body.setClient_id("3f37100d10a26b66727e");
        body.setClient_secret("ce9c88cab613b903a0bd5ebb4756e40fd9368878");
        body.setCode(code);

        // 요청 엔터티 생성
        // externalApiUrl은 외부 API의 엔드포인트 URL입니다.
        String response = restTemplate.postForObject("https://github.com/login/oauth/access_token", body, String.class);
        String accessToken = extractAccessToken(response);
        
        System.out.println(accessToken);
        
        
        //Github 정보 받아오는 기능
        headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        // 요청 객체 생성
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        // RestTemplate 인스턴스 생성
        restTemplate = new RestTemplate();

        // GET 요청 보내기
        ResponseEntity<String> responseEntity = restTemplate.exchange("https://api.github.com/user", HttpMethod.GET, requestEntity, String.class);
        
        System.out.println(responseEntity);

        // 요청 엔터티 생성
        // externalApiUrl은 외부 API의 엔드포인트 URL입니다.
        
        
		HashMap<String, Object> result = new HashMap<>();		
		return new ResponseEntity<>(result, HttpStatus.OK);
   }
	
	private static String extractAccessToken(String input) {
        String pattern = "access_token=([^&]+)";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return null; // 매치되는 값이 없을 경우 처리
        }
    }

}
