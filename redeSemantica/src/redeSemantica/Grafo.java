package redeSemantica;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {
	private Map<String, List<Vertice>> listaAdjacencia;
	
	Grafo() {
        this.listaAdjacencia = new HashMap<String, List<Vertice>>();
    }

    void adicionarVertice(String valor) {
    	listaAdjacencia.putIfAbsent(valor, new ArrayList<>());
    }

    void criarAresta(String primeiroVertice, String segundoVertice, String tipoRelacao) {
    	listaAdjacencia.get(primeiroVertice).add(new Vertice(segundoVertice, tipoRelacao));
    }
    
    List<Vertice> getListAdjacencia(String vertice){
    	return listaAdjacencia.get(vertice);
    }
}