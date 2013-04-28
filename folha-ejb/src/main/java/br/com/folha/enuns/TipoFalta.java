package br.com.folha.enuns;

import java.util.ArrayList;
import java.util.List;

public enum TipoFalta {

	JUSTIFICADA_COM_DESCONTO(1, "Justificada com desconto"), JUSTIFICADA_SEM_DESCONTO(2, "Justificada sem desconto")
	, ABONADA(3, "Abonada"), 
	SEM_JUSTIFICATIVA(4, "Sem justificava");

	private Integer codigo;
	private String descricao;

	private TipoFalta(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public static List<TipoFalta> getAsList(){
		List<TipoFalta> lista = new ArrayList<TipoFalta>();
		for(int i = 0; i < TipoFalta.values().length; i++){
			lista.add(TipoFalta.values()[i]);
		}
		return lista;
	}

}
