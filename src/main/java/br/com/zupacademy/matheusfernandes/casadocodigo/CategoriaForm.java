package br.com.zupacademy.matheusfernandes.casadocodigo;

import org.springframework.beans.factory.annotation.Autowired;

public class CategoriaForm {

	@Autowired
	Categoria categoria;
	
	private String nome;

	public Categoria getCategoria() {
		return categoria;
	}
	

	public String getNome() {
		return nome;
	}

	public Categoria converter(CategoriaRepository categoriaRepository) {

		return new Categoria(nome);
	}

	@Override
	public String toString() {
		return "AutorForm [nome=" + nome + "]";
	}
}
