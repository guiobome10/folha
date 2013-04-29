package br.com.folha.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="LANCAMENTO")
public class Lancamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LCTO_ID")
	private Long id;
	
	@Column(name="LCTO_VALOR", nullable=false)
	private BigDecimal valor;
	
	@Column(name="LCTO_PERCENTUAL", nullable=false)
	private Double percentual;
	
	@ManyToOne
	@JoinColumn(name="LCTO_FOLHA_ID", nullable=false)
	private FolhaPagamento folhaPagamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FolhaPagamento getFolhaPagamento() {
		return folhaPagamento;
	}

	public void setFolhaPagamento(FolhaPagamento folhaPagamento) {
		this.folhaPagamento = folhaPagamento;
	}

	@Override
	public int hashCode() {
		return getId().intValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Lancamento){
			return ((Lancamento)obj).getId().equals(getId());
		}
		return false;
	}

}
