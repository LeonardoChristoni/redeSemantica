package redeSemantica;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class AlgoritmosBusca {

	static boolean buscaProfundidade(Grafo grafo, Vertice primeiroVertice,Vertice segundoVertice) {
		    System.out.println("\n--- BUSCA EM PROFUNDIDADE ---");
		    String print = "";
		    
			//inicializa lista de visitados e pilha
	        Set<Vertice> visitados = new LinkedHashSet<Vertice>();
	        Stack<Vertice> stack = new Stack<>();
	        
	        //insere primeiro vertice na pilha
	        stack.push(primeiroVertice);
	        
	        int regraRelacao = 0;
	        
	        //enquanto houver elemento empilhado
	        while (!stack.isEmpty()) {
	        	
	        	//desempilha o vertice
	            Vertice vertice = stack.pop();
	            print = print + " ";
                System.out.println(print+vertice.getTipoRelacao() +" "+ vertice.getValor());
                
//                if(vertice.getTipoRelacao() != null) {
//                	 if(segundoVertice.getTipoRelacao().equals("e_um")) {
//                     	regraRelacao=1;
//                     	if(!vertice.getTipoRelacao().equals("e_um")) {
//                			regraRelacao=0;
//                     		return false;
//                     	}
//                     }else if(segundoVertice.getTipoRelacao().equals("tem")) {
//                     	if(vertice.getTipoRelacao().equals("tem")) {
//                     		regraRelacao = 1;
//                     	}
//                     }else {
//                     	if(segundoVertice.getTipoRelacao().equals(vertice.getTipoRelacao())) {
//                     		regraRelacao++;
//                     	}
//                     }
//                }
                
	            //caso vertice for o vertice procurado retorna verdadeiro
	            if(vertice.equals(segundoVertice)){
//	            	if(regraRelacao == 1) {
	            		return true;
//	            	}
	            	//return true;
	            }
	            //marca vertice como visitado e empilha os adjacentes
	            if (!visitados.contains(vertice)) {
	                visitados.add(vertice);
	                for (Vertice v : grafo.getListAdjacencia(vertice.getValor())) {                 
	                	stack.push(v);
	                }
	            }
	        }
	        return false;
	    }
}
