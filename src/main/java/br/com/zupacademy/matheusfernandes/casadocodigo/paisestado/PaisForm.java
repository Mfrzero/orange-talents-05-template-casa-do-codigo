package br.com.zupacademy.matheusfernandes.casadocodigo.paisestado;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

public class PaisForm {
	
	@NotBlank
	private String nome;

	public Pais converter(EntityManager manager) {
		Pais pais = new Pais(nome);
		return pais;
	}

	public String getNome() {
		return nome;
	}

}
