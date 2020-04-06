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
			opcao = Keyboard.menu(" Sair/ Cadastrar Contas/ Listar Contas/" + " Excluir Contas/ Efetuar Depositos"
					+ " / Efetuar Saque/ Consutar Conta/ Efetuar trasferência entre contas");

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
				for (Conta c : contaCliente) {
					if (numero == c.getNumConta()) {

						double deposito = Keyboard.readDouble("Digite o valor de deposito:");
						c.Depositar(deposito);
					}
				}
				break;
			case 5:// saque
				conta = new Conta();

				numero = Keyboard.readInt("Digite o numero da conta:");
				for (Conta c : contaCliente) {
					if (numero == c.getNumConta()) {

						double valor = Keyboard.readDouble("Digite o valor de deposito:");
						c.Sacar(valor);
					}
				}

				break;
			case 6:// consutar conta
				conta = new Conta();
				numero = Keyboard.readInt("Digite o numero da conta:");

				for (Conta c : contaCliente) {
					if (numero == c.getNumConta()) {

						c.Dadosbacarios();
					}
				}

				break;
			case 7:

				numero = Keyboard.readInt("Digite o numero da sua conta:");

				for (Conta xs : contaCliente) {
					if (numero == xs.getNumConta()) {

						numero2 = Keyboard.readInt("Digite digite a segunda conta: ");
						for (Conta x : contaCliente) {
							if (numero2 == x.getNumConta()) {

								double valor = Keyboard.readInt("Digite o valor da transferencia: ");
								xs.trasnferir(x, valor);
							}

						}

					}

				}
				break;
			}

		} while (opcao != 0);

	}

}
