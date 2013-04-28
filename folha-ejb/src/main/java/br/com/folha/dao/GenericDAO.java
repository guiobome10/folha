package br.com.folha.dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import org.primefaces.model.SortOrder;

@Local
@Stateless
public interface GenericDAO<T> {

	public T inserir(T entity);

	public void excluir(T entity);
	
	public T alterar(T entity);

	public T consultar(Long id);
	
	public List<T> listar() throws Exception;

	public T procurarRegistroUnico(String namedQuery,
			Map<String, Object> parameters) throws NoResultException, Exception;
	
	public List<T> procurarListaRegistros(String namedQuery,
			Map<String, Object> parameters);

	public Long count(T entidade);

	List<T> listarLazy(int primeiroRegistro, int quantidadePagina, String campoOrdenacao, SortOrder ordenacao, Map<String, String> filtros);
	
}