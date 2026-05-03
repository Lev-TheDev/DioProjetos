package primeiros_passos;

import org.springframework.stereotype.Component;

@Component // a classe é um componente, ou seja, um objeto gerenciado pelo Spring, e pode ser injetada em outras classes
public class Calculadora {
    public int somar(int numero1, int numero2) {
        return numero1 + numero2;
    }
}
