package br.com.folha.dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import org.primefaces.model.SortOrder;

import br.com.folha.entity.Funcionario;

@Local
public interface FuncionarioDAO extends GenericDAO<Funcionario> {
	
	public List<Funcionario> listaFuncionariosLazy(int primeiroRegistro, int quantidadePagina, String campoOrdenacao,
			SortOrder ordenacao, Map<String, String> filtros);
	
	public List<Funcionario> listarPorNome(String nome);

}
