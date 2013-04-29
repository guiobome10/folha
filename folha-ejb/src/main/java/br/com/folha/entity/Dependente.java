package br.com.folha.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="DEPENDENTE")
@NamedQuery(name="Dependente.listarPorFuncionario", query="SELECT d FROM Dependente d WHERE d.funcionario = :funcionario")
public class Dependente {

	public static final String LISTAR_POR_FUNCIONARIO = "Dependente.listarPorFuncionario";
	
	@Id
	@Column(name="DPD_ID", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="DPD_NOME", nullable=false)
	private String nome;
	
	@Column(name="DPD_SEXO", nullable=false)
	private char sexo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DPD_DATA_NASCIMENTO", nullable = false)
	private Date dataNascimento;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private GrauParentesco grauParentesco;

	@Column(name="DPD_SALARIO_FAMILIA", nullable=false)
	private boolean salarioFamilia;

	@Column(name="DPD_IMPOSTO_RENDA", nullable=false)
	private boolean impostoRenda;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private CondicaoDependente condicaoDependente;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private Funcionario funcionario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public GrauParentesco getGrauParentesco() {
		return grauParentesco;
	}

	public void setGrauParentesco(GrauParentesco grauParentesco) {
		this.grauParentesco = grauParentesco;
	}

	public boolean isSalarioFamilia() {
		return salarioFamilia;
	}

	public void setSalarioFamilia(boolean salarioFamilia) {
		this.salarioFamilia = salarioFamilia;
	}

	public boolean isImpostoRenda() {
		return impostoRenda;
	}

	public void setImpostoRenda(boolean impostoRenda) {
		this.impostoRenda = impostoRenda;
	}

	public CondicaoDependente getCondicaoDependente() {
		return condicaoDependente;
	}

	public void setCondicaoDependente(CondicaoDependente condicaoDependente) {
		this.condicaoDependente = condicaoDependente;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public int hashCode() {
		return getId().intValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Dependente){
			return ((Dependente)obj).getId().equals(getId());
		}
		return false;
	}

}
