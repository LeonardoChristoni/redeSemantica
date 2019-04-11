package redeSemantica;

public class Vertice {
	  String valor;
      Vertice(String valor) {
          this.valor = valor;
      }
      @Override
      public boolean equals(Object obj) {
          Vertice vertice = (Vertice) obj;
          return vertice.valor == valor;
      }
      @Override
      public int hashCode() {
          return valor.hashCode();
      }
      @Override
      public String toString() {
          return valor;
      }
}
