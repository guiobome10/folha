package br.com.folha.enuns;

public enum TipoOperacao {

	INSERCAO('I', "Inserção"), ATUALIZACAO('A', "Atualização"), EXCLUSAO('E', "Excluir"), 
	CONSULTA('C', "Consulta"), LISTAGEM('L', "Listagem");

	private char tipoOperacao;
	private String value;

	private TipoOperacao(char tipoOperacao, String value) {
		this.tipoOperacao = tipoOperacao;
		this.value = value;
	}

	public char getTipoException() {
		return tipoOperacao;
	}

	public String getValue() {
		return value;
	}

	public void setTipoException(char tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
