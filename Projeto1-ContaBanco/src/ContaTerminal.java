import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {

	public static void main(String[] args) {
		int numeroConta;
		String agencia;
		String nome;
		double saldo;
		
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		
		System.out.println("Por favor, digite o número da conta: ");
		numeroConta = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Digite o número da agencia com dígito: ");
		agencia = sc.nextLine();
		
		System.out.println("Digite o nome do Cliente: ");
		nome = sc.nextLine();
		
		System.out.println("Digite o saldo: ");
		saldo = sc.nextDouble();
		
		System.out.println("Olá, " + nome
				+ ", obrigado por criar uma conta em nosso banco, sua agência é "
				+ agencia + ", conta "
				+ numeroConta + " e seu saldo R$"
				+ saldo
				+ " já está disponível para saque.");
		sc.close();
	}
}
