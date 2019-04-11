package redeSemantica;
import java.io.*;
import java.util.Scanner;

public class Main {
	
	public Main(String[] args) {
		Scanner ler = new Scanner(System.in);
	    String nomeArquivo = ler.nextLine();
	    try {
	      FileReader arq = new FileReader(nomeArquivo);
	      BufferedReader lerArq = new BufferedReader(arq);
	      String linha = lerArq.readLine();
	      while (linha != null) {
	        System.out.printf("%s\n", linha);
	        linha = lerArq.readLine();
	      }
	 
	      arq.close();
	    } catch (IOException e) {
	        System.err.printf("Erro na abertura do arquivo: %s.\n",
	          e.getMessage());
	    }
		
	}
}
