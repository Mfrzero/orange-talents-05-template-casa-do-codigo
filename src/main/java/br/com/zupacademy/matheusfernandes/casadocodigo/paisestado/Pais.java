package br.com.zupacademy.matheusfernandes.casadocodigo.paisestado;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import br.com.zupacademy.matheusfernandes.casadocodigo.cliente.Cliente;

@Entity
public class Pais {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "campo não pode ser vazio")
	private String nome;
	@OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
	private List<Cliente> cliente;
	
	public Pais(@NotEmpty String nome) {
		this.nome = nome;
	}

	public Pais() {
	}

	public String getNome() {
		return nome;
	}

}
