package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.DeficienciaDAO;
import br.com.folha.entity.Deficiencia;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.DeficienciaFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="DeficienciaFacade")
public class DeficienciaFacadeImp implements DeficienciaFacade {

	@EJB
	private DeficienciaDAO dao;
	
	@Override
	public Deficiencia inserir(Deficiencia deficiencia) throws AppException {
		TrataErro.trataParametroNull(deficiencia, TipoOperacao.INSERCAO);
		return dao.inserir(deficiencia);
	}
	
	@Override
	public Deficiencia alterar(Deficiencia deficiencia) throws AppException {
		TrataErro.trataParametroNull(deficiencia, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(deficiencia.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(deficiencia.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(deficiencia);
	}
	
	@Override
	public void excluir(Deficiencia deficiencia) throws AppException {
		TrataErro.trataParametroNull(deficiencia, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(deficiencia.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(deficiencia.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(deficiencia);
	}

	@Override
	public List<Deficiencia> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public Deficiencia consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}

}
