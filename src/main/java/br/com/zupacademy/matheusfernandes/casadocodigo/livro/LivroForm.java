package br.com.zupacademy.matheusfernandes.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.sun.istack.NotNull;

import br.com.zupacademy.matheusfernandes.casadocodigo.autor.Autor;
import br.com.zupacademy.matheusfernandes.casadocodigo.categoria.Categoria;

@Validated
public class LivroForm {

	@NotBlank
	private String titulo;
	@NotBlank
	private String resumo;
	@NotBlank
	private String sumario;
	@NotNull @Min(20)
	private BigDecimal preco;
	@Min(100)
	private Integer numeroDePaginas;
	@NotBlank
	private String isbn;
	@Future @JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	@NotNull
	private Long idAutor;
	@NotNull
	private Long idCategoria;

	public LivroForm(@NotBlank String titulo, @NotBlank String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco,@NotNull @Min(100) Integer numeroDePaginas, @NotBlank String isbn,
			@Future LocalDate dataPublicacao, Long idAutor, Long idCategoria) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroDePaginas = numeroDePaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.idAutor = idAutor;
		this.idCategoria = idCategoria;
	}


	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Long getAutor() {
		return idAutor;
	}
	public Long getCategoria() {
		return idCategoria;
	}
	
	public Livro converter(EntityManager manager) {
		@NotBlank Autor autor = manager.find(Autor.class, idAutor);
		@NotBlank Categoria categoria = manager.find(Categoria.class, idAutor);
//		Assert.state(autor!=null, "Id do autor não cadastrado");
//		Assert.state(categoria!=null, "Id da categoria não cadastrada");
		return new Livro(titulo, resumo, sumario, preco, numeroDePaginas, isbn, dataPublicacao, autor, categoria);
	}
}
