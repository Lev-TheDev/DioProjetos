package primeiros_passos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component // a classe é um componente, assim como a Calculadora, e pode ser injetada em outras classes
public class MyApp implements CommandLineRunner {
    @Autowired // responsável por injetar a dependência da classe Calculadora, ou seja, criar uma instância da classe e atribuí-la à variável calc
    private Calculadora calc;
    @Override
    public void run(String... args) throws Exception {
        int resultado = calc.somar(10, 20);
        System.out.println("O resultado da soma é: " + resultado);
    }
}
