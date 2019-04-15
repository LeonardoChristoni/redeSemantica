package redeSemantica;

public class Vertice {
	
	private String valor;
	private String tipoRelacao;
	
	public Vertice(String valor) {
		this.valor = valor;
	}
  
    public Vertice(String valor,String tipoRelacao){
	    this.valor = valor;
	    setTipoRelacao(tipoRelacao);
    }
  
    @Override
    public boolean equals(Object obj) {
        Vertice vertice = (Vertice) obj;
        return vertice.valor.equals(valor);
    }
    
	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
      
	public String getTipoRelacao() {
		return tipoRelacao;
	}
	
	public void setTipoRelacao(String tipoRelacao) {
		this.tipoRelacao = tipoRelacao;
	}
}
