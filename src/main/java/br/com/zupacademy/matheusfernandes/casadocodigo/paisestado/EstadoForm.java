package br.com.zupacademy.matheusfernandes.casadocodigo.paisestado;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoForm {

	@NotBlank
	private String nome;
	@NotNull
	private Long idPais;

	public EstadoForm(@NotBlank String nome,@NotNull Long idPais) {
		this.nome = nome;
		this.idPais = idPais;
	}

	public String getNome() {
		return nome;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Estado converter(EntityManager manager) {
		Pais pais = manager.find(Pais.class, idPais);
		return new Estado(nome, pais);
	}

}
