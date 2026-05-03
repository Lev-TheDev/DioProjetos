package primeiros_passos;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Beans {
    @Bean
    public Gson gson(){
        return new Gson();
    }

    @Bean
    @Scope("prototype")
    public Sender sender(){
        System.out.println("Creating Sender bean...");
        Sender sender = new Sender();
        sender.setName("Dio");
        sender.setEmail("noreply@dio.com.br");
        return sender;
    }
}
