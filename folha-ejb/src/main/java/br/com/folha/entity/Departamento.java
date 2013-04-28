package br.com.folha.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTAMENTO")
@NamedQueries({
	@NamedQuery(name="Departamento.listarDepartamentoPorSindicato", 
				query="SELECT d FROM Departamento d WHERE d.sindicato = :sindicato"),
})
public class Departamento {
	
	public static final String LISTAR_DEPARTAMENTO_POR_SINDICATO = "Departamento.listarDepartamentoPorSindicato";

	@Id
	@Column(name="DEP_ID", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="DEP_NOME", nullable=false, unique=true, length=50)
	private String nome;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private Sindicato sindicato;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="departamento")
	private List<Cargo> cargos;

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

	public Sindicato getSindicato() {
		return sindicato;
	}

	public void setSindicato(Sindicato sindicato) {
		this.sindicato = sindicato;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	@Override
	public int hashCode() {
		return getId().intValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Departamento){
			return ((Departamento)obj).getId().equals(getId());
		}
		return false;
	}
	
}
