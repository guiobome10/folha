package br.com.folha.enuns;

public enum SalarioFamilia {
	 
	SALARIO_FAMILIA_FAIXA1_2013(646.55, 33.16), SALARIO_FAMILIA_FAIXA2_2013(971.78, 23.36);
	
	private Double limite;
	private Double valor;
	
	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	SalarioFamilia(Double limite, Double valor){
		this.limite = limite;
		this.valor = valor;
	}
}
