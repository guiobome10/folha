package br.com.folha.dao.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import org.primefaces.model.SortOrder;

import br.com.folha.dao.FuncionarioDAO;
import br.com.folha.entity.Funcionario;

@Stateless(name="FuncionarioDAO")
public class FuncionarioDAOImp extends GenericDAOImp<Funcionario> implements FuncionarioDAO {

	public FuncionarioDAOImp() {
		super(Funcionario.class);
	}
	
	@Override
	public List<Funcionario> listaFuncionariosLazy(int primeiroRegistro, int quantidadePagina, String campoOrdenacao,
			SortOrder ordenacao, Map<String, String> filtros){
		return super.listarLazy(primeiroRegistro, quantidadePagina, campoOrdenacao, ordenacao, filtros);
	}

	@Override
	public List<Funcionario> listarPorNome(String nome) {
		Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("nome", nome + "%");    
		return super.procurarListaRegistros(Funcionario.LISTAR_POR_NOME, parametros);
	}

}
