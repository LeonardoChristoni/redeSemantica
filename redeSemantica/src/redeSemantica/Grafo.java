package redeSemantica;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grafo {
	private Map<Vertice, List<Vertice>> listaAdj;

	Grafo() {
        this.listaAdj = new HashMap<Vertice, List<Vertice>>();
    }

    void adicionarVertice(String valor) {
    	listaAdj.putIfAbsent(new Vertice(valor), new ArrayList<>());
    }
  
    void removerVertice(String label) {
    	Vertice v = new Vertice(label);
    	listaAdj.values().stream().map(e -> e.remove(v)).collect(Collectors.toList());
    	listaAdj.remove(new Vertice(label));
    }

    void criarAresta(String primeiroVertice, String segundoVertice) {
    	Vertice v1 = new Vertice(primeiroVertice);
    	Vertice v2 = new Vertice(segundoVertice);
    	listaAdj.get(v1).add(v2);
    	listaAdj.get(v2).add(v1);
    }

    void removerAresta(String primeiroVertice, String segundoVertice) {
    	Vertice v1 = new Vertice(primeiroVertice);
    	Vertice v2 = new Vertice(segundoVertice);
        List<Vertice> eV1 = listaAdj.get(v1);
        List<Vertice> eV2 = listaAdj.get(v2);
        
        try{
    	   eV1.remove(v2);
    	   eV2.remove(v1);
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }

    List<Vertice> getAdjVertices(String vertice) {
        return listaAdj.get(new Vertice(vertice));
    }
    
    String exibirGrafo() {
        StringBuffer print = new StringBuffer();
        for(Vertice v : listaAdj.keySet()) {
            print.append(v);
            print.append(listaAdj.get(v));
        }
        return print.toString();
    }
}