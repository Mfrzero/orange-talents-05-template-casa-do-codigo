package br.com.zupacademy.matheusfernandes.casadocodigo.paisestado;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import br.com.zupacademy.matheusfernandes.casadocodigo.cliente.Cliente;

@Entity
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@NotNull @ManyToOne
	private Pais pais;
	@OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
	private List<Cliente> cliente;
	
	public Estado() {
	}

	public Estado(@NotBlank String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}

	public String getNome() {
		return nome;
	}

	public Pais getPais() {
		return pais;
	}
	
	
	

}
