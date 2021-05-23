package br.com.zupacademy.matheusfernandes.casadocodigo.categoria;

import java.util.List;

import javax.persistence.CascadeType;
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
	private Long id;
	@NotBlank
	private String nome;
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL) 
	private List<Livro> livro;
	
	@Deprecated
	public Categoria() {
	}

	public Categoria(@NotBlank String nome) {
		this.nome = nome;
	}

}
