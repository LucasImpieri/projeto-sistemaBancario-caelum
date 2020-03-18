import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import br.com.caelum.contas.modelo.Conta;

// Lancar no projeto

public class p227 {
	public List<Conta> carrega() throws IOException {
		InputStream is = new FileStream("contas.txt");
		
		Scanner s = new Scanner(is);
		List<Conta> contas = new ArrayList<>();
		
		while (s.hasNextLine()) {
			String[]partes = linha.split(",");
			Conta c;
			if (partes[0].equals("Conta Corrente")) {
				c = new ContaCorrente();
			} else {
				c = new ContaPoupanca();
			}
			c.setAgencia(partes[1]);
			c.setNumero(Interger.parseInt(partes[2]));
			c.setTitular(partes[3]);
			c.depositar(Double.parseDouble(partes[4]));
			contas.add(c);
			
			
		}
		s.close();
		Return contas;
	}
}
