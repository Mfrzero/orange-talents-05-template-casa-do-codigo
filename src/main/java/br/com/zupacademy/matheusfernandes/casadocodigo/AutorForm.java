package br.com.zupacademy.matheusfernandes.casadocodigo;

public class AutorForm {

	private String nome;
	private String email;
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
}
