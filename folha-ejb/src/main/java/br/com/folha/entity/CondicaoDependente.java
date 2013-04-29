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
@Table(name="CONDICAO_DEPENDENTE")
public class CondicaoDependente {

	@Id
	@Column(name="CDE_ID", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="CDE_DESCRICAO", nullable=false, unique=true, length=40)
	private String descricao;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="condicaoDependente")
	private List<Dependente> dependentes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}

	@Override
	public int hashCode() {
		return getId().intValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CondicaoDependente){
			return ((CondicaoDependente)obj).getId().equals(getId());
		}
		return false;
	}

}
