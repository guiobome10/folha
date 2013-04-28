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
@Table(name="TIPO_JORNADA")
public class TipoJornada {

	@Id
	@Column(name="TJO_ID", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="TJO_DESCRICAO", nullable=false, length=50, unique=true)
	private String descricao;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="tipoJornada")
	private List<Turno> turnos;

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

	public List<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}
	
	@Override
	public int hashCode() {
		return getId().intValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TipoJornada){
			return ((TipoJornada)obj).getId().equals(getId());
		}
		return false;
	}

	public String getAsString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.descricao);
		return builder.toString();
	}
}
