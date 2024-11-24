package com.calarm.service;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class SMSservice {

    public void sendSms(String location) {
        // API Key와 Secret Key는 실제로 발급받은 값을 사용해야 합니다.
        String api_key = "";
        String api_secret = "";
        Message coolsms = new Message(api_key, api_secret);
        HashMap<String, String> params = new HashMap<>();

        // 'from'에는 발신자 번호, 'to'에는 수신자 번호를 입력해야 합니다.
        params.put("to", ""); // 수신자 번호
        params.put("from", ""); // 발신자 번호
        params.put("type", "SMS");
        params.put("text", LocalDateTime.now() + "\n"+location + "위치에서 급발진 사건발생"); // 전송할 메시지 내용
        params.put("app_version", "test app 1.2"); // 어플리케이션 버전명 (임의로 설정 가능)

        try {
            // 메시지를 전송하고 결과를 JSONObject로 반환받습니다.
            JSONObject obj = (JSONObject) coolsms.send(params);
            System.out.println(obj.toString());
        } catch (CoolsmsException e) {
            System.out.println("Error Message: " + e.getMessage());
            System.out.println("Error Code: " + e.getCode());
        }
    }
}
