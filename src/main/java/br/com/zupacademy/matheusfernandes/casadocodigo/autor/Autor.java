package br.com.zupacademy.matheusfernandes.casadocodigo.autor;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zupacademy.matheusfernandes.casadocodigo.livro.Livro;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@Email
	@NotBlank
	private String email;
	@Size(max = 400)
	@NotBlank
	private String descricao;
	private LocalDateTime horaDeRegistro = LocalDateTime.now();
	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL) 
	private List<Livro> livro;
	
	
	@Deprecated
	public Autor() {
	}
	
	public Autor(@NotBlank String nome, @Email @NotBlank String email, @Size(max = 400) @NotBlank String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", email=" + email + ", descricao=" + descricao
				+ ", horaDeRegistro=" + horaDeRegistro + "]";
	}


}
