package com.bankduck.EnviarSMS.controller;

import com.bankduck.EnviarSMS.dto.MensajeRequest;
import com.bankduck.EnviarSMS.service.SMSService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    SMSService smsService;
    @PostMapping
    public ResponseEntity<String> post(@RequestBody MensajeRequest input) {
        smsService.Enviar(input);
        return new ResponseEntity<String>("Message sent successfully", HttpStatus.OK);
    }
}
