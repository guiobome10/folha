package br.com.folha.datamodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.folha.entity.Funcionario;
import br.com.folha.exception.AppException;
import br.com.folha.facade.FuncionarioFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

public class FuncionarioDataModel extends LazyDataModel<Funcionario> {

	private static final long serialVersionUID = 4815354351266536529L;

	private FuncionarioFacade facade;
	
	@Override
	public List<Funcionario> load(int primeiroRegistro, int quantidadePagina, String campoOrdenacao,
			SortOrder ordenacao, Map<String, String> filtros) {
		try {
			facade = FacadeLocator.getService(FuncionarioFacade.class);
			this.setRowCount(facade.listarLazyCount().intValue());
			this.setPageSize(quantidadePagina);
			this.setRowIndex(primeiroRegistro);
			return facade.listarLazy(primeiroRegistro, quantidadePagina,  campoOrdenacao, ordenacao, filtros);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
			return new ArrayList<Funcionario>();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Funcionario>();
		}
	}

}
