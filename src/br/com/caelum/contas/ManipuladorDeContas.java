package br.com.caelum.contas;
import java.util.Collections;
import java.util.List;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;
import br.com.caelum.contas.modelo.ContaPoupanca;
import br.com.caelum.javafx.api.util.Evento;

public class ManipuladorDeContas {

	public Conta conta;

	public void criaConta(Evento evento) {
		String tipo = evento.getSelecionadoNoRadio("tipo");
		if (tipo.equals("Conta Corrente")) {
			this.conta = new ContaCorrente((evento.getString("titular")), (evento.getString("agencia")));
		} else if (tipo.equals("Conta Poupança")) {
			this.conta = new ContaPoupanca((evento.getString("titular")), (evento.getString("agencia")));
		}
	}
		
	public void deposita(Evento evento) {
		double valorDigitado = evento.getDouble("valorOperacao");
		//try {
			this.conta.depositar(valorDigitado);
		//} catch (IllegalArgumentException e) {
			
		//}
	}
	
	public void saca(Evento evento) {
		double valorDigitado = evento.getDouble("valorOperacao");
		this.conta.sacar(valorDigitado);		
	}
	
	public void transfere(Evento evento) {
		Conta destino = (Conta)evento.getSelecionadoNoCombo("destino");
		conta.transferir(evento.getDouble("valorTransferencia"), destino);
	}
	
	public void ordenaLista(Evento evento) {
		List<Conta> contas = evento.getLista("destino");
		Collections.sort(contas);
	}	
	
	public void salvaDados(Evento evento) {
		List<Conta> contas = evento.getLista("listaContas");
		RepositorioDeContas repositorio = new RepositorioDeContas();
		repositorio.salva(contas);
	}	
}