package br.com.zupacademy.matheusfernandes.casadocodigo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AutorForm {
	
	@NotBlank
	private String nome;
	@NotBlank
	@Email
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
		Autor autor = new Autor(nome, email, descricao);
		return autor;
	}
	@Override
	public String toString() {
		return "AutorForm [nome=" + nome + ", email=" + email + ", descricao=" + descricao + "]";
	}
}
