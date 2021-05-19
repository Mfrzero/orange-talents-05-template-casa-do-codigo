package br.com.zupacademy.matheusfernandes.casadocodigo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nomeCadastro;

	public Categoria() {
	}
	public Categoria(@NotBlank String nomeCadastro) {
		this.nomeCadastro = nomeCadastro;
	}
	public Long getId() {
		return id;
	}
	public String getNomeCadastro() {
		return nomeCadastro;
	}
	
}
