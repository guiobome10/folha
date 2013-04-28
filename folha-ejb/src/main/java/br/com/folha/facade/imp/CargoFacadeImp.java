package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.CargoDAO;
import br.com.folha.entity.Cargo;
import br.com.folha.entity.Departamento;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.CargoFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="CargoFacade")
public class CargoFacadeImp implements CargoFacade {

	@EJB
	private CargoDAO dao;
	
	@Override
	public Cargo inserir(Cargo cargo) throws AppException {
		TrataErro.trataParametroNull(cargo, TipoOperacao.INSERCAO);
		return dao.inserir(cargo);
	}
	
	@Override
	public Cargo alterar(Cargo cargo) throws AppException {
		TrataErro.trataParametroNull(cargo, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(cargo.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(cargo.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(cargo);
	}
	
	@Override
	public void excluir(Cargo cargo) throws AppException {
		TrataErro.trataParametroNull(cargo, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(cargo.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(cargo.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(cargo);
	}

	@Override
	public List<Cargo> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public Cargo consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}

	@Override
	public List<Cargo> listarCargosPorDepartamento(Departamento departamento) throws AppException{
		TrataErro.trataParametroNull(departamento, TipoOperacao.LISTAGEM);
		TrataErro.trataParametroNull(departamento.getId(), TipoOperacao.LISTAGEM);
		TrataErro.trataIdZerado(departamento.getId(), TipoOperacao.LISTAGEM);
		return dao.listarCargosPorDepartamento(departamento);
	}
	
}
