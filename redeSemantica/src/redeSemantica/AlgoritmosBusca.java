package redeSemantica;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class AlgoritmosBusca {
	
	 static Set<String> buscaProfundidade(Grafo grafo, String root) {
	        Set<String> visited = new LinkedHashSet<String>();
	        Stack<String> stack = new Stack<String>();
	        stack.push(root);
	        while (!stack.isEmpty()) {
	            String Vertice = stack.pop();
	            if (!visited.contains(Vertice)) {
	                visited.add(Vertice);
	                for (Vertice v : grafo.getAdjVertices(Vertice)) {              
	                    stack.push(v.valor);
	                }
	            }
	        }
	        return visited;
	    }

	    static Set<String> buscaLargura(Grafo grafo, String root) {
	        Set<String> visited = new LinkedHashSet<String>();
	        Queue<String> queue = new LinkedList<String>();
	        queue.add(root);
	        visited.add(root);
	        while (!queue.isEmpty()) {
	            String Vertice = queue.poll();
	            for (Vertice v : grafo.getAdjVertices(Vertice)) {
	                if (!visited.contains(v.valor)) {
	                    visited.add(v.valor);
	                    queue.add(v.valor);
	                }
	            }
	        }
	        return visited;
	    }
}
