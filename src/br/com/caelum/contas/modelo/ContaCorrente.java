package br.com.caelum.contas.modelo;

public class ContaCorrente extends Conta implements Tributavel {
	public ContaCorrente(String titular, String agencia) {
		super(titular,agencia);
	}
	public String getTipo() {
		return "Conta Corrente";
	}
	@Override
	public void sacar(double valor) {
		super.sacar(valor + 0.10);
	}
	@Override
	public double getValorImposto() {
		return this.getSaldo()*0.01;
	}
}