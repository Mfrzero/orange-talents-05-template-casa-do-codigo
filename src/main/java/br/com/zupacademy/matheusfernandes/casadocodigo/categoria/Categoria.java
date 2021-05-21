package br.com.zupacademy.matheusfernandes.casadocodigo.categoria;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import br.com.zupacademy.matheusfernandes.casadocodigo.livro.Livro;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoria;
	@NotBlank
	private String nome;
	@OneToMany @JoinColumn(name = "categoria")
	private List<Livro> livro;
	
	public Categoria() {
	}

	public Categoria(@NotBlank String nome) {
		this.nome = nome;
	}
		
	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

}
