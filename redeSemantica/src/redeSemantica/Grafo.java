package redeSemantica;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {
	private Map<String, List<Vertice>> listaAdjacencia = new HashMap<String, List<Vertice>>();

    void adicionarVertice(String valor) {
    	//é adicionado um novo hash(valor do vertice) se ainda não existir esse hash
    	listaAdjacencia.putIfAbsent(valor, new ArrayList<>());
    }

    void criarAresta(String primeiroVertice, String segundoVertice, String tipoRelacao) {
    	//busca o hash do primeiroVertice, retorna sua listaAdjacencia e adiciona um verticeAdjacente
    	listaAdjacencia.get(primeiroVertice).add(new Vertice(segundoVertice, tipoRelacao));
    }
    
    List<Vertice> getListAdjacencia(String vertice){
    	return listaAdjacencia.get(vertice);
    }
}