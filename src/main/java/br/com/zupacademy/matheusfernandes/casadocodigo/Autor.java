package br.com.zupacademy.matheusfernandes.casadocodigo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAutor;
	@NotBlank
	private String nome;
	@Email
	@NotBlank
	private String email;
	@Size(max = 400)
	@NotBlank
	private String descricao;
	private LocalDateTime horaDeRegistro = LocalDateTime.now();
	@OneToMany @JoinColumn(name = "autor")
	private List<Livro> livro;
	
	
		
	public Autor() {
	}
	
	public Autor(@NotBlank String nome, @Email @NotBlank String email, @Size(max = 400) @NotBlank String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Long getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Long idAutor) {
		this.idAutor = idAutor;
	}

	@Override
	public String toString() {
		return "Autor [id=" + idAutor + ", nome=" + nome + ", email=" + email + ", descricao=" + descricao
				+ ", horaDeRegistro=" + horaDeRegistro + "]";
	}

}
