package redeSemantica;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class AlgoritmosBusca {
	
	 static Set<String> depthFirstTraversal(Grafo graph, String root) {
	        Set<String> visited = new LinkedHashSet<String>();
	        Stack<String> stack = new Stack<String>();
	        stack.push(root);
	        while (!stack.isEmpty()) {
	            String Vertice = stack.pop();
	            if (!visited.contains(Vertice)) {
	                visited.add(Vertice);
	                for (Vertice v : graph.getAdjVertices(Vertice)) {              
	                    stack.push(v.label);
	                }
	            }
	        }
	        return visited;
	    }

	    static Set<String> breadthFirstTraversal(Grafo graph, String root) {
	        Set<String> visited = new LinkedHashSet<String>();
	        Queue<String> queue = new LinkedList<String>();
	        queue.add(root);
	        visited.add(root);
	        while (!queue.isEmpty()) {
	            String Vertice = queue.poll();
	            for (Vertice v : graph.getAdjVertices(Vertice)) {
	                if (!visited.contains(v.label)) {
	                    visited.add(v.label);
	                    queue.add(v.label);
	                }
	            }
	        }
	        return visited;
	    }
}
