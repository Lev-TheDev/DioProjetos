Java Digital Bank
Bem-vindo ao Java Digital Bank, um sistema bancário digital desenvolvido em Java. Este projeto simula operações bancárias como criação de contas, transferências, investimentos e histórico de transações, utilizando conceitos de programação orientada a objetos e boas práticas de desenvolvimento.  <hr></hr>
🚀 Funcionalidades
Gerenciamento de Contas:  
Criar contas com chaves Pix e saldo inicial.
Depositar e sacar valores.
Transferir dinheiro entre contas.
Investimentos:  
Criar investimentos com taxas personalizadas.
Associar investimentos a contas.
Adicionar e retirar fundos de carteiras de investimento.
Atualizar valores de investimento com base em taxas.
Histórico de Transações:
Consultar o histórico de transações de uma conta.
Exibir detalhes como ID da transação, descrição e valores formatados.
<hr></hr>
🛠️ Tecnologias Utilizadas
Linguagem: Java
Frameworks: Nenhum (projeto puro em Java)
Gerenciador de Dependências: Gradle
IDE Recomendada: IntelliJ IDEA
Paradigma: Programação Orientada a Objetos (POO)
<hr></hr>
📂 Estrutura do Projeto
src/
├── main/
│   ├── java/
│   │   ├── br/com/dio/
│   │   │   ├── exception/       # Exceções personalizadas
│   │   │   ├── model/           # Modelos de domínio (Carteiras, Investimentos, etc.)
│   │   │   ├── repository/      # Repositórios para contas e investimentos
│   │   │   └── Main.java        # Classe principal com o menu interativo
│   └── resources/               # Recursos adicionais (se necessário)
└── test/                        # Testes unitários (não implementados)

<hr></hr>
📖 Como Executar o Projeto
Clone o repositório:  
git clone https://github.com/Lev-TheDev/java-digital-bank.git
cd java-digital-bank
Compile o projeto:  
./gradlew build
Execute o programa:  
./gradlew run
Interaja com o menu:  
Escolha as opções exibidas no terminal para realizar operações bancárias.
<hr></hr>
🧩 Exemplos de Uso
Criar Conta
Escolha a opção 1 - Create Account.
Insira as chaves Pix separadas por vírgula.
Insira o saldo inicial.
Transferir Dinheiro
Escolha a opção 6 - Transfer between accounts.
Insira a chave Pix da conta de origem.
Insira a chave Pix da conta de destino.
Insira o valor a ser transferido.
Consultar Histórico
Escolha a opção 13 - Account history.
Insira a chave Pix da conta desejada.
Visualize o histórico detalhado de transações.
<hr></hr>
🛡️ Tratamento de Erros
Conta Não Encontrada: Exceção lançada ao tentar acessar uma conta inexistente.
Fundos Insuficientes: Exceção lançada ao tentar realizar uma operação sem saldo suficiente.
Carteira de Investimento Duplicada: Exceção lançada ao tentar associar múltiplas carteiras de investimento a uma mesma conta.
<hr></hr>
🧑‍💻 Contribuição
Contribuições são bem-vindas! Siga os passos abaixo:  
Faça um fork do repositório.
Crie uma branch para sua feature/bugfix:
git checkout -b minha-feature
Faça commit das suas alterações:
git commit -m "Descrição da alteração"
Envie suas alterações:
git push origin minha-feature
Abra um Pull Request.
<hr></hr>
📜 Licença
Este projeto está licenciado sob a MIT License. Consulte o arquivo LICENSE para mais detalhes.  <hr></hr>
👨‍💻 Autor
Desenvolvido por Lev-TheDev. 🚀  Se tiver dúvidas ou sugestões, sinta-se à vontade para abrir uma issue ou entrar em contato! 😊
