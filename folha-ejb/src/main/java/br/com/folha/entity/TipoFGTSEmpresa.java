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
@Table(name="TIPO_FGTS_EMPRESA")
public class TipoFGTSEmpresa {

	@Id
	@Column(name="TFE_ID", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="TFE_DESCRICAO", nullable=false, length=20)
	private String descricao;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="tipoFGTSEmpresa")
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
		if (obj instanceof TipoFGTSEmpresa)
			return ((TipoFGTSEmpresa)obj).getId().equals(getId());
		return false;
	}

}
