package br.com.folha.enuns;

public enum TabelaINSS {
	 
	INSS_FAIXA1_2013(1247.70, 0.08), INSS_FAMILIA_FAIXA2_2013(2079.50, 0.09), INSS_FAMILIA_FAIXA3_2013(4159.00, 0.11), INSS_FAMILIA_FAIXA_MAXIMA_2013(Double.MAX_VALUE, 457.49);
	
	private Double limite;
	private Double percentual;
	
	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}

	public Double getValor() {
		return percentual;
	}

	public void setValor(Double percentual) {
		this.percentual = percentual;
	}

	TabelaINSS(Double limite, Double percentual){
		this.limite = limite;
		this.percentual = percentual;
	}
	
	
}
