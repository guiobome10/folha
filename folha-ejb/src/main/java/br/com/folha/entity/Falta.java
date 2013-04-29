package br.com.folha.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.folha.enuns.TipoFalta;

@Entity
@Table(name="FALTAS")
public class Falta {

	@Id
	@Column(name="FAL_ID", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name="FAL_DATA", nullable=false)
	private Date data;
	
	@JoinColumn(name="FAL_FUNCIONARIO", nullable=false)
	@ManyToOne(optional=false)
	private Funcionario funcionario;
	
	@Enumerated(EnumType.STRING)
	@Column(name="FAL_TIPO_FALTA", nullable=false)
	private TipoFalta tipoFalta;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public TipoFalta getTipoFalta() {
		return tipoFalta;
	}
	public void setTipoFalta(TipoFalta tipoFalta) {
		this.tipoFalta = tipoFalta;
	}
	@Override
	public int hashCode() {
		return getId().intValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Falta){
			return ((Falta)obj).getId().equals(getId());
		}
		return false;
	}

}
