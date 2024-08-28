package com.calarm.controller;

import com.calarm.service.SMSservice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
@RequiredArgsConstructor
public class SMSController {

    private final SMSservice smsService;

    @GetMapping("")
    public void sendSms(
            @RequestParam String location
    ){
        smsService.sendSms(location);
    }
}
