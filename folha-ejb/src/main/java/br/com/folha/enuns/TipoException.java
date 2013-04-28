package br.com.folha.enuns;

public enum TipoException {

	INFO('I', "Info"), WARN('W', "Warn"), ERROR('E', "Error");

	private char tipoException;
	private String value;

	private TipoException(char tipoException, String value) {
		this.tipoException = tipoException;
		this.value = value;
	}

	public char getTipoException() {
		return tipoException;
	}

	public String getValue() {
		return value;
	}

	public void setTipoException(char tipoException) {
		this.tipoException = tipoException;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
