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
@Table(name="CAUSA_AFASTAMENTO")
public class CausaAfastamento {

	@Id
	@Column(name="CAU_ID", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="CAU_DESCRICAO", nullable=false, unique=true, length=30)
	private String descricao;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="causaAfastamento")
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
		if (obj instanceof CausaAfastamento){
			return ((CausaAfastamento)obj).getId().equals(getId());
		}
		return false;
	}

}
