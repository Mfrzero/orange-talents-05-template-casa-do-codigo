package br.com.zupacademy.matheusfernandes.casadocodigo.detalheslivroeautor;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.matheusfernandes.casadocodigo.autor.Autor;

public class DetalheAutor {

	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	private String descricao;
	
	public DetalheAutor(Autor autor) {
		this.nome = autor.getNome();
		this.descricao = autor.getDescricao() ;
	}
	public String getNome() {
		return nome;
	}
	public String getDescricao() {
		return descricao;
	}
	
	
}
