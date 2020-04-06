package lista1.mesmo;

public class Conta {
	private int numConta;
	private String titular;
	private double saldo;
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
		cont++;
		this.numConta = cont;
		this.titular = titular;

		System.out.println("Conta Criada com sucesso!");
		System.out.println("Numero da conta:" + this.numConta);
		System.out.println("----------------------------------");

	}

	public void Dadosbacarios() {
		System.out.println("");
		System.out.println("-------------------------------------------------");
		System.out.println("  CONTA              CLIENTE             SALDO");
		System.out.println("----------   -----------------------   ----------");
		System.out.printf("%5d                 %-10s          %.2f\n", this.numConta, this.titular, this.saldo);
		System.out.println("--------------------------------------------------");
	}

	public void Depositar(Double deposito) {
		System.out.println("");
		System.out.println(" Realizar deposito");
		System.out.printf(" Saldo posterior:%.2f\n ", this.saldo);

		if (deposito > 0) {
			this.saldo += deposito;

			System.out.printf("  saldo altual:%.2f\n ", this.saldo);
			System.out.println("  Fim do deposito---");
			System.out.println("");
		} else {
			System.out.println("Digite um valor positivo!");
		}
	}

	public void Sacar(Double valor) {
		System.out.println("");
		System.out.println("  Realizar seque");
		System.out.printf("  Saldo anterior:%.2f\n", this.saldo);

		if (valor <= this.saldo) {// caso eu tenha saldo
			this.saldo -= valor;

			System.out.printf("  saldo atual:%.2f\n", this.saldo);
			System.out.println("");

		} else {// caso eu não tenha saldo
			System.out.println("--- SALDO INSUFICIENTE ---");
		}

		System.out.println("--- OPERAÇÃO INCERRADA---");
		System.out.println("");
	}
	
	public void trasnferir(Conta pdest, double valor) {

		System.out.println("");
		System.out.println("--- Realizar Trasferencia ---");
		System.out.printf("---Saldo atual da sua conta:%.2f\n", this.saldo);
		

		if (valor <= this.saldo) {// caso eu tenha saldo
			this.saldo -= valor;//tira o valor da conta 1. pvalor é o que tem o valor que vai ser retirado
			pdest.saldo += valor;//coloca na conta 2, o pvalor é o que vai ser colocado na conta 2

			System.out.println("--- Trasferencia realizada com sucesso!");
			System.out.println("");
			System.out.printf("---Saldo atualizado:%.2f\n", this.saldo);
			System.out.printf("---Valor trasferido:%.2f\n", valor);
			
		} else {// caso eu não tenha saldo
			System.out.println("--- SALDO INSUFICIENTE --");
		}

	}

}
