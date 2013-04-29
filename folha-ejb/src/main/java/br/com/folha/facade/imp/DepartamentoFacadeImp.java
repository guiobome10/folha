package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.DepartamentoDAO;
import br.com.folha.entity.Departamento;
import br.com.folha.entity.Sindicato;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.DepartamentoFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="DepartamentoFacade")
public class DepartamentoFacadeImp implements DepartamentoFacade {

	@EJB
	private DepartamentoDAO dao;
	
	@Override
	public Departamento inserir(Departamento departamento) throws AppException {
		TrataErro.trataParametroNull(departamento, TipoOperacao.INSERCAO);
		return dao.inserir(departamento);
	}
	
	@Override
	public Departamento alterar(Departamento departamento) throws AppException {
		TrataErro.trataParametroNull(departamento, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(departamento.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(departamento.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(departamento);
	}
	
	@Override
	public void excluir(Departamento departamento) throws AppException {
		TrataErro.trataParametroNull(departamento, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(departamento.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(departamento.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(departamento);
	}

	@Override
	public List<Departamento> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public Departamento consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}

	@Override
	public List<Departamento> listarDepartamentosPorSindicato(
			Sindicato sindicato) throws AppException {
		TrataErro.trataParametroNull(sindicato, TipoOperacao.LISTAGEM);
		TrataErro.trataParametroNull(sindicato.getId(), TipoOperacao.LISTAGEM);
		TrataErro.trataIdZerado(sindicato.getId(), TipoOperacao.LISTAGEM);
		return dao.listarDepartamentosPorSindicato(sindicato);
	}

}
