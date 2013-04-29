package br.com.folha.facade;

import javax.ejb.Local;

import br.com.folha.entity.Endereco;
import br.com.folha.exception.AppException;

@Local
public interface EnderecoFacade {

	Endereco consultarCep(String cep, String caminho) throws AppException;

}
