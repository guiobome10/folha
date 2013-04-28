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
@Table(name="PROVENTO")
public class Provento {

	@Id
	@Column(name="PRO_ID", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="PRO_DESCRICAO", nullable=false,unique=true, length=50)
	private String descricao;
	
	@Column(name="PRO_PERCENTUAL", precision=5, scale=2)
	private Double percentual;

	@Column(name="PRO_VALOR", precision=6, scale=2)
	private Double valor;
	
	@Column(name="PRO_IND_CALCULO_MEDIA", nullable=false)
	private boolean indicativoCalculoMedia;
	
	@Column(name="PRO_MES_MEDIA", nullable=false, precision=2)
	private Integer mesMedia;
	
	@Column(name="PRO_IND_DECIMO_TERCEIRO", nullable=false)
	private boolean indicativoDecimoTerceiro;
	
	@Column(name="PRO_IND_FERIAS", nullable=false)
	private boolean indicativoFerias;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="PRO_INFORME_RENDIMENTO", nullable=false)
	private InformeRendimento informeRendimento;

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

	public boolean isIndicativoCalculoMedia() {
		return indicativoCalculoMedia;
	}

	public void setIndicativoCalculoMedia(boolean indicativoCalculoMedia) {
		this.indicativoCalculoMedia = indicativoCalculoMedia;
	}

	public Integer getMesMedia() {
		return mesMedia;
	}

	public void setMesMedia(Integer mesMedia) {
		this.mesMedia = mesMedia;
	}

	public boolean isIndicativoDecimoTerceiro() {
		return indicativoDecimoTerceiro;
	}

	public void setIndicativoDecimoTerceiro(boolean indicativoDecimoTerceiro) {
		this.indicativoDecimoTerceiro = indicativoDecimoTerceiro;
	}

	public boolean isIndicativoFerias() {
		return indicativoFerias;
	}

	public void setIndicativoFerias(boolean indicativoFerias) {
		this.indicativoFerias = indicativoFerias;
	}

	public InformeRendimento getInformeRendimento() {
		return informeRendimento;
	}

	public void setInformeRendimento(InformeRendimento informeRendimento) {
		this.informeRendimento = informeRendimento;
	}
	
	@Override
	public int hashCode() {
		return getId().intValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Provento){
			return ((Provento)obj).getId().equals(getId());
		}
		return false;
	}

}
