package br.com.folha.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="NATUREZA_EMPRESA")
public class NaturezaEmpresa {

	@Id
	@Column(name="NEM_ID", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NEM_DESCRICAO", nullable=false, unique=true, length=70)
	private String descricao;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="naturezaEmpresa")
	private List<Empresa> empresas;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
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
		if (obj instanceof NaturezaEmpresa)
			return ((NaturezaEmpresa)obj).getId().equals(getId());
		return false;
	}

	public boolean isSindicato(){
		if(this.id == null) return false;
		return this.id.equals(new Long(3131));
	}
}
