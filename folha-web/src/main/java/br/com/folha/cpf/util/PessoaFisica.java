package br.com.folha.cpf.util;



public class PessoaFisica {

	private String cpf;
	private String nome;
	private String situacaoCadastral;
	private Integer digitoVerificador;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSituacaoCadastral() {
		return situacaoCadastral;
	}
	public void setSituacaoCadastral(String situacaoCadastral) {
		this.situacaoCadastral = situacaoCadastral;
	}
	public Integer getDigitoVerificador() {
		return digitoVerificador;
	}
	public void setDigitoVerificador(Integer digitoVerificador) {
		this.digitoVerificador = digitoVerificador;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("cpf: " + cpf);
		builder.append("\n");
		builder.append("nome: " + nome);
		builder.append("\n");
		builder.append("situação cadastral: " + situacaoCadastral);
		builder.append("\n");
		builder.append("digito verificador: " + digitoVerificador);
		
		return builder.toString();
	}
}
