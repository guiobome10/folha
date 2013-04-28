package br.com.folha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.folha.enuns.InformeRendimento;

@Entity
@Table(name="DESCONTO")
public class Desconto {

	@Id
	@Column(name="DSC_ID", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="DSC_DESCRICAO", nullable=false, unique=true, length=50)
	private String descricao;
	
	@Column(name="DSC_PERCENTUAL", precision=5, scale=2)
	private Double percentual;

	@Column(name="DSC_VALOR", precision=6, scale=2)
	private Double valor;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="DSC_INFORME_RENDIMENTO", nullable=false)
	private InformeRendimento informeRendimento;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public InformeRendimento getInformeRendimento() {
		return informeRendimento;
	}

	public void setInformeRendimento(InformeRendimento informeRendimento) {
		this.informeRendimento = informeRendimento;
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
		if (obj instanceof Desconto){
			return ((Desconto)obj).getId().equals(getId());
		}
		return false;
	}

}
