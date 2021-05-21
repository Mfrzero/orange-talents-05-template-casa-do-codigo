package br.com.zupacademy.matheusfernandes.casadocodigo.paisestado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "campo não pode ser vazio")
	private String nome;
	
	public Pais(@NotBlank String nome) {
		this.nome = nome;
	}

	public Pais() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

}
