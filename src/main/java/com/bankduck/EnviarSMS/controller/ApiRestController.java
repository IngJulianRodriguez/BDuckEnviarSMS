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
    public static final String AC1 = "ACc82a6afd5406aec";
    public static final String AC2 = "768db64ca498c9b14";
    public static final String P1 = "c5d33bb6c49e6f3d7";
    public static final String P2 = "1d55bd6a9477e74";
    @PostMapping
    public ResponseEntity<String> post(@RequestBody MensajeRequest input) {

        Twilio.init(AC1+AC2, P1+P2);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("+573046378034"),
                        new com.twilio.type.PhoneNumber("+19147126274"),
                        input.getMensaje())
                .create();

        return new ResponseEntity<String>("Message sent successfully", HttpStatus.OK);
    }
}
