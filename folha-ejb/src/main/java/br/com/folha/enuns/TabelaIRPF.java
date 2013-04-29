package br.com.folha.enuns;

public enum TabelaIRPF {
	 
	IRPF_FAIXA_ISENTA_2013(1710.78, 0.00, 0.00, 0.00), IRPF_FAIXA1_2013(2563.91, 0.075, 128.31, 171.97), IRPF_FAIXA2_2013(3418.59, 0.15, 320.60, 171.97), IRPF_FAIXA3_2013(4271.58, 0.225, 577.00, 171.97), IRPF_FAIXA_MAXIMA_2013(Double.MAX_VALUE, 0.275, 790.58, 171.97);
	
	private Double limite;
	private Double aliquota;
	private Double deducao;
	private Double deducaoPorDependente;
	
	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}

	public Double getValor() {
		return aliquota;
	}

	public void setValor(Double aliquota) {
		this.aliquota = aliquota;
	}

	TabelaIRPF(Double limite, Double aliquota, Double deducao, Double deducaoPorDependente){
		this.limite = limite;
		this.aliquota = aliquota;
		this.deducao = deducao;
		this.deducaoPorDependente = deducaoPorDependente;
	}

	public Double getDeducao() {
		return deducao;
	}

	public void setDeducao(Double deducao) {
		this.deducao = deducao;
	}

	public Double getDeducaoPorDependente() {
		return deducaoPorDependente;
	}

	public void setDeducaoPorDependente(Double deducaoPorDependente) {
		this.deducaoPorDependente = deducaoPorDependente;
	}
	
	
}
