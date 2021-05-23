package br.com.zupacademy.matheusfernandes.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.matheusfernandes.casadocodigo.autor.Autor;
import br.com.zupacademy.matheusfernandes.casadocodigo.categoria.Categoria;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String titulo;
	private String resumo;
	private String sumario;
	private @Min(20) BigDecimal preco;
	private Integer numeroDePaginas;
	private String isbn;
	private LocalDate dataPublicacao;
	@ManyToOne
	@JoinColumn(name = "autor_Id", referencedColumnName = "id",nullable = false)
	private Autor autor;
	@ManyToOne
	@JoinColumn(name = "categoria_Id", referencedColumnName = "id",nullable = false)
	private Categoria categoria;
	
	@Deprecated
	public Livro() {
	}

	public Livro(@NotBlank String titulo, String resumo, String sumario, @Min(20) BigDecimal preco,
			Integer numeroDePaginas, String isbn, LocalDate dataPublicacao,@NotNull Autor autor,@NotNull Categoria categoria) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroDePaginas = numeroDePaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.autor = autor;
		this.categoria = categoria;
	}

	@OneToMany
	public Long getId() {
		return id;
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

	public Autor getAutor() {
		return autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	

}
