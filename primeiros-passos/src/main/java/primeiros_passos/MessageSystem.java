package primeiros_passos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSystem {
    @Autowired
    private Sender noReply;
    @Autowired
    private Sender techTeam;

    public void sendRegisterConfirmation(){
        System.out.println(noReply);
        System.out.println("Your registration has been confirmed. Thank you for registering with us!");
    }

    public void sendWelcomeMessage(){
        techTeam.setEmail("tech@dio.com.br");
        System.out.println(techTeam);
        System.out.println("Welcome to our platform! We're excited to have you on board.");
    }
}
