package redeSemantica;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class AlgoritmosBusca {

	static boolean buscaProfundidade(Grafo grafo, Vertice primeiroVertice,Vertice segundoVertice) {
		    System.out.println("\n--- BUSCA EM PROFUNDIDADE ---");
		    
		    List<Vertice> relacoes = new ArrayList<>();
		    Set<Vertice> visitados = new LinkedHashSet<Vertice>();
	        Stack<Vertice> stack = new Stack<>();
	        int regraRelacao = 0;
	        
	        //insere primeiro vertice na pilha
	        stack.push(primeiroVertice);
	        
	        //enquanto houver elemento empilhado
	        while (!stack.isEmpty()) {
	        	
	        	//desempilha o vertice
	            Vertice vertice = stack.pop();
                relacoes.add(vertice);
                
	            //caso o vertice for o vertice procurado
	            if(vertice.equals(segundoVertice)){
	            	
	            	System.out.print(primeiroVertice.getValor().toUpperCase()+" - ");
	            	
	            	for(Vertice relacao:relacoes) {
	            		System.out.print(relacao.getTipoRelacao()==null?"":relacao.getTipoRelacao()+" - "+relacao.getValor().toUpperCase()+" - ");
	            	}
	            	
	                if(vertice.getTipoRelacao() != null) {
	                	
	                	//se for do tipo e_um vai verificar se todas relacoes são e_um
	                	 if(segundoVertice.getTipoRelacao().equals("e_um")) {
	                     	for(Vertice relacao:relacoes) {
	                     		if(!"e_um".equals(relacao.getTipoRelacao())) {
	                     			return false;
	                     		}
	                     	}
	                     	
	                     //se for do tipo tem irá verificar se tem pelo menos um "tem"
	                     }else if(segundoVertice.getTipoRelacao().equals("tem")) {
	                    	 int i=0;
	                    	 
	                    	 if(relacoes.size() == 2) {
	                    		 if(!"tem".equals(relacoes.get(1).getTipoRelacao())) {
	                    			 return false;
	                    		 }
	                    	 }else {
	                    		 for(i=0;i<relacoes.size();i++) {
		                    		 if("tem".equals(relacoes.get(i).getTipoRelacao())) {
		                    			 break;
		                    		 }
		                    	 }
	 	                     	if(i==relacoes.size()-1) {
	 	                     		return false;
	 	                     	}
	                    	 }

	                     	
	                     //para os demais tipos irá verificar se a relação só aparece uma vez
	                     }else {
	                    	for(Vertice relacao:relacoes) {
	                    		if(segundoVertice.getTipoRelacao().equals(relacao.getTipoRelacao())) {
	                    			//contador de vezes que aparece a relacao
	                    			regraRelacao++;
	                    		}
	                    	}
	                     	if(regraRelacao!=1) {
	                     		return false;
	                     	}
	                     }
	                }
	                //se passado todas condicoes então inferencia é verdadeira
	                return true;
	            }
	            
	            //marca vertice como visitado
	            if (!visitados.contains(vertice)) {
	                visitados.add(vertice);
	                
	                //se chegado ao vertice folha e ainda não encontrou solucao, a lista de relacoes é limpa
	                if(grafo.getListAdjacencia(vertice.getValor()).isEmpty()) {
	                	relacoes.clear();
	                }
	                //empilha cada vertice adjacente
	                for (Vertice v : grafo.getListAdjacencia(vertice.getValor())) {                 
	                	stack.push(v);
	                }
	            }
	        }
	        return false;
	    } 
}