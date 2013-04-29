package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.NaturezaEmpresa;
import br.com.folha.exception.AppException;

@Local
public interface NaturezaEmpresaFacade {

	public abstract NaturezaEmpresa inserir(NaturezaEmpresa naturezaEmpresa) throws AppException;
	
	public abstract NaturezaEmpresa alterar(NaturezaEmpresa naturezaEmpresa) throws AppException;

	public abstract void excluir(NaturezaEmpresa naturezaEmpresa) throws AppException;
	
	public abstract List<NaturezaEmpresa> listar() throws AppException;
	
	public abstract NaturezaEmpresa consultar(Long id) throws AppException;

}
