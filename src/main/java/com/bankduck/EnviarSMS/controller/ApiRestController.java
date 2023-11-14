package com.bankduck.EnviarSMS.controller;

import com.bankduck.EnviarSMS.dto.MensajeRequest;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Api(tags = "Api enviar mensajes de texto")
@RestController
@RequestMapping("/enviarsms")
public class ApiRestController {
    public static final String ACCOUNT_SID = "ACc82a6afd5406aec768db64ca498c9b14";
    public static final String AUTH_TOKEN = "6a5390fd307e7693b492477a37b1895c";
    @PostMapping
    public ResponseEntity<String> post(@RequestBody MensajeRequest input) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("+573046378034"),
                        new com.twilio.type.PhoneNumber("+19147126274"),
                        input.getMensaje())
                .create();

        return new ResponseEntity<String>("Message sent successfully", HttpStatus.OK);
    }
}
