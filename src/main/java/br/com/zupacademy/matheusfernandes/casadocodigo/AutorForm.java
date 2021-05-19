package br.com.zupacademy.matheusfernandes.casadocodigo;

import javax.validation.constraints.NotBlank;

public class AutorForm {
	@NotBlank
	private String nome;
	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "email")
	private String email;
	@NotBlank
	private String descricao;
	
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public Autor converter(AutorRepository autorRepository) {

		return new Autor(nome, email, descricao);
	}

	@Override
	public String toString() {
		return "AutorForm [nome=" + nome + ", email=" + email + ", descricao=" + descricao + "]";
	}
}
