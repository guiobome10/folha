package br.com.folha.enuns;

import java.util.ArrayList;
import java.util.List;

public enum CodigoRecolhimento {

	COD_115(115L, "Recolhimento ao FGTS e informações é Previdência Social"),
	COD_130(130l, "Recolhimento ao FGTS e informações é Previdência Social relativas ao trabalhador avulso portuário"),
	COD_135(135L, "Recolhimento ao FGTS e informações é Previdência Social relativas ao trabalhador avulso não portuário"),
	COD_145(145L, "Recolhimento ao FGTS de diferenças apuradas pela CAIXA"),
	COD_150(150L, "Recolhimento ao FGTS e informações é Previdência Social de empresa prestadora de serviços com cessão de mão-de-obra e empresa de trabalho temporário (Lei nº 6.019/74), em relação aos empregados cedidos, ou de obra de construção civil é empreitada parcial"),
	COD_155(155L, "Recolhimento ao FGTS e informações é Previdência Social de obra de construção civil é empreitada total ou obra própria"),
	COD_211(211L, "Declaração para a Previdência Social de cooperativa de trabalho relativa aos contribuintes individuais cooperados que prestam serviços a tomadores"),
	COD_307(307L, "Recolhimento de Parcelamento do FGTS"),
	COD_317(317L, "Recolhimento de Parcelamento do FGTS de empresa com tomador de serviços"),
	COD_327(327L, "Recolhimento de Parcelamento de débito com o FGTS, priorizando os valores devidos aos trabalhadores"),
	COD_337(337L, "Recolhimento de Parcelamento de débito com o FGTS de empresas com tomador de serviços, priorizando os valores devidos aos trabalhadores"),
	COD_345(345L, "Recolhimento de parcelamento de débito com o FGTS relativo é diferenºa de recolhimento, priorizando os valores devidos aos trabalhadores"),
	COD_418(418L, "Recolhimento recursal para o FGTS"),
	COD_604(604L, "Recolhimento ao FGTS de entidades com fins filantrópicos é Decreto-Lei nº 194, de 24/02/1967 (competências anteriores a 10/1989)"),
	COD_608(608L, "Recolhimento ao FGTS e informações é Previdência Social relativos a dirigente sindical"),
	COD_640(640L, "Recolhimento ao FGTS para empregado não optante (competência anterior a 10/1988)"),
	COD_650(650L, "Recolhimento ao FGTS e informações é Previdência Social relativo a Anistiados, Reclamatória Trabalhista, Reclamatória Trabalhista com Reconhecimento de Vínculo, Acordo, Dissídio ou Convenção Coletiva, Comissão de Conciliação Prévia ou Núcleo Intersindical de Conciliação Trabalhista"),
	COD_660(660L, "Recolhimento exclusivo ao FGTS relativo a Anistiados, Conversão de Licenºa Sa�de em Acidente de Trabalho, Reclamatória Trabalhista, Acordo, Dissídio ou Convenção Coletiva, Comissão de Conciliação Prévia ou Núcleo Intersindical de Conciliação Trabalhista");
	
	private Long codigo;
	private String descricao;
	
	private CodigoRecolhimento(Long codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public String getDescricaoAbreviada() {
		if(descricao.length() < 60)
			return codigo + " - " + descricao.substring(0, descricao.length());
		return codigo + " - " + descricao.substring(0, 60);
	}
	
	public static List<CodigoRecolhimento> getAsList(){
		List<CodigoRecolhimento> lista = new ArrayList<CodigoRecolhimento>();
		for(int i = 0; i < CodigoRecolhimento.values().length; i++){
			lista.add(CodigoRecolhimento.values()[i]);
		}
		return lista;
	}
}
