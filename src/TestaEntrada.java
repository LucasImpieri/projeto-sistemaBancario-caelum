import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TestaEntrada {

	public static void imprime (InputStream is) throws IOException {
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		
		String linha = b.readLine();
		System.out.println(linha);
		b.close();
	}
	
	public static void main (String[] args) throws IOException {
		InputStream is = new FileInputStream("arquivo.txt");
		imprime1(is);
		
		InputStream teclado = System.in;
		imprime1(teclado);
	}


	public static void imprime1 (InputStream is) throws IOException {
		Scanner s = new Scanner(is);
		while (s.hasNextLine()) {
			System.out.println(s.nextLine());
		}
		s.close();
	}
}