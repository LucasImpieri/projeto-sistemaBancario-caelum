import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.Scanner;

public class TestaSaida {
	
	public static void escreve(OutputStream os) throws IOException {
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter b = new BufferedWriter(osw);
		b.write("Qualquer Coisa\n");
		b.close();
	}
	
	
	public static void main(String[] args) throws IOException {
		/*OutputStream os = new FileOutputStream("arquivo.txt");
		escreve(os);
		
		OutputStream saida = System.out;
		escreve(saida);*/
		
		Scanner s = new Scanner(System.in);
		PrintStream ps = new PrintStream("arquivo.txt");
		while (s.hasNextLine()) {
			ps.println(s.nextLine());
		}
	}

}
