# 🏦 Java Digital Bank

![Linguagem](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Build](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white)
![Licença](https://img.shields.io/badge/Licença-MIT-yellow.svg?style=for-the-badge)
![Contribuições](https://img.shields.io/badge/Contribuições-Bem--Vindas-brightgreen.svg?style=for-the-badge)

> Bem-vindo ao **Java Digital Bank**, um projeto de simulação de um sistema bancário digital totalmente desenvolvido em Java. Este sistema demonstra a aplicação prática de conceitos da Programação Orientada a Objetos (POO) para modelar operações como criação de contas, transferências, investimentos e consulta de transações.

---

## 🚀 Funcionalidades

### Gerenciamento de Contas
* Criar contas com chaves Pix e saldo inicial.
* Realizar depósitos e saques.
* Transferir valores entre contas existentes.

### Investimentos
* Criar diferentes tipos de investimentos com taxas de rendimento personalizadas.
* Associar carteiras de investimento a contas de clientes.
* Adicionar e retirar fundos das carteiras de investimento.
* Simular a atualização dos valores investidos com base nas taxas.

### Histórico de Transações
* Consultar o histórico completo de transações de uma conta.
* Exibir detalhes como ID da transação, descrição e valores formatados.

---

## 🖥️ Demonstração no Terminal

O projeto é executado através de um menu interativo no terminal, permitindo ao usuário navegar pelas funcionalidades:

```text
===== Bem-vindo ao Java Digital Bank =====
1 - Create Account
2 - Deposit
3 - Withdraw
4 - List All Accounts
5 - Find Account by Pix Key
6 - Transfer between accounts
7 - Create Investment
8 - List All Investments
9 - Add Investment to Account
10 - Add Funds to Investment Wallet
11 - Withdraw Funds from Investment Wallet
12 - Update Investment Values
13 - Account history
0 - Exit
Escolha uma opção:
```

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java (JDK 17+)
* **Frameworks:** Nenhum (projeto puro em Java para focar nos fundamentos)
* **Gerenciador de Dependências:** Gradle
* **IDE Recomendada:** IntelliJ IDEA
* **Paradigma:** Programação Orientada a Objetos (POO)

---

## 📂 Estrutura do Projeto

O projeto é organizado em pacotes para separar as responsabilidades, seguindo boas práticas de desenvolvimento:

```
src/
├── main/
│   ├── java/
│   │   ├── br/com/dio/
│   │   │   ├── exception/      # Exceções personalizadas
│   │   │   ├── model/          # Modelos de domínio (Contas, Investimentos, etc.)
│   │   │   ├── repository/     # Repositórios para persistência em memória
│   │   │   └── Main.java       # Classe principal com o menu interativo
│   └── resources/
└── test/                       # Testes unitários (a serem implementados)
```

---

## 📖 Como Executar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/Lev-TheDev/java-digital-bank.git](https://github.com/Lev-TheDev/java-digital-bank.git)
    cd java-digital-bank
    ```

2.  **Compile o projeto:**
    ```bash
    ./gradlew build
    ```

3.  **Execute o programa:**
    ```bash
    ./gradlew run
    ```

4.  **Interaja com o menu:**
    * Escolha as opções numéricas exibidas no terminal para realizar as operações bancárias.

---

## 🧩 Exemplos de Uso

### Criar Conta
1.  Escolha a opção `1 - Create Account`.
2.  Insira as chaves Pix desejadas, separadas por vírgula.
3.  Insira o saldo inicial.

### Transferir Dinheiro
1.  Escolha a opção `6 - Transfer between accounts`.
2.  Insira a chave Pix da conta de origem.
3.  Insira a chave Pix da conta de destino.
4.  Insira o valor a ser transferido.

---

## 🛡️ Tratamento de Erros

O sistema possui exceções personalizadas para lidar com cenários de erro comuns:

| Exceção | Descrição |
| :--- | :--- |
| `AccountNotFoundException` | Lançada ao tentar operar com uma conta que não existe. |
| `InsufficientFundsException`| Lançada ao tentar sacar ou transferir um valor maior que o saldo. |
| `WalletAlreadyExistsException`| Lançada ao tentar adicionar uma segunda carteira de investimentos a uma conta. |

---

## 🧑‍💻 Contribuição

Contribuições são muito bem-vindas! Se você quiser ajudar a melhorar o projeto, siga os passos:

1.  Faça um **Fork** do repositório.
2.  Crie uma **Branch** para sua nova feature ou correção de bug:
    ```bash
    git checkout -b minha-feature
    ```
3.  Faça **Commit** das suas alterações com uma mensagem clara:
    ```bash
    git commit -m "feat: Adiciona nova funcionalidade de empréstimo"
    ```
4.  Faça **Push** para a sua branch:
    ```bash
    git push origin minha-feature
    ```
5.  Abra um **Pull Request**.

---

## 📜 Licença

Este projeto está licenciado sob a **MIT License**. Consulte o arquivo `LICENSE` para mais detalhes.

---

## 👨‍💻 Autor

Desenvolvido por **Lev-TheDev**. 🚀

Se tiver dúvidas ou sugestões, sinta-se à vontade para abrir uma *issue* ou entrar em contato! 😊
