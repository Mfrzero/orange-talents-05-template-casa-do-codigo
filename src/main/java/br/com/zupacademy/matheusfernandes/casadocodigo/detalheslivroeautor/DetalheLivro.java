package br.com.zupacademy.matheusfernandes.casadocodigo.detalheslivroeautor;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.matheusfernandes.casadocodigo.livro.Livro;

public class DetalheLivro {
	
	@NotNull
	private DetalheAutor autor;
	@NotBlank
	private String titulo;
	@NotBlank
	private String resumo;
	@NotBlank
	private String sumario;
	@NotBlank
	private String isbn;
	@NotNull
	private Integer numeroDePaginas;
	private BigDecimal preco;
	@NotBlank
	private String dataPublicacao;
	
	public DetalheLivro(Livro livro) {
		this.autor = new DetalheAutor(livro.getAutor());
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.isbn = livro.getIsbn();
		this.numeroDePaginas = livro.getNumeroDePaginas();
		this.preco = livro.getPreco();
		this.dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(String dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public DetalheAutor getAutor() {
		return autor;
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

	public String getIsbn() {
		return isbn;
	}

	public BigDecimal getPreco() {
		return preco;
	}
	
	

	
}
