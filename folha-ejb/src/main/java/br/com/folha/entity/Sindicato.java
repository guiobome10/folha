package br.com.folha.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SINDICATO")
public class Sindicato {

	@Id
	@Column(name="SIN_ID", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="SIN_CNPJ", nullable=false, length=14, unique=true)
	private String cnpj;
	
	@Column(name="SIN_CODIGO_SINDICAL", nullable=false, length=12, unique=true)
	private Long codigoSindical;
	
	@Column(name="SIN_RAZAO_SOCIAL", nullable=false)
	private String razaoSocial;

	@Column(name="SIN_TELEFONE", nullable=false, length=10)
	private String telefone;
	
	@Column(name="SIN_CEP", nullable=false, length=8)
	private String cep;
	
	@Column(name="SIN_ENDERECO", nullable=false, length=80)
	private String endereco;
	
	@Column(name="SIN_COMPLEMENTO", nullable=false, length=30)
	private String complemento;
	
	@Column(name="SIN_NUMERO", nullable=false)
	private Integer numero;
	
	@Column(name="SIN_BAIRRO", nullable=false, length=60)
	private String bairro;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private Estado estado;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private Cidade cidade;
		
	@Column(name="SIN_MES_DISSIDIO", nullable=false)
	private Integer mesDissidio;
	
	@Column(name="SIN_MINIMO_CATEGORIA", nullable=false)
	private BigDecimal minimoCategoria;
	
	@Column(name="SIN_PERCENTUAL_REVERSAO", nullable=false)
	private Double percentualReversao;
	
	@Column(name="SIN_DESCONTO_MINIMO", nullable=false)
	private BigDecimal descontoMinimo;
	
	@Column(name="SIN_DESCONTO_MAXIMO", nullable=false)
	private BigDecimal descontoMaximo;
	
	@Column(name="SIN_VALOR_CONTRIBUICAO", nullable=false)
	private BigDecimal valorContribuicao;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="sindicato")
	private List<Departamento> departamentos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Long getCodigoSindical() {
		return codigoSindical;
	}

	public void setCodigoSindical(Long codigoSindical) {
		this.codigoSindical = codigoSindical;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Integer getMesDissidio() {
		return mesDissidio;
	}

	public void setMesDissidio(Integer mesDissidio) {
		this.mesDissidio = mesDissidio;
	}

	public BigDecimal getMinimoCategoria() {
		return minimoCategoria;
	}

	public void setMinimoCategoria(BigDecimal minimoCategoria) {
		this.minimoCategoria = minimoCategoria;
	}

	public Double getPercentualReversao() {
		return percentualReversao;
	}

	public void setPercentualReversao(Double percentualReversao) {
		this.percentualReversao = percentualReversao;
	}

	public BigDecimal getDescontoMinimo() {
		return descontoMinimo;
	}

	public void setDescontoMinimo(BigDecimal descontoMinimo) {
		this.descontoMinimo = descontoMinimo;
	}

	public BigDecimal getDescontoMaximo() {
		return descontoMaximo;
	}

	public void setDescontoMaximo(BigDecimal descontoMaximo) {
		this.descontoMaximo = descontoMaximo;
	}

	public BigDecimal getValorContribuicao() {
		return valorContribuicao;
	}

	public void setValorContribuicao(BigDecimal valorContribuicao) {
		this.valorContribuicao = valorContribuicao;
	}

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		return getId().intValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Sindicato){
			return ((Sindicato)obj).getId().equals(getId());
		}
		
		return false;
	}

}
