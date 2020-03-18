package br.com.caelum.contas.modelo;
/**
 * Classe responsavel por moldar as contas do banco
 * @author Lucas Impieri
 *
 */
public abstract class Conta implements Comparable<Conta> {
	
	private String titular;
	private double saldo;
	private String agencia;
	private int numero;
	private static int totalContas;
	
	/**
	 * Metodo que incrementa o saldo
	 * @param valor
	 */
	public void depositar(double valor) {
		if (valor <0) {
			throw new IllegalArgumentException("Você tentou depositar um valor negativo");
		}else {
			this.saldo += valor;
		}
	}
	// posso fazer um if com throw new "classe" e capturar essa classe com o "try" e "catch" e posso criar minhas classes para excessoes diferentes
	
	public void sacar(double valor)  {
		if (saldo < valor) {
			throw new IllegalArgumentException("Voce tentou sacar um valor negativo");
		}
		if (this.saldo < valor) {
			throw new SaldoInsuficienteException(valor);
		}		
			this.saldo -= valor;		
	}
	
	public void transferir(double valor, Conta destino) {
			destino.depositar(valor);
			this.sacar(valor);
		
		
	}
	public double calculaRendimento() {
		return saldo*0.1;
	}
	
	@Override
	public String toString() {
		String dados = "titular: " + this.titular + 
		" Numero: " + this.numero +
		" Agencia: " + this.agencia;
		return dados;
	}
	
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if(!(obj instanceof Conta)) {
			return false;
		}
		Conta outraConta = (Conta) obj;
		return (this.numero == outraConta.numero && this.agencia.equals(outraConta.agencia));
	}
	
	@Override
	public int compareTo(Conta outraConta) {
		return this.titular.compareTo(outraConta.titular);
	}
		
	// Getters and Setteres
		/**
	 * Metodo que retorna o valor do saldo
	 * @return
	 */
	public double getSaldo() {
		return this.saldo;
	}
	public String getTitular() {
		return this.titular;
	}
	public int getNumero() {
		return this.numero;
	}
	public String getAgencia() {
		return this.agencia;
	}
	public abstract String getTipo();
	
	// Construtures
	public Conta(String titular,String agencia) {
		this(agencia);
		this.titular = titular;
	}
	public Conta(String agencia) {
		Conta.totalContas += 1;
		this.agencia = agencia;
		this.numero = totalContas;
	}
	
	/*
	 * Terminar de criar esse metodo
			public String ConseguiuOuNao(boolean procedimento){		
				
				if (procedimento) {
					return "Conseguiu";
				}
				return "Nao conseguiu";
			} 
	 */
	
	
}
