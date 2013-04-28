package br.com.folha.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="FUNCIONARIO")
@NamedQuery(name="Funcionario.listarPorNome", query="SELECT f FROM Funcionario f WHERE f.nome LIKE :nome ORDER BY f.nome" )
public class Funcionario {

	public static final String LISTAR_POR_NOME = "Funcionario.listarPorNome";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FUN_ID", nullable=false, unique=true)
	private Long id;

	@Lob
	@Column(name="FUN_FOTO")
	private byte[] foto;
	
	@Column(name="FUN_CPF", length=11, unique=true, nullable=false)
	private String cpf;
	
	@Column(name="FUN_NOME", length=50, nullable=false)
	private String nome;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private CategoriaFuncionario categoriaFuncionario;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private TipoPagamentoFuncionario tipoPagamentoFuncionario;
	
	@Column(name="FUN_TELEFONE",nullable=false, length=10)
	private String telefone;
	
	@Column(name="FUN_EMAIL",nullable=false, length=40)
	private String email;
	
	@Column(name="FUN_CEP",nullable=false, length=8)
	private String cep;
	
	@Column(name="FUN_ENDERECO",nullable=false, length=40)
	private String endereco;
	
	@Column(name="FUN_NUMERO",nullable=false, length=6)
	private Integer numero;
	
	@Column(name="FUN_COMPLEMENTO",nullable=false, length=30)
	private String complemento;
	
	@Column(name="FUN_BAIRRO",nullable=false, length=30)
	private String bairro;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private Estado estado;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private Cidade cidade;
	
	@Column(name="FUN_NUMERO_PIS",nullable=false, length=11)
	private Long numeroPIS;
	
	@Column(name="FUN_NUMERO_CTPS",nullable=false, length=8)
	private Integer numeroCTPS;
	
	@Column(name="FUN_SERIE_CTPS",nullable=false, length=5)
	private Integer serie;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Estado estadoCTPS;
	
	@Column(name="FUN_NUMERO_RG",nullable=false, length=9)
	private String rg;
	
	@Column(name="FUN_DATA_EMISSAO_RG",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dataEmissao;
	
	@Column(name="FUN_ORGAO_EMISSOR",nullable=false, length=6)
	private String orgaoEmissor;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Estado estadoRG;
	
	@Column(name="FUN_DATA_NASCIMENTO",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private Estado estadoNascimento;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private Cidade cidadeNascimento;
	
	@Column(name="FUN_NOME_MAE",nullable=false, length=50)
	private String nomeMae;
	
	@Column(name="FUN_NOME_PAI",nullable=false, length=50)
	private String nomePai;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private TipoExposicaoFuncionario tipoExposicaoFuncionario;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private TipoRaisFuncionario tipoRaisFuncionario;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private Empresa empresa;

	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private Cargo cargo;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private Turno turno;
	
	@Column(name="FUN_VALOR_SALARIO", nullable=false, scale=2, precision=10)
	private BigDecimal valorSalario;
	
	@Column(name="FUN_PERCENTUAL_PENSAO", nullable=false, scale=2, precision=5)
	private Double percentualPensao;
	
	@Column(name="FUN_PERCENTUAL_PERICULOSIDADE", nullable=false, scale=2, precision=5)
	private Double percentualPericulosidade;
	
	@Column(name="FUN_PERCENTUAL_INSALUBRIDADE", nullable=false, scale=2, precision=5)
	private Double percentualInsalubridade;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private BaseInsalubridadeFuncionario baseInsalubridadeFuncionario;
	
	@Column(name="FUN_VALE_TRANSPORTE", nullable=false)
	private boolean valeTransporte;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private EstadoCivil estadoCivil;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private Escolaridade escolaridade;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private Cor cor;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Deficiencia deficiencia;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private Nacionalidade nacionalidade;
	
	@Column(name="FUN_NUMERO_TITULO", precision=12)
	private Long numeroTitulo;
	
	@Column(name="FUN_NUMERO_ZONA_ELEITORAL", precision=3)
	private Integer numeroZonaEleitoral;
	
	@Column(name="FUN_NUMERO_SECAO_ELEITORAL", precision=4)
	private Integer secaoZonaEleitoral;
	
	@Column(name="FUN_NUMERO_CNH", precision=11)
	private Long numeroCNH;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private CategoriaCNH categoriaCNH;
	
	@Column(name="FUN_DATA_VENCIMENTO_CNH")
	@Temporal(TemporalType.DATE)
	private Date dataVencimentoCNH;
	
	@Column(name="FUN_COREN", length=10)
	private Long COREN;
	
	@ManyToMany
	@JoinTable(name="BENEFICIOS_DO_FUNCIONARIO", joinColumns = @JoinColumn(name="FUN_ID"), inverseJoinColumns = @JoinColumn(name="BEN_ID"))
	private List<Beneficio> beneficios;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Banco banco;
	
	@OneToMany(mappedBy="funcionario", fetch=FetchType.LAZY)
	private List<Dependente> dependentes;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="funcionario")
	private List<Ferias> ferias;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="funcionario")
	private List<FolhaPagamento> folhasPagamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public CategoriaFuncionario getCategoriaFuncionario() {
		return categoriaFuncionario;
	}

	public void setCategoriaFuncionario(CategoriaFuncionario categoriaFuncionario) {
		this.categoriaFuncionario = categoriaFuncionario;
	}

	public TipoPagamentoFuncionario getTipoPagamentoFuncionario() {
		return tipoPagamentoFuncionario;
	}

