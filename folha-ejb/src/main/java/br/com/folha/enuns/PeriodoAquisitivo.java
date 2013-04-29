package br.com.folha.enuns;

public enum PeriodoAquisitivo {

	PROPORCIONAL('P', "Proporcional"), VENCIDO('V', "Vencido");
	
	private char sigla;
	private String valor;
	
	private PeriodoAquisitivo(char sigla, String valor){
		this.sigla = sigla;
		this.valor = valor;
	}

	public char getSigla() {
		return sigla;
	}

	public void setSigla(char sigla) {
		this.sigla = sigla;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
