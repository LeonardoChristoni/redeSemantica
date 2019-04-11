package redeSemantica;

public class Vertice {
	  String label;
      Vertice(String label) {
          this.label = label;
      }
      @Override
      public boolean equals(Object obj) {
          Vertice vertex = (Vertice) obj;
          return vertex.label == label;
      }
      @Override
      public int hashCode() {
          return label.hashCode();
      }
      @Override
      public String toString() {
          return label;
      }
}
