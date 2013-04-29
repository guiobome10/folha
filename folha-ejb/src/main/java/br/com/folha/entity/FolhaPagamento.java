package br.com.folha.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="FOLHA_PAGAMENTO")
@NamedQuery(name="FolhaPagamento.listarPorFuncionarioMes", query="SELECT f FROM FolhaPagamento f JOIN FETCH f.lancamentos WHERE f.funcionario = :funcionario  ORDER BY f.funcionario.nome" )
public class FolhaPagamento implements Serializable{

	private static final long serialVersionUID = 1L;

	public static final String LISTAR_POR_FUNCIONARIO_MES = "FolhaPagamento.listarPorFuncionarioMes";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional=false)
	@JoinColumn(name="FPAG_ID", nullable=false, unique=true)
	private Funcionario funcionario;
	
	private Calendar anoMesBase;
	
	@OneToMany(mappedBy="folhaPagamento", orphanRemoval=true, cascade=CascadeType.PERSIST)
	private List<Lancamento> lancamentos;
	
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

	public Calendar getAnoMesBase() {
		return anoMesBase;
	}

	public void setAnoMesBase(Calendar anoMesBase) {
		this.anoMesBase = anoMesBase;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	@Override
	public int hashCode() {
		return funcionario.getId().intValue() + anoMesBase.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof FolhaPagamento){
			return ((FolhaPagamento)obj).getId().equals(getId());
		}
		return false;
	}

}
