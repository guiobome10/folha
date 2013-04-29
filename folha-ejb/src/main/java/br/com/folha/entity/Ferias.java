package br.com.folha.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.folha.enuns.PeriodoAquisitivo;

@Entity
@Table(name="FERIAS")
public class Ferias {

	@Id
	@Column(name="FER_ID", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name="FER_DATA_INICIO", nullable=false)
	private Date dataInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name="FER_DATA_TERMINO", nullable=false)
	private Date dataTermino;

	@Column(name="FER_QUANTIDADE_FALTAS", nullable=false)
	private Integer quantidadeFaltas;
	
	@Column(name="FER_ADIANTAMENTO_DECIMO_TERCEIRO", nullable=false)
	private boolean adiantamentoDecimoTerceiro;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="FER_PERIODO_AQUISITIVO", nullable=false)
	private PeriodoAquisitivo periodoAquisitivo;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private Funcionario funcionario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getQuantidadeFaltas() {
		return quantidadeFaltas;
	}

	public void setQuantidadeFaltas(Integer quantidadeFaltas) {
		this.quantidadeFaltas = quantidadeFaltas;
	}

	public boolean isAdiantamentoDecimoTerceiro() {
		return adiantamentoDecimoTerceiro;
	}

	public void setAdiantamentoDecimoTerceiro(boolean adiantamentoDecimoTerceiro) {
		this.adiantamentoDecimoTerceiro = adiantamentoDecimoTerceiro;
	}

	public PeriodoAquisitivo getPeriodoAquisitivo() {
		return periodoAquisitivo;
	}

	public void setPeriodoAquisitivo(PeriodoAquisitivo periodoAquisitivo) {
		this.periodoAquisitivo = periodoAquisitivo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	@Override
	public int hashCode() {
		return getId().intValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Ferias){
			return ((Ferias)obj).getId().equals(getId());
		}
		return false;
	}

}
