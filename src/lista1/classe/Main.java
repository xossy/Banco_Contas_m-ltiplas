package lista1.classe;

import java.util.ArrayList;
import java.util.Iterator;

import lista1.mesmo.Conta;
import lista1.util.Keyboard;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Conta> contaCliente = new ArrayList<>();
		Conta conta;
		int opcao;
		int numero, numero2;
		int cont = 0;

		do {
			opcao = Keyboard.menu("Cadastrar Contas/ Listar Contas/" + " Excluir Contas/ Efetuar Depositos"
					+ " / Efetuar Saque/ Consutar Conta/ Efetuar trasferência entre contas/ Sair");

			switch (opcao) {

			case 1:// cadrasto
				conta = new Conta();
				String titular = Keyboard.readString("Digite o nome do titular da conta: ");
				conta.cadastro(titular);
				contaCliente.add(conta);

				break;
			case 2:
				conta = new Conta();

				for (Conta c : contaCliente) {
					c.Dadosbacarios();
				}
				break;
			case 3:
				numero = Keyboard.readInt("Digite o numero da sua conta:");
				for (Conta xs : contaCliente) {
					if (numero == xs.getNumConta()) {
						cont = contaCliente.indexOf(xs);

					}
				}
				contaCliente.remove(cont);
				System.out.println("CONTA EXCLUIDA!");
				System.out.println("------------------");

				break;
			case 4:
				conta = new Conta();

				numero = Keyboard.readInt("Digite o numero da conta:");

				double deposito = Keyboard.readDouble("Digite o valor de deposito:");

				Main.verificar(contaCliente, numero).Depositar(deposito);

				break;
			case 5:// saque
				conta = new Conta();

				numero = Keyboard.readInt("Digite o numero da conta:");
				boolean achou = false;
				for (Conta c : contaCliente) {
					if (numero == c.getNumConta()) {

						double valor = Keyboard.readDouble("Digite o valor de saque:");
						c.Sacar(valor);
						System.out.println("valor1");
						achou = true;

					}

				}

				if (achou == false) {
					System.out.println("Essa conta não existe!");
					System.out.println("valor2");
				}

				break;
			case 6:// consutar conta
				conta = new Conta();
				numero = Keyboard.readInt("Digite o numero da conta:");

				for (Conta c : contaCliente) {
					if (numero == c.getNumConta()) {

						c.Dadosbacarios();
					} else {
						System.out.println("Essa conta não existe!");
					}
				}

				break;
			case 7:
				numero = Keyboard.readInt("Digite o numero da sua conta:");
				for (Conta xs : contaCliente) {
					if (numero == xs.getNumConta()) {
						numero2 = Keyboard.readInt("Digite digite a conta do destinatario: ");

						for (Conta x : contaCliente) {
							if (numero2 == x.getNumConta()) {

								double valor = Keyboard.readInt("Digite o valor da transferencia: ");
								xs.trasnferir(x, valor);

							}
						}

					}
				}
				break;

			case 8:
				System.out.println("programa encerrado!");
				break;
			}

		} while (opcao != 8);

	}

	public Conta verificar(ArrayList<Conta> contaCliente, int numero) {

		
			boolean achou = false;
			
			for (Conta c : contaCliente) {
			
				if (numero == c.getNumConta()) {
					achou = true;
					return c;
				}

				}			

			if (achou == false) {
				System.out.println("Essa conta não existe!");

				
			}
			return null;

			
		 
	}

}
