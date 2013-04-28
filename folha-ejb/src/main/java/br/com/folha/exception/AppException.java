package br.com.folha.exception;

import br.com.folha.enuns.TipoException;


public class AppException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8095399321989525818L;

	private TipoException tipoException;

	public AppException(String messageDetail, Throwable throwable, TipoException tipoException) {
		super(messageDetail, throwable);
		this.tipoException = tipoException;
	}

	public AppException(String messageDetail, TipoException tipoException) {
		super(messageDetail);
		this.tipoException = tipoException;
	}

	public AppException(Throwable throwable, TipoException tipoException) {
		super(throwable);
		this.tipoException = tipoException;
	}

	public TipoException getTipoException() {
		return tipoException;
	}

	public void setTipoException(TipoException tipoException) {
		this.tipoException = tipoException;
	}

}
