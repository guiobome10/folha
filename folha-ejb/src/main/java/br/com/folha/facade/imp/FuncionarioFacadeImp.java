package br.com.folha.facade.imp;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.primefaces.model.SortOrder;

import br.com.folha.dao.FuncionarioDAO;
import br.com.folha.entity.Funcionario;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.FuncionarioFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="FuncionarioFacade")
public class FuncionarioFacadeImp implements FuncionarioFacade {

	@EJB
	private FuncionarioDAO dao;
	
	@Override
	public Funcionario inserir(Funcionario funcionario) throws AppException {
		TrataErro.trataParametroNull(funcionario, TipoOperacao.INSERCAO);
		return dao.inserir(funcionario);
	}
	
	@Override
	public Funcionario alterar(Funcionario funcionario) throws AppException {
		TrataErro.trataParametroNull(funcionario, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(funcionario.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(funcionario.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(funcionario);
	}
	
	@Override
	public void excluir(Funcionario funcionario) throws AppException {
		TrataErro.trataParametroNull(funcionario, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(funcionario.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(funcionario.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(funcionario);
	}

	@Override
	public List<Funcionario> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public Funcionario consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}

	@Override
	public List<Funcionario> listarLazy(int primeiroRegistro, int quantidadePagina, String campoOrdenacao, SortOrder ordenacao, Map<String, String> filtros) throws AppException {
		return dao.listaFuncionariosLazy(primeiroRegistro, quantidadePagina, campoOrdenacao, ordenacao, filtros);
	}

	@Override
	public Long listarLazyCount() throws AppException {
		return dao.count(new Funcionario());
	}

	@Override
	public List<Funcionario> listarFuncionarioPorNome(String nome)
			throws AppException {
		return dao.listarPorNome(nome);
	}
	
}
