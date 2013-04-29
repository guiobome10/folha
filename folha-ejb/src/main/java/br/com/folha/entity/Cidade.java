package br.com.folha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="CIDADE")
@NamedQuery(name="Cidade.listarCidadesPorEstado", query="SELECT c FROM Cidade c WHERE c.estado = :estado ORDER BY c.nome")
public class Cidade {
	
	public static final String LISTAR_POR_ESTADO = "Cidade.listarCidadesPorEstado";
	
	@Id
	@Column(name="CID_ID", nullable=false, unique=true)
	private Long id;
	
	@Column(name="CID_NOME", nullable=false, length=40)
	private String nome;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private Estado estado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public void setId(Long id) {
		this.id = id;
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
		if (obj instanceof Cidade)
			return ((Cidade)obj).getId().equals(getId());
		return false;
	}

}
