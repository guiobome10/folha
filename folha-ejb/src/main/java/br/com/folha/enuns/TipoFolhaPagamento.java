package br.com.folha.enuns;

import java.util.ArrayList;
import java.util.List;

public enum TipoFolhaPagamento {

	ADIANTAMENTO("Adiantamento"), 
	PAGAMENTO("Pagamento"),
	PRIMEIRA_PARCELA_13("Primeira parcela 13º"), 
	SEGUNDA_PARCELA_13("Segunda parcela 13º"); 

	private String descricao;

	private TipoFolhaPagamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static List<TipoFolhaPagamento> getAsList(){
		List<TipoFolhaPagamento> lista = new ArrayList<TipoFolhaPagamento>();
		for(int i = 0; i < TipoFolhaPagamento.values().length; i++){
			lista.add(TipoFolhaPagamento.values()[i]);
		}
		return lista;
	}

}
