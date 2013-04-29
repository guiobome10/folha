package br.com.folha.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.Dependente;
import br.com.folha.entity.Funcionario;
import br.com.folha.exception.AppException;

@Local
public interface DependenteDAO extends GenericDAO<Dependente> {

	public List<Dependente> listarPorFuncionario(Funcionario funcionario) throws AppException;
	
}
