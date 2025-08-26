public class Main {
    // projeto de uum banco digital
    // cliente com conta poupança e corrente
    // funcionalidades de depósito, saque e transferência (entre contas da própria instituição)
    public static void main(String[] args) {
        Banco banco = new Banco();
        banco.setNome("Banco DigiCoder");

        Cliente cliente1 = new Cliente();
        cliente1.setNome("Jon Doe");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Jane Doe");

        IConta cc = new ContaCorrente(cliente1);
        IConta poupanca = new ContaPoupanca(cliente2);

        cc.depositar(1000);
        cc.transferir(200, poupanca);

        System.out.println("======== " + banco.getNome() + " =========");
        System.out.println("Olá! Seja muito bem vindo!");
        System.out.println("Aqui está o resumo de suas operações:");
        System.out.println("==============================\n");

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}