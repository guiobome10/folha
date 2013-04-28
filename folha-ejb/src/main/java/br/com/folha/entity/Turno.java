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
@Table(name="TURNO")
public class Turno {

	@Id
	@Column(name="TUR_ID", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="TUR_HORA_ENTRADA", nullable=false)
	@Temporal(TemporalType.TIME)
	private Date horaEntrada;

	@Column(name="TUR_HORA_SAIDA_ALMOCO", nullable=false)
	@Temporal(TemporalType.TIME)
	private Date horaSaidaAlmoco;
	
	@Column(name="TUR_HORA_RETORNO_ALMOCO", nullable=false)
	@Temporal(TemporalType.TIME)
	private Date horaRetornoAlmoco;
	
	@Column(name="TUR_HORA_SAIDA", nullable=false)
	@Temporal(TemporalType.TIME)
	private Date horaSaida;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private TipoJornada tipoJornada;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public Date getHoraSaidaAlmoco() {
		return horaSaidaAlmoco;
	}

	public void setHoraSaidaAlmoco(Date horaSaidaAlmoco) {
		this.horaSaidaAlmoco = horaSaidaAlmoco;
	}

	public Date getHoraRetornoAlmoco() {
		return horaRetornoAlmoco;
	}

	public void setHoraRetornoAlmoco(Date horaRetornoAlmoco) {
		this.horaRetornoAlmoco = horaRetornoAlmoco;
	}

	public Date getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(Date horaSaida) {
		this.horaSaida = horaSaida;
	}

	public TipoJornada getTipoJornada() {
		return tipoJornada;
	}

	public void setTipoJornada(TipoJornada tipoJornada) {
		this.tipoJornada = tipoJornada;
	}

	@Override
	public int hashCode() {
		return getId().intValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Turno){
			return ((Turno)obj).getId().equals(getId());
		}
		return false;
	}

	public String getAsString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.tipoJornada.getAsString());
		builder.append(" - ");
		builder.append(this.horaEntrada);
		builder.append(" - ");
		builder.append(this.horaSaidaAlmoco);
		builder.append(" - ");
		builder.append(this.horaRetornoAlmoco);
		builder.append(" - ");
		builder.append(this.horaSaida);
		return builder.toString();
	}
}
