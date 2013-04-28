package br.com.folha.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ESTADO")
@NamedQuery(name="Estado.getBySigla", query="SELECT e FROM Estado e WHERE e.sigla = :sigla")
public class Estado {

	public static final String BUSCAR_POR_SIGLA = "Estado.getBySigla";
	
	@Id
	@Column(name="EST_SIGLA", nullable=false, unique=true, length=2)
	private String sigla;
	
	@Column(name="EST_NOME", nullable=false, unique=true, length=20)
	private String nome;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="estado")
	private List<Cidade> cidades;
	
	public Estado(String sigla) {
		this.sigla = sigla;
	}

	public Estado() {
		this.sigla = "PR";
		this.nome = "Paraná";
	}
	
	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	
	@Override
	public int hashCode() {
		return getSigla().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Estado)
			return ((Estado)obj).getSigla().equals(getSigla());
		return false;
	}

}
