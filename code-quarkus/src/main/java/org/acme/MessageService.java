package org.acme;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.logging.Logger;

@ApplicationScoped
public class MessageService {

  private static final Logger LOGGER = Logger.getLogger(MessageService.class.toString());

  @ConfigProperty(name = "twilio.account_sid")
  String accountSid;
  @ConfigProperty(name = "twilio.auth_token")
  String authToken;

  public void send() {
    Twilio.init(accountSid, authToken);
    Message message = Message.creator(
            new com.twilio.type.PhoneNumber("whatsapp:+51957576017"),
            new com.twilio.type.PhoneNumber("whatsapp:+14155238886"), "oscar DEV")
        .create();
    LOGGER.info(message.getSid());
  }

}
