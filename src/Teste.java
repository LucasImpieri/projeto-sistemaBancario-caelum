import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Teste {
	
	public static void imprime (List <String> lista) {
		for(String f : lista) {
			System.out.println(f);
		}
	}

	public static void main(String[] args) {
		
		List<String> frutas = new ArrayList<>();
		frutas.add("limao");
		frutas.add("banana");		
		frutas.add("abacaxi");
		
		
		frutas.size();
		
		if (frutas.contains("limao")) {
			System.out.println("Existe");
			System.out.println();
		}
		
		Collections.sort(frutas);
		
		imprime (frutas); 
				
	}


}
