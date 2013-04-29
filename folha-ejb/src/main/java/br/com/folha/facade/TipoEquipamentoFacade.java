package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.TipoEquipamento;
import br.com.folha.exception.AppException;

@Local
public interface TipoEquipamentoFacade {

	public abstract TipoEquipamento inserir(TipoEquipamento tipoEquipamento) throws AppException;
	
	public abstract TipoEquipamento alterar(TipoEquipamento tipoEquipamento) throws AppException;

	public abstract void excluir(TipoEquipamento tipoEquipamento) throws AppException;
	
	public abstract List<TipoEquipamento> listar() throws AppException;
	
	public abstract TipoEquipamento consultar(Long id) throws AppException;

}
