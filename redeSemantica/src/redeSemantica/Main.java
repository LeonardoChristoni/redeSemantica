package redeSemantica;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    String file = "C:\\Users\\1531454\\Documents\\testeSemantico.txt";
	    try {
	      FileReader arq = new FileReader(file);
	      BufferedReader lerArq = new BufferedReader(arq);
	      String linha = lerArq.readLine();
	      Grafo grafo = new Grafo();
	      while (linha != null) {
	        System.out.printf("%s\n", linha);
	        String vet[] = linha.split(" ");
	        grafo.adicionarVertice(vet[0]);
	        grafo.adicionarVertice(vet[2]);
	        grafo.criarAresta(vet[0], vet[2], vet[1]);
	        linha = lerArq.readLine();
	      }
	      System.out.println("\n-------GRAFO-------\n"+grafo.exibirGrafo());
	 
	      arq.close();
	    } catch (IOException e) {
	        System.err.printf("Erro na abertura do arquivo: %s.\n",
	          e.getMessage());
	    }
	}

}
