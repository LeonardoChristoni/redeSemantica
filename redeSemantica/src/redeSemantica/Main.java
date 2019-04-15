package redeSemantica;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    String file = "C:\\Users\\nao-t\\Desktop\\IA\\rede1.txt";
	    String vet[];
	    Grafo grafo = new Grafo();
	    
	    try {
	      FileReader arq = new FileReader(file);
	      BufferedReader lerArq = new BufferedReader(arq);
	      String linha = lerArq.readLine();
	      while (linha != null) {
	        System.out.printf("%s\n", linha);
	        vet = linha.split(" ");
	        grafo.adicionarVertice(vet[0]);
	        grafo.adicionarVertice(vet[2]);
	        grafo.criarAresta(vet[0], vet[2], vet[1]);
	        linha = lerArq.readLine();
	      }
	      arq.close();
	    } catch (IOException e) {
	        System.err.printf("Erro na abertura do arquivo: %s.\n",
	        e.getMessage());
	        System.exit(0);
	    }
	    
	    int resposta = 0;
	    
	    while(resposta == 0) {
	    	String inferencia = JOptionPane.showInputDialog("Digite a inferencia:");
	    	try {
			    vet = inferencia.split(" ");
			    boolean resultado =  AlgoritmosBusca.buscaProfundidade(grafo, new Vertice(vet[0]), new Vertice(vet[2],vet[1])); 
			    resposta = JOptionPane.showConfirmDialog(null, "Deseja verificar mais uma inferencia?", inferencia+"->"+resultado, JOptionPane.YES_NO_OPTION);
	    	}catch(Exception e) {
	    		JOptionPane.showMessageDialog(null, "inferencia precisa estar no formato {objeto1 relacao objeto2}");
	    		System.exit(0);
	    	}  	
	    }
	}

}
