package redeSemantica;
import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ler = new Scanner(System.in);
		System.out.println("Digite o nome do arquivo:");
	    String nomeArquivo = ler.nextLine();
	    
	    try {
	      FileReader arq = new FileReader(nomeArquivo);
	      BufferedReader lerArq = new BufferedReader(arq);
	      String linha = lerArq.readLine();
	      while (linha != null) {
	        System.out.printf("%s\n", linha);
	        String vet[] = linha.split(" ");
	        linha = lerArq.readLine();
	      }
	 
	      arq.close();
	    } catch (IOException e) {
	        System.err.printf("Erro na abertura do arquivo: %s.\n",
	          e.getMessage());
	    }
	}

}
