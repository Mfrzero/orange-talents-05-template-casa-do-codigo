package br.com.zupacademy.matheusfernandes.casadocodigo;

import javax.validation.constraints.NotBlank;


public class CategoriaForm {

	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;

	public String getNome() {
		return nome;
	}
	public Categoria converter(CategoriaRepository categoriaRepository) {
		Categoria categoria = new Categoria(nome);
		return categoria;
	}
	@Override
	public String toString() {
		return "AutorForm [nome=" + nome + "]";
	}
}
