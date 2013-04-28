package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.TipoPagamentoFuncionario;
import br.com.folha.exception.AppException;

@Local
public interface TipoPagamentoFuncionarioFacade {

	public abstract TipoPagamentoFuncionario inserir(TipoPagamentoFuncionario tipoPagamentoFuncionario) throws AppException;
	
	public abstract TipoPagamentoFuncionario alterar(TipoPagamentoFuncionario tipoPagamentoFuncionario) throws AppException;

	public abstract void excluir(TipoPagamentoFuncionario tipoPagamentoFuncionario) throws AppException;
	
	public abstract List<TipoPagamentoFuncionario> listar() throws AppException;
	
	public abstract TipoPagamentoFuncionario consultar(Long id) throws AppException;

}
