package br.com.folha.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="BANCO")
public class Banco {

	@Id
	@Column(name="BAN_COD", nullable=false, unique=true)
	private Long codigo;
	
	@Column(name="BAN_NOME", nullable=false, length=40)
	private String nome;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="banco")
	private List<Empresa> empresas;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="banco")
	private List<Funcionario> funcionarios;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public int hashCode() {
		return getCodigo().intValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Banco)
			return ((Banco)obj).getCodigo().equals(getCodigo());
		return false;
	}

}
