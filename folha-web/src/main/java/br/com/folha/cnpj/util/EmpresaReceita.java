package br.com.folha.cnpj.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class EmpresaReceita {

	private String cnpj;
	private String matrizFilial;
	private Date dataAbertura;
	private String nomeEmpresarial;
	private String nomeFantasia;
	private String codigoAtividadePrincipal;
	private String descricaoAtividadePrincipal;
	private List<String> codigosAtividadesSecundarias;
	private List<String> descricoesAtividadesSecundarias;
	private String codigoNaturezaJuridica;
	private String descricaoNaturezaJuridica;
	private String logradouro;
	private Integer numero;
	private String complemento;
	private String cep;
	private String bairro;
	private String municipio;
	private String uf;
	private String situacaoCadastral;
	private Date dataSituacaoCadastral;
	private String motivoSituacaoCadastral;
	private String situacaoEspecial;
	private Date dataSituacaoEspecial;

	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getMatrizFilial() {
		return matrizFilial;
	}
	public void setMatrizFilial(String matrizFilial) {
		this.matrizFilial = matrizFilial;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public String getNomeEmpresarial() {
		return nomeEmpresarial;
	}
	public void setNomeEmpresarial(String nomeEmpresarial) {
		this.nomeEmpresarial = nomeEmpresarial;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getCodigoAtividadePrincipal() {
		return codigoAtividadePrincipal;
	}
	public void setCodigoAtividadePrincipal(String codigoAtividadePrincipal) {
		this.codigoAtividadePrincipal = codigoAtividadePrincipal;
	}
	public String getDescricaoAtividadePrincipal() {
		return descricaoAtividadePrincipal;
	}
	public void setDescricaoAtividadePrincipal(String descricaoAtividadePrincipal) {
		this.descricaoAtividadePrincipal = descricaoAtividadePrincipal;
	}
	public List<String> getCodigosAtividadesSecundarias() {
		return codigosAtividadesSecundarias;
	}
	public void setCodigosAtividadesSecundarias(
			List<String> codigosAtividadesSecundarias) {
		this.codigosAtividadesSecundarias = codigosAtividadesSecundarias;
	}
	public List<String> getDescricoesAtividadesSecundarias() {
		return descricoesAtividadesSecundarias;
	}
	public void setDescricoesAtividadesSecundarias(
			List<String> descricoesAtividadesSecundarias) {
		this.descricoesAtividadesSecundarias = descricoesAtividadesSecundarias;
	}
	public String getCodigoNaturezaJuridica() {
		return codigoNaturezaJuridica;
	}
	public void setCodigoNaturezaJuridica(String codigoNaturezaJuridica) {
		this.codigoNaturezaJuridica = codigoNaturezaJuridica;
	}
	public String getDescricaoNaturezaJuridica() {
		return descricaoNaturezaJuridica;
	}
	public void setDescricaoNaturezaJuridica(String descricaoNaturezaJuridica) {
		this.descricaoNaturezaJuridica = descricaoNaturezaJuridica;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getSituacaoCadastral() {
		return situacaoCadastral;
	}
	public void setSituacaoCadastral(String situacaoCadastral) {
		this.situacaoCadastral = situacaoCadastral;
	}
	public Date getDataSituacaoCadastral() {
		return dataSituacaoCadastral;
	}
	public void setDataSituacaoCadastral(Date dataSituacaoCadastral) {
		this.dataSituacaoCadastral = dataSituacaoCadastral;
	}
	public String getMotivoSituacaoCadastral() {
		return motivoSituacaoCadastral;
	}
	public void setMotivoSituacaoCadastral(String motivoSituacaoCadastral) {
		this.motivoSituacaoCadastral = motivoSituacaoCadastral;
	}
	public String getSituacaoEspecial() {
		return situacaoEspecial;
	}
	public void setSituacaoEspecial(String situacaoEspecial) {
		this.situacaoEspecial = situacaoEspecial;
	}
	public Date getDataSituacaoEspecial() {
		return dataSituacaoEspecial;
	}
	public void setDataSituacaoEspecial(Date dataSituacaoEspecial) {
		this.dataSituacaoEspecial = dataSituacaoEspecial;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("cnpj: " + cnpj);
		builder.append("\n");
		builder.append("matrizFilial: " + matrizFilial);
		builder.append("\n");
		builder.append("dataAbertura: " + (dataAbertura == null ? "" : new SimpleDateFormat("dd/MM/yyyy").format(dataAbertura)) );
		builder.append("\n");
		builder.append("nomeEmpresarial: " + nomeEmpresarial);
		builder.append("\n");
		builder.append("nomeFantasia: " + nomeFantasia);
		builder.append("\n");
		builder.append("codigoAtividadePrincipal: " + codigoAtividadePrincipal);
		builder.append("\n");
		builder.append("descricaoAtividadePrincipal: " + descricaoAtividadePrincipal);
		builder.append("\n");
		builder.append("codigosAtividadesSecundarias: ");
		for(String c : codigosAtividadesSecundarias){
			builder.append("\n");
			builder.append("[" + c + "]");
		}
		builder.append("\n");
		builder.append("descricoesAtividadesSecundarias: ");
		for(String d : descricoesAtividadesSecundarias){
			builder.append("\n");			
			builder.append("[" + d + "]");
		}
		builder.append("\n");
		builder.append("codigoNaturezaJuridica: " + codigoNaturezaJuridica);
		builder.append("\n");
		builder.append("descricaoNaturezaJuridica: " + descricaoNaturezaJuridica);
		builder.append("\n");
		builder.append("logradouro: " + logradouro);
		builder.append("\n");
		builder.append("numero: " + numero);
		builder.append("\n");
		builder.append("complemento: " + complemento);
		builder.append("\n");
		builder.append("cep: " + cep);
		builder.append("\n");
		builder.append("bairro: " + bairro);
		builder.append("\n");
		builder.append("municipio: " + municipio);
		builder.append("\n");
		builder.append("situacaoCadastral: " + situacaoCadastral);
		builder.append("\n");
		builder.append("dataSituacaoCadastral: " + (dataSituacaoCadastral == null ? "" : new SimpleDateFormat("dd/MM/yyyy").format(dataSituacaoCadastral)) );
		builder.append("\n");
		builder.append("motivoSituacaoCadastral: " + motivoSituacaoCadastral);
		builder.append("\n");
		builder.append("situacaoEspecial: " + situacaoEspecial);
		builder.append("\n");
		builder.append("dataSituacaoEspecial: " +  (dataSituacaoEspecial == null ? "" : new SimpleDateFormat("dd/MM/yyyy").format(dataSituacaoEspecial)) );
		
		return builder.toString();
	}
	
	public boolean isSindicato(){
		if(this.getCodigoNaturezaJuridica() == null) return false;
		return (this.getCodigoNaturezaJuridica().equals("3131"));
	}
}
