package br.com.folha.entity;

public class Endereco {

	private Integer resultado;
	private String msgResultado;
	private String uf;
	private String cidade;
	private String bairro;
	private String tipoLogradouro;
	private String logradouro;
	
	public Integer getResultado() {
		return resultado;
	}
	public void setResultado(Integer resultado) {
		this.resultado = resultado;
	}
	public String getMsgResultado() {
		return msgResultado;
	}
	public void setMsgResultado(String msgResultado) {
		this.msgResultado = msgResultado;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getTipoLogradouro() {
		return tipoLogradouro;
	}
	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	@Override
	public String toString() {
		return "Resultado: " + resultado + "\n" +
				"Resultado texto: " + msgResultado + "\n" +
				"UF: " + uf + "\n" +
				"Cidade: " + cidade + "\n" +
				"Bairro: " + bairro + "\n" +
				"Tipo Logradouro: " + tipoLogradouro + "\n" +
				"Logradouro: " + logradouro;
	}
	

}
