package br.com.folha.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="AFASTAMENTO")
public class Afastamento {

	@Id
	@Column(name="AFT_ID", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private Funcionario funcionario;

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private CondicaoAfastamento condicaoAfastamento;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private CausaAfastamento causaAfastamento;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DPD_DATA_INICIO", nullable = false)
	private Date dataInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DPD_DATA_TERMINO", nullable = false)
	private Date dataTermino;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public CondicaoAfastamento getCondicaoAfastamento() {
		return condicaoAfastamento;
	}

	public void setCondicaoAfastamento(CondicaoAfastamento condicaoAfastamento) {
		this.condicaoAfastamento = condicaoAfastamento;
	}

	public CausaAfastamento getCausaAfastamento() {
		return causaAfastamento;
	}

	public void setCausaAfastamento(CausaAfastamento causaAfastamento) {
		this.causaAfastamento = causaAfastamento;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}
	
	@Override
	public int hashCode() {
		return getId().intValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Afastamento)
			return ((Afastamento)obj).getId().equals(getId());
		return false;
	}

}
