package primeiros_passos;

import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PrimeirosPassosApplication {

	public static void main(String[] args) { SpringApplication.run(PrimeirosPassosApplication.class, args);} // método estático da classe SpringApplication, responsável por iniciar a aplicação Spring Boot. Ele recebe como argumento a classe principal da aplicação (PrimeirosPassosApplication.class) e os argumentos de linha de comando (args) passados para o método main. O método run() é o ponto de entrada para a execução da aplicação, e é onde o Spring Boot configura e inicia o contexto da aplicação, escaneando os componentes, configurando as dependências e iniciando o servidor embutido (como Tomcat ou Jetty) para atender às solicitações.
		/*@Bean
		public CommandLineRunner run(JsonConverter converter) throws Exception {
			return args -> {
				String json = "{\"cep\":\"12345-678\",\"street\":\"Rua Exemplo\",\"local\":\"Cidade Exemplo\"}";
				ViaCepResponse response = converter.converter(json);
				System.out.println(response);
			};
		}*/
		@Bean
		public CommandLineRunner run(MessageSystem system) throws Exception{
			return args -> {
				system.sendRegisterConfirmation();
				system.sendWelcomeMessage();
				system.sendRegisterConfirmation();
			};
		}

}