	public void setTipoPagamentoFuncionario(
			TipoPagamentoFuncionario tipoPagamentoFuncionario) {
		this.tipoPagamentoFuncionario = tipoPagamentoFuncionario;
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

	public Long getNumeroPIS() {
		return numeroPIS;
	}

	public void setNumeroPIS(Long numeroPIS) {
		this.numeroPIS = numeroPIS;
	}

	public Integer getNumeroCTPS() {
		return numeroCTPS;
	}

	public void setNumeroCTPS(Integer numeroCTPS) {
		this.numeroCTPS = numeroCTPS;
	}

	public Integer getSerie() {
		return serie;
	}

	public void setSerie(Integer serie) {
		this.serie = serie;
	}

	public Estado getEstadoCTPS() {
		return estadoCTPS;
	}

	public void setEstadoCTPS(Estado estadoCTPS) {
		this.estadoCTPS = estadoCTPS;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}

	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}

	public Estado getEstadoRG() {
		return estadoRG;
	}

	public void setEstadoRG(Estado estadoRG) {
		this.estadoRG = estadoRG;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Estado getEstadoNascimento() {
		return estadoNascimento;
	}

	public void setEstadoNascimento(Estado estadoNascimento) {
		this.estadoNascimento = estadoNascimento;
	}

	public Cidade getCidadeNascimento() {
		return cidadeNascimento;
	}

	public void setCidadeNascimento(Cidade cidadeNascimento) {
		this.cidadeNascimento = cidadeNascimento;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public TipoExposicaoFuncionario getTipoExposicaoFuncionario() {
		return tipoExposicaoFuncionario;
	}

	public void setTipoExposicaoFuncionario(
			TipoExposicaoFuncionario tipoExposicaoFuncionario) {
		this.tipoExposicaoFuncionario = tipoExposicaoFuncionario;
	}

	public TipoRaisFuncionario getTipoRaisFuncionario() {
		return tipoRaisFuncionario;
	}

	public void setTipoRaisFuncionario(TipoRaisFuncionario tipoRaisFuncionario) {
		this.tipoRaisFuncionario = tipoRaisFuncionario;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public BigDecimal getValorSalario() {
		return valorSalario;
	}

	public void setValorSalario(BigDecimal valorSalario) {
		this.valorSalario = valorSalario;
	}

	public Double getPercentualPensao() {
		return percentualPensao;
	}

	public void setPercentualPensao(Double percentualPensao) {
		this.percentualPensao = percentualPensao;
	}

	public Double getPercentualPericulosidade() {
		return percentualPericulosidade;
	}

	public void setPercentualPericulosidade(Double percentualPericulosidade) {
		this.percentualPericulosidade = percentualPericulosidade;
	}

	public Double getPercentualInsalubridade() {
		return percentualInsalubridade;
	}

	public void setPercentualInsalubridade(Double percentualInsalubridade) {
		this.percentualInsalubridade = percentualInsalubridade;
	}

	public BaseInsalubridadeFuncionario getBaseInsalubridadeFuncionario() {
		return baseInsalubridadeFuncionario;
	}

	public void setBaseInsalubridadeFuncionario(
			BaseInsalubridadeFuncionario baseInsalubridadeFuncionario) {
		this.baseInsalubridadeFuncionario = baseInsalubridadeFuncionario;
	}

	public boolean isValeTransporte() {
		return valeTransporte;
	}

	public void setValeTransporte(boolean valeTransporte) {
		this.valeTransporte = valeTransporte;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Escolaridade getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public Deficiencia getDeficiencia() {
		return deficiencia;
	}

	public void setDeficiencia(Deficiencia deficiencia) {
		this.deficiencia = deficiencia;
	}

	public Nacionalidade getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(Nacionalidade nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public Long getNumeroTitulo() {
		return numeroTitulo;
	}

	public void setNumeroTitulo(Long numeroTitulo) {
		this.numeroTitulo = numeroTitulo;
	}

	public Integer getNumeroZonaEleitoral() {
		return numeroZonaEleitoral;
	}

	public void setNumeroZonaEleitoral(Integer numeroZonaEleitoral) {
		this.numeroZonaEleitoral = numeroZonaEleitoral;
	}

	public Integer getSecaoZonaEleitoral() {
		return secaoZonaEleitoral;
	}

	public void setSecaoZonaEleitoral(Integer secaoZonaEleitoral) {
		this.secaoZonaEleitoral = secaoZonaEleitoral;
	}

	public Long getNumeroCNH() {
		return numeroCNH;
	}

	public void setNumeroCNH(Long numeroCNH) {
		this.numeroCNH = numeroCNH;
	}

	public CategoriaCNH getCategoriaCNH() {
		return categoriaCNH;
	}

	public void setCategoriaCNH(CategoriaCNH categoriaCNH) {
		this.categoriaCNH = categoriaCNH;
	}

	public Date getDataVencimentoCNH() {
		return dataVencimentoCNH;
	}

	public void setDataVencimentoCNH(Date dataVencimentoCNH) {
		this.dataVencimentoCNH = dataVencimentoCNH;
	}

	public Long getCOREN() {
		return COREN;
	}

	public void setCOREN(Long cOREN) {
		COREN = cOREN;
	}

	public List<Beneficio> getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(List<Beneficio> beneficios) {
		this.beneficios = beneficios;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public List<Ferias> getFerias() {
		return ferias;
	}

	public void setFerias(List<Ferias> ferias) {
		this.ferias = ferias;
	}
	
	public List<FolhaPagamento> getFolhasPagamento() {
		return folhasPagamento;
	}

	public void setFolhasPagamento(List<FolhaPagamento> folhasPagamento) {
		this.folhasPagamento = folhasPagamento;
	}

	@Override
	public int hashCode() {
		return getId().intValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Funcionario){
			return ((Funcionario)obj).getId().equals(getId());
		}
		return false;
	}

}
