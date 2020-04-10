//Nome: Xossy tadeu de oliveira nascimento
//Matricula: 16015962
//-------------------------
//Nome:
//Matricula:
package lista1.classe;

import java.util.ArrayList;

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
		boolean achou, achou2;

		do {
			opcao = Keyboard.menu("Cadastrar Contas/ Listar Contas/" + " Excluir Contas/ Efetuar Depositos"
					+ " / Efetuar Saque/ Consutar Conta/ Efetuar trasferência entre contas/ Sair");

			switch (opcao) {

			case 1:// cadrasto
				conta = new Conta();
				String titular = Keyboard.readString("Digite o nome do titular da conta: ");
				conta.cadastro(titular);
				contaCliente.add(conta);
				lista1.util.Keyboard.waitEnter();
				lista1.util.Keyboard.clrscr();

				break;
			case 2:
				conta = new Conta();

				for (Conta c : contaCliente) {
					c.Dadosbacarios();
				}
				lista1.util.Keyboard.waitEnter();
				lista1.util.Keyboard.clrscr();
				break;
			case 3:

				numero = Keyboard.readInt("Digite o numero da conta:");
				achou = false;// é usado para auxiliar o if, por que não se pode usar if dentro do for
				for (Conta c : contaCliente) {
					if (numero == c.getNumConta()) {// compara se o numero da conta existe
						cont = contaCliente.indexOf(c);// pega a posição
						achou = true;

					}

				}

				if (achou == true) {
					contaCliente.remove(cont);
					System.out.println("--- Conta excluida! ---");
					System.out.println("-----------------------");
				}

				if (achou == false) {
					System.out.println("--- Essa conta não existe! ---");
				}

				lista1.util.Keyboard.waitEnter();
				lista1.util.Keyboard.clrscr();
				break;
			case 4:
				conta = new Conta();

				numero = Keyboard.readInt("Digite o numero da conta:");
				achou = false;
				for (Conta c : contaCliente) {
					if (numero == c.getNumConta()) {

						double deposito = Keyboard.readDouble("Digite o valor de deposito:");
						c.Depositar(deposito);
						achou = true;

					}

				}
				if (achou == false) {
					System.out.println("--- Essa conta não existe! ---");
				}

				lista1.util.Keyboard.waitEnter();
				lista1.util.Keyboard.clrscr();
				break;
			case 5:
				conta = new Conta();

				numero = Keyboard.readInt("Digite o numero da conta:");
				achou = false;
				for (Conta c : contaCliente) {
					if (numero == c.getNumConta()) {

						double valor = Keyboard.readDouble("Digite o valor de saque:");
						c.Sacar(valor);
						achou = true;

					}

				}

				if (achou == false) {
					System.out.println("--- Essa conta não existe! ---");
				}

				lista1.util.Keyboard.waitEnter();
				lista1.util.Keyboard.clrscr();
				break;
			case 6:// consutar conta
				conta = new Conta();

				numero = Keyboard.readInt("Digite o numero da conta:");
				achou = false;
				for (Conta c : contaCliente) {
					if (numero == c.getNumConta()) {

						c.Dadosbacarios();
						achou = true;
					}

				}

				if (achou == false) {
					System.out.println("--- Essa conta não existe! ---");
				}

				lista1.util.Keyboard.waitEnter();
				lista1.util.Keyboard.clrscr();
				break;
			case 7:

				achou = false;
				achou2 = false;
				do {// Vai repetir se a conta for digitada errada
					numero = Keyboard.readInt("Digite o numero da conta do remetente:");
					for (Conta xs : contaCliente) {
						if (numero == xs.getNumConta()) {
							achou = true;
							do {// Esse é para a segunda conta
								numero2 = Keyboard.readInt("Digite o numero da conta do destinatario: ");

								for (Conta x : contaCliente) {

									if (numero2 == x.getNumConta()) {
										achou2 = true;
										double valor = Keyboard.readInt("Digite o valor da transferencia: ");
										xs.trasnferir(x, valor);// xs é a conta do remetente, x e a conta do
																// destinatario e o valor que vai transferido

									}

								}
								if (achou2 == false) {
									System.out.println("--- Essa conta não existe! ---");
								}
							} while (achou2 == false);

						}

					}
					if (achou == false) {
						System.out.println("--- Essa conta não existe! ---");
					}
				} while (achou != true);

				lista1.util.Keyboard.waitEnter();
				lista1.util.Keyboard.clrscr();
				break;

			case 8:
				System.out.println("programa encerrado!");
				break;
			}

		} while (opcao != 8);

	}

}
