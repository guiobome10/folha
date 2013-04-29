package br.com.folha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORIA_CNH")
@NamedQuery(name ="CategoriaCNH.consultarPorSigla", 
			query="SELECT c FROM CategoriaCNH c WHERE c.sigla = :sigla ORDER BY c.sigla")
public class CategoriaCNH {

	public static final String CONSULTAR_POR_SIGLA = "CategoriaCNH.consultarPorSigla";		
			
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CNH_ID", nullable=false, unique=true)
	private Long id;
	
	@Column(name="CNH_SIGLA", nullable=false, unique=true, length=2)
	private String sigla;
	
	@Column(name="CNH_DESCRICAO", nullable=false, unique=true, length=40)
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		return getId().intValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CategoriaCNH){
			return ((CategoriaCNH)obj).getId()==(getId());
		}
		return false;
	}

	public String getDescricaoConcatenada() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.sigla);
		builder.append(" - ");
		builder.append(this.descricao);
		return builder.toString();
	}
}
