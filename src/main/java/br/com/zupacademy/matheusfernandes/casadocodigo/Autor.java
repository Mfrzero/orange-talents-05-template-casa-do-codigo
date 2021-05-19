package br.com.zupacademy.matheusfernandes.casadocodigo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

	public Autor() {
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getHoraDeRegistro() {
		return horaDeRegistro;
	}


	public Autor(@NotBlank String nome, @Email @NotBlank String email, @Size(max = 400) @NotBlank String descricao) {

		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", email=" + email + ", descricao=" + descricao
				+ ", horaDeRegistro=" + horaDeRegistro + "]";
	}

}
