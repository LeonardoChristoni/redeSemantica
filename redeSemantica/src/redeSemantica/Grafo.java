package redeSemantica;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {
	private Map<Vertice, List<VerticeAdjacente>> listaAdjacencia;

	Grafo() {
        this.listaAdjacencia = new HashMap<Vertice, List<VerticeAdjacente>>();
    }

    void adicionarVertice(String valor) {
    	listaAdjacencia.putIfAbsent(new Vertice(valor), new ArrayList<>());
    }

    void criarAresta(String primeiroVertice, String segundoVertice, String tipoRelacao) {
    	Vertice v1 = new Vertice(primeiroVertice);
    	Vertice v2 = new Vertice(segundoVertice);
    	listaAdjacencia.get(v1).add(new VerticeAdjacente(v2, tipoRelacao));
 //   	listaAdjacencia.get(v2).add(new VerticeAdjacente(v1, tipoRelacao));
    }

    List<VerticeAdjacente> getVerticesAdjacentes(String vertice,String tipoRelacao) {
    	Vertice v = new Vertice(vertice);
        VerticeAdjacente va = new VerticeAdjacente(v,tipoRelacao);
		return listaAdjacencia.get(va);
    }
    
    String exibirGrafo() {
        StringBuffer print = new StringBuffer();
        for(Vertice v : listaAdjacencia.keySet()) {
            print.append(v + "\n");
        }
        return print.toString();
    }
}