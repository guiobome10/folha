package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.TipoFGTSEmpresa;
import br.com.folha.exception.AppException;

@Local
public interface TipoFGTSEmpresaFacade {

	public abstract TipoFGTSEmpresa inserir(TipoFGTSEmpresa tipoFGTSEmpresa) throws AppException;
	
	public abstract TipoFGTSEmpresa alterar(TipoFGTSEmpresa tipoFGTSEmpresa) throws AppException;

	public abstract void excluir(TipoFGTSEmpresa tipoFGTSEmpresa) throws AppException;
	
	public abstract List<TipoFGTSEmpresa> listar() throws AppException;
	
	public abstract TipoFGTSEmpresa consultar(Long id) throws AppException;

}
