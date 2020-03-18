package br.com.caelum.contas.modelo;

public class ContaPoupanca extends Conta {
	public ContaPoupanca(String titular, String agencia) {
		super(titular,agencia);
	}
	public String getTipo() {
		return "Conta Poupança";
	}
}
