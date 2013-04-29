package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.Equipamento;
import br.com.folha.exception.AppException;

@Local
public interface EquipamentoFacade {

	public abstract Equipamento inserir(Equipamento equipamento) throws AppException;
	
	public abstract Equipamento alterar(Equipamento equipamento) throws AppException;

	public abstract void excluir(Equipamento equipamento) throws AppException;
	
	public abstract List<Equipamento> listar() throws AppException;
	
	public abstract Equipamento consultar(Long id) throws AppException;

}
