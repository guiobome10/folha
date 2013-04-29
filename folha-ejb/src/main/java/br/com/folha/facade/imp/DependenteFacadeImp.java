package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.DependenteDAO;
import br.com.folha.entity.Dependente;
import br.com.folha.entity.Funcionario;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.DependenteFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="DependenteFacade")
public class DependenteFacadeImp implements DependenteFacade {

	@EJB
	private DependenteDAO dao;
	
	@Override
	public Dependente inserir(Dependente dependente) throws AppException {
		TrataErro.trataParametroNull(dependente, TipoOperacao.INSERCAO);
		return dao.inserir(dependente);
	}
	
	@Override
	public Dependente alterar(Dependente dependente) throws AppException {
		TrataErro.trataParametroNull(dependente, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(dependente.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(dependente.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(dependente);
	}
	
	@Override
	public void excluir(Dependente dependente) throws AppException {
		TrataErro.trataParametroNull(dependente, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(dependente.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(dependente.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(dependente);
	}

	@Override
	public List<Dependente> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public Dependente consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}

	@Override
	public List<Dependente> listarPorFuncionario(Funcionario funcionario) throws AppException{
		return dao.listarPorFuncionario(funcionario);
	}
}
