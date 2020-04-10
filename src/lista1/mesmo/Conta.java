// Nome: Xossy tadeu de oliveira nascimento
//Matricula: 16015962
//-------------------------
//Nome:
//Matricula:

package lista1.mesmo;

public class Conta {
	private int numConta = 0;
	private String titular;
	private double saldo = 0.0;
	private double credito_Especial = 100;
	static int cont = 0;

	public Conta() {

	}

	public Conta(int numConta) {
		this.numConta = numConta;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public int getNumConta() {
		return numConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void cadastro(String titular) {
		cont++; // O cont contar o numero de conta feitas
		this.numConta = cont; // aqui ele passar numero da conta
		this.titular = titular;

		System.out.println("Conta Criada com sucesso!");
		System.out.println("Numero da conta:" + this.numConta);
		System.out.println("----------------------------------");

	}

	public void Dadosbacarios() {
		System.out.println("");
		System.out.println("-------------------------------------------------------");
		System.out.println("Num conta   Nome do cliente                  Saldo");
		System.out.println("---------   ------------------------------   ----------");
		System.out.printf("%5d       %-10s                          %.2f\n", this.numConta, this.titular, this.saldo);
		System.out.println("-------------------------------------------------------");

	}

	public void Depositar(Double deposito) {

		if (deposito > 0) { // serve para não aceitar valores negativos
			this.saldo += deposito;

			System.out.printf("Saldo altual:%.2f\n ", this.saldo);
			System.out.println("--- Fim do deposito ---");
			System.out.println("");
		} else {
			System.out.println("--- Digite um valor positivo!---");
		}

		int cont = 0; // esse cont é utilizado por que o i nâo funcionava direito
		if (this.credito_Especial < 100) {
			for (int i = 0; i != deposito; i++) {
				cont++;// esse cont serve para credito especial voltar a 100
			}
			if (cont != 100) { // vai parar quando chegar a 100

				this.credito_Especial += cont;

			}
		}
		System.out.println("----------------------------------");
	}

	public void Sacar(Double valor) {
		System.out.println("");

		if (valor > 0) {

			if (this.saldo > 0) {

				this.saldo -= valor;
				System.out.printf("Seu saldo:%.2f\n", this.saldo);
				System.out.printf("valor sacado:%.2f\n", valor);
				System.out.println("");
				System.out.println("--- OPERAÇÃO INCERRADA---");
				System.out.println("");

			}

			if (this.saldo <= 0) {

				boolean resp = false; // serve para fazer auxiliar
				if (this.credito_Especial > 0) {
					if (valor <= this.credito_Especial) {
						this.credito_Especial -= valor;
						this.saldo = -valor;
						System.out.printf("saldo atualizado:%.2f\n", this.saldo);
						System.out.printf("valor sacado:%.2f\n", valor);
						System.out.println("");
						System.out.println("--- OPERAÇÃO INCERRADA---");
						System.out.println("");
						resp = true;

					}
				} else if (resp == false) {
					System.out.println("--- Você não tem mais limite no credito especial ---");
				}

			}
		} else {
			System.out.println("--- Digite um valor positivo: ---");
		}
		System.out.println("----------------------------------");
	}

	public void trasnferir(Conta pdest, double valor) {

		if (valor <= this.saldo) {// caso eu tenha saldo
			this.saldo -= valor;// tira o valor da conta 1. valor é o que tem o valor que vai ser retirado
			pdest.saldo += valor;// coloca na conta 2, o valor é o que vai ser colocado na conta 2

			System.out.println();
			System.out.println("      Dados do destinatário");
			System.out.println("------------------------------------------");
			System.out.println("Num conta   Nome do cliente");
			System.out.println("---------   ------------------------------");
			System.out.printf("%5d       %-10s               ", pdest.numConta, pdest.titular);
			System.out.println();
			System.out.println("------------------------------------------");
			System.out.println();
			System.out.printf("Valor trasferido:%.2f\n", valor);
			System.out.println("Trasferência realizada com sucesso!");

		} else {// caso eu não tenha saldo
			System.out.println("--- SALDO INSUFICIENTE ---");
		}
		System.out.println("----------------------------------");
	}

}
