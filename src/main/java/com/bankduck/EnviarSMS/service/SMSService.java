package com.bankduck.EnviarSMS.service;

import com.bankduck.EnviarSMS.dto.MensajeRequest;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.stereotype.Service;

@Service
public class SMSService {

    public static final String AC1 = "ACc82a6afd5406aec";
    public static final String AC2 = "768db64ca498c9b14";
    public static final String P1 = "c5d33bb6c49e6f3d7";
    public static final String P2 = "1d55bd6a9477e74";
    public void Enviar(MensajeRequest input){
        Twilio.init(AC1+AC2, P1+P2);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("+573046378034"),
                        new com.twilio.type.PhoneNumber("+19147126274"),
                        input.getMensaje())
                .create();
    }
}
