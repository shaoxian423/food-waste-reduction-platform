package com.duan.fwrp.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender {
    // Your Account SID and Auth Token from twilio.com/console
    public static final String ACCOUNT_SID = "ACc622025a6849d61b45dfd770d76ad272";
    public static final String AUTH_TOKEN = "72224ca3252933ab4df08132fd4495e9";

    public static void sendMessage(String toPhoneNumber, String messageContent){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                        new PhoneNumber(toPhoneNumber),  // To number
                        new PhoneNumber("+15734635937"), // From number (must be a Twilio number)
                        messageContent)
                .create();

        System.out.println("SMS sent successfully. SID: " + message.getSid());
    }
}
