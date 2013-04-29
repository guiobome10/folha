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
@Table(name="CONDICAO_AFASTAMENTO")
public class CondicaoAfastamento {

	@Id
	@Column(name="CAF_ID", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="CAF_DESCRICAO", nullable=false, unique=true, length=40)
	private String descricao;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="condicaoAfastamento")
	private List<Afastamento> afastamentos;

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

	public List<Afastamento> getAfastamentos() {
		return afastamentos;
	}

	public void setAfastamentos(List<Afastamento> afastamentos) {
		this.afastamentos = afastamentos;
	}
	
	@Override
	public int hashCode() {
		return getId().intValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CondicaoAfastamento){
			return ((CondicaoAfastamento)obj).getId().equals(getId());
		}
		return false;
	}

}
