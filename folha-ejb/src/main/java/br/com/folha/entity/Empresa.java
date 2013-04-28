 package br.com.folha.entity;

import javax.persistence.*;

import br.com.folha.enuns.CodigoRecolhimento;

@Entity
@Table(name="EMPRESA")
public class Empresa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EMP_ID", nullable=false, unique=true)
	private Long id;
	
	@Column(name="EMP_CNPJ", nullable=false, unique=true, length=14)
	private String cnpj;
	
	@Column(name="EMP_RAZAO_SOCIAL", nullable=false, length=100)
	private String razaoSocial;
	
	@Column(name="EMP_INSCRICAO_ESTADUAL", nullable=false, length=14)
	private Long inscricaoEstadual;
	
	@Column(name="EMP_QTDE_SOCIOS", nullable=false, length=4)
	private Integer quantidadeSocios;
	
	@Column(name="EMP_TELEFONE", nullable=false, length=10)
	private String telefone;
	
	@Column(name="EMP_EMAIL", length=40)
	private String email;
	
	@Column(name="EMP_CEP", nullable=false, length=8)
	private String cep;
	
	@Column(name="EMP_ENDERECO", nullable=false, length=60)
	private String endereco;
	
	@Column(name="EMP_COMPLEMENTO", nullable=true, length=60)
	private String complemento;
	
	@Column(name="EMP_NUMERO", nullable=false, length=6)
	private Integer numero;
	
	@Column(name="EMP_BAIRRO", nullable=false, length=40)
	private String bairro;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private Estado estado;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private Cidade cidade;
	
	@Column(name="EMP_CEI", nullable=false)
	private Long cei;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private CategoriaEmpresa categoriaEmpresa;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private NaturezaEmpresa naturezaEmpresa;

	@Column(name="EMP_CNAE", nullable=false, length=10)
	private Long cnae;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private TipoFGTSEmpresa tipoFGTSEmpresa;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private Banco banco;

	@Column(name="EMP_AGENCIA_FGTS", nullable=false, precision=6)
	private Integer agenciaFGTS;
	
	@Column(name="EMP_CONTA_FGTS", nullable=false, precision=14)
	private Long contaFGTS;
	
	@Column(name="EMP_CPF_RESPONSAVEL", nullable=false, length=11)
	private String cpfResponsavel;
	
	@Column(name="EMP_NOME_RESPONSAVEL", nullable=false, length=60)
	private String nomeResponsavel;
	
	@Column(name="EMP_CEP_RESPONSAVEL", nullable=false, length=8)
	private String cepResponsavel;
	
	@Column(name="EMP_ENDERECO_RESPONSAVEL", nullable=false, length=60)
	private String enderecoResponsavel;
	
	@Column(name="EMP_NUMERO_RESPONSAVEL", nullable=false, precision=6)
	private Integer numeroResponsavel;
	
	@Column(name="EMP_BAIRRO_RESPONSAVEL", nullable=false, length=40)
	private String bairroResponsavel;

	@ManyToOne(fetch=FetchType.LAZY)
	private Estado estadoResponsavel;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Cidade cidadeResponsavel;

	@Column(name="EMP_CPF_RESPONSAVEL_ASSINATURA", nullable=false, length=11)
	private String cpfResponsavelAssinatura;
	
	@Column(name="EMP_NOME_RESPONSAVEL_ASSINATURA", nullable=false, length=60)
	private String nomeResponsavelAssinatura;
	
	@Column(name="EMP_PERCENTUAL_FPAS", nullable=false, scale=2, precision=5)
	private Double percentualFPAS;
	
	@Column(name="EMP_PERCENTUAL_TERCEIROS", nullable=false, scale=2, precision=5)
	private Double percentualTerceiros;
	
	@Column(name="EMP_PERCENTUAL_ACIDENTE_TRABALHO", nullable=false, scale=2, precision=5)
	private Double percentualAcidenteTrabalho;
	
	@Column(name="EMP_PERCENTUAL_FAP", nullable=false, scale=2, precision=5)
	private Double percentualFAP;
	
	@Column(name="EMP_PERCENTUAL_INSS_EMPREGADOR", nullable=false, scale=2, precision=3)
	private Double percentualINSSEmpregador;
	
	@Column(name="EMP_PERCENTUAL_ISENCAO_FILANTROPICA", nullable=false, scale=2, precision=5)
	private Double percentualIsencaoFilantropica;
	
	@Column(name="EMP_CODIGO_TERCEIROS", nullable=false, precision=10)
	private Long codigoTerceiros;
	
	@Column(name="EMP_CODIGO_GPS", nullable=false, precision=10)
	private Long codigoGPS;
	
	@Column(name="EMP_CODIGO_FPAS", nullable=false, precision=10)
	private Long codigoFPAS;
	
	@Column(name="EMP_ARREDONDAMENTO_MENSALISTA", nullable=false, scale=2, precision=3)
	private Double arredondamentoMensalista;
	
	@Column(name="EMP_ARREDONDAMENTO_HORISTA", nullable=false, scale=2, precision=3)
	private Double arredondamentoHorista;
	
	@Column(name="EMP_OPTANTE_ADIANTAMENTO", nullable=false)
	private boolean optanteAdiantamento;
	
	@Column(name="EMP_PERCENTUAL_ADIANTAMENTO", nullable=false, scale=2, precision=5)
	private Double percentualAdiantamento;

	@Enumerated(EnumType.STRING)
	@Column(name="EMP_CODIGO_RECOLHIMENTO", nullable=false)
	private CodigoRecolhimento codigoRecolhimento;
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public Long getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(Long inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public Integer getQuantidadeSocios() {
		return quantidadeSocios;
	}

	public void setQuantidadeSocios(Integer quantidadeSocios) {
		this.quantidadeSocios = quantidadeSocios;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Long getCei() {
		return cei;
	}

	public void setCei(Long cei) {
		this.cei = cei;
	}

	public CategoriaEmpresa getCategoriaEmpresa() {
		return categoriaEmpresa;
	}

	public void setCategoriaEmpresa(CategoriaEmpresa categoriaEmpresa) {
		this.categoriaEmpresa = categoriaEmpresa;
	}

	public NaturezaEmpresa getNaturezaEmpresa() {
		return naturezaEmpresa;
	}

	public void setNaturezaEmpresa(NaturezaEmpresa naturezaEmpresa) {
		this.naturezaEmpresa = naturezaEmpresa;
	}

	public Long getCnae() {
		return cnae;
	}

	public void setCnae(Long cnae) {
		this.cnae = cnae;
	}

	public TipoFGTSEmpresa getTipoFGTSEmpresa() {
		return tipoFGTSEmpresa;
	}

	public void setTipoFGTSEmpresa(TipoFGTSEmpresa tipoFGTSEmpresa) {
		this.tipoFGTSEmpresa = tipoFGTSEmpresa;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Integer getAgenciaFGTS() {
		return agenciaFGTS;
	}

	public void setAgenciaFGTS(Integer agenciaFGTS) {
		this.agenciaFGTS = agenciaFGTS;
	}

	public Long getContaFGTS() {
		return contaFGTS;
	}

	public void setContaFGTS(Long contaFGTS) {
		this.contaFGTS = contaFGTS;
	}

	public String getCpfResponsavel() {
		return cpfResponsavel;
	}

	public void setCpfResponsavel(String cpfResponsavel) {
		this.cpfResponsavel = cpfResponsavel;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getCepResponsavel() {
		return cepResponsavel;
	}

	public void setCepResponsavel(String cepResponsavel) {
		this.cepResponsavel = cepResponsavel;
	}

	public String getEnderecoResponsavel() {
		return enderecoResponsavel;
	}

	public void setEnderecoResponsavel(String enderecoResponsavel) {
		this.enderecoResponsavel = enderecoResponsavel;
	}

	public Integer getNumeroResponsavel() {
		return numeroResponsavel;
	}

	public void setNumeroResponsavel(Integer numeroResponsavel) {
		this.numeroResponsavel = numeroResponsavel;
	}

	public String getBairroResponsavel() {
		return bairroResponsavel;
	}

	public void setBairroResponsavel(String bairroResponsavel) {
		this.bairroResponsavel = bairroResponsavel;
	}

	public Estado getEstadoResponsavel() {
		return estadoResponsavel;
	}

	public void setEstadoResponsavel(Estado estadoResponsavel) {
		this.estadoResponsavel = estadoResponsavel;
	}

	public Cidade getCidadeResponsavel() {
		return cidadeResponsavel;
	}

	public void setCidadeResponsavel(Cidade cidadeResponsavel) {
		this.cidadeResponsavel = cidadeResponsavel;
	}

	public String getCpfResponsavelAssinatura() {
		return cpfResponsavelAssinatura;
	}

	public void setCpfResponsavelAssinatura(String cpfResponsavelAssinatura) {
		this.cpfResponsavelAssinatura = cpfResponsavelAssinatura;
	}

	public String getNomeResponsavelAssinatura() {
		return nomeResponsavelAssinatura;
	}

	public void setNomeResponsavelAssinatura(String nomeResponsavelAssinatura) {
		this.nomeResponsavelAssinatura = nomeResponsavelAssinatura;
	}

	public Double getPercentualFPAS() {
		return percentualFPAS;
	}

	public void setPercentualFPAS(Double percentualFPAS) {
		this.percentualFPAS = percentualFPAS;
	}

	public Double getPercentualTerceiros() {
		return percentualTerceiros;
	}

	public void setPercentualTerceiros(Double percentualTerceiros) {
		this.percentualTerceiros = percentualTerceiros;
	}

	public Double getPercentualAcidenteTrabalho() {
		return percentualAcidenteTrabalho;
	}

	public void setPercentualAcidenteTrabalho(Double percentualAcidenteTrabalho) {
		this.percentualAcidenteTrabalho = percentualAcidenteTrabalho;
	}

	public Double getPercentualFAP() {
		return percentualFAP;
	}

	public void setPercentualFAP(Double percentualFAP) {
		this.percentualFAP = percentualFAP;
	}

	public Double getPercentualINSSEmpregador() {
		return percentualINSSEmpregador;
	}

	public void setPercentualINSSEmpregador(Double percentualINSSEmpregador) {
		this.percentualINSSEmpregador = percentualINSSEmpregador;
	}

	public Double getPercentualIsencaoFilantropica() {
		return percentualIsencaoFilantropica;
	}

	public void setPercentualIsencaoFilantropica(
			Double percentualIsencaoFilantropica) {
		this.percentualIsencaoFilantropica = percentualIsencaoFilantropica;
	}

	public Long getCodigoTerceiros() {
		return codigoTerceiros;
	}

	public void setCodigoTerceiros(Long codigoTerceiros) {
		this.codigoTerceiros = codigoTerceiros;
	}

	public Long getCodigoGPS() {
		return codigoGPS;
	}

	public void setCodigoGPS(Long codigoGPS) {
		this.codigoGPS = codigoGPS;
	}

	public Long getCodigoFPAS() {
		return codigoFPAS;
	}

	public void setCodigoFPAS(Long codigoFPAS) {
		this.codigoFPAS = codigoFPAS;
	}

	public Double getArredondamentoMensalista() {
		return arredondamentoMensalista;
	}

	public void setArredondamentoMensalista(Double arredondamentoMensalista) {
		this.arredondamentoMensalista = arredondamentoMensalista;
	}

	public Double getArredondamentoHorista() {
		return arredondamentoHorista;
	}

	public void setArredondamentoHorista(Double arredondamentoHorista) {
		this.arredondamentoHorista = arredondamentoHorista;
	}

	public boolean isOptanteAdiantamento() {
		return optanteAdiantamento;
	}

	public void setOptanteAdiantamento(boolean optanteAdiantamento) {
		this.optanteAdiantamento = optanteAdiantamento;
	}

	public Double getPercentualAdiantamento() {
		return percentualAdiantamento;
	}

	public void setPercentualAdiantamento(Double percentualAdiantamento) {
		this.percentualAdiantamento = percentualAdiantamento;
	}

	public CodigoRecolhimento getCodigoRecolhimento() {
		return codigoRecolhimento;
	}

	public void setCodigoRecolhimento(CodigoRecolhimento codigoRecolhimento) {
		this.codigoRecolhimento = codigoRecolhimento;
	}

	public Long getId() {
		return id;
	}
	
	@Override
	public int hashCode() {
		return getId().intValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Empresa){
			return ((Empresa)obj).getId().equals(getId());
		}
		
		return false;
	}
	
}
