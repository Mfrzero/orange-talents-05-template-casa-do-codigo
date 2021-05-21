package br.com.zupacademy.matheusfernandes.casadocodigo.livro;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;

@Validated
public class LivroDto {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String titulo;
	
	public LivroDto(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}
	public String getTitulo() {
		return titulo;
	}

	public Long getId() {
		return id;
	}
	
	public static List<LivroDto> converter(List<Livro> livro) {
		return livro.stream().map(LivroDto::new).collect(Collectors.toList());
	}

}
