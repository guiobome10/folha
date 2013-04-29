package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.Falta;
import br.com.folha.exception.AppException;

@Local
public interface FaltaFacade {

	Falta inserir(Falta falta) throws AppException;
	
	Falta alterar(Falta falta) throws AppException;

	void excluir(Falta falta) throws AppException;
	
	List<Falta> listar() throws AppException;
	
	Falta consultar(Long id) throws AppException;

}
