package br.com.folha.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CARGO")
@NamedQuery(name= "Cargo.listarCargosPorDepartamento", 
			query= "SELECT c FROM Cargo c WHERE c.departamento = :departamento")
public class Cargo {

	public static final String LISTAR_CARGOS_POR_DEPARTAMENTO = "Cargo.listarCargosPorDepartamento";
	
	@Id
	@Column(name="CGO_ID", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="CGO_NOME", nullable=false, length=60, unique=true)
	private String nome;

	@Column(name="CGO_HORAS_MENSAIS", nullable=false, scale=2, precision=5)
	private BigDecimal horasMensais;
	
	@Column(name="CGO_HORAS_SEMANAIS", nullable=false, scale=2, precision=4)
	private BigDecimal horasSemanais;
	
	@Column(name="CGO_ADICIONAL_NOTURNO", nullable=false)
	private boolean adicionalNoturno;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private Departamento departamento;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="cargo")
	private List<Funcionario> funcionarios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getHorasMensais() {
		return horasMensais;
	}

	public void setHorasMensais(BigDecimal horasMensais) {
		this.horasMensais = horasMensais;
	}

	public BigDecimal getHorasSemanais() {
		return horasSemanais;
	}

	public void setHorasSemanais(BigDecimal horasSemanais) {
		this.horasSemanais = horasSemanais;
	}

	public boolean isAdicionalNoturno() {
		return adicionalNoturno;
	}

	public void setAdicionalNoturno(boolean adicionalNoturno) {
		this.adicionalNoturno = adicionalNoturno;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	@Override
	public int hashCode() {
		return getId().intValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Cargo)
			return ((Cargo)obj).getId().equals(getId());
		return false;
	}

}
