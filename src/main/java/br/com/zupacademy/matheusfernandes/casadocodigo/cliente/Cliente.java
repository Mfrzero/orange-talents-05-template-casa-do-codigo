package br.com.zupacademy.matheusfernandes.casadocodigo.cliente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.matheusfernandes.casadocodigo.CPFOrCNPJ;
import br.com.zupacademy.matheusfernandes.casadocodigo.paisestado.Estado;
import br.com.zupacademy.matheusfernandes.casadocodigo.paisestado.Pais;

@Entity
public class Cliente {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@Email @NotBlank 
	private String email;
	@NotBlank  @CPFOrCNPJ
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@ManyToOne
	@JoinColumn(name = "pais_Id", referencedColumnName = "id",nullable = false)
	private Pais pais;
	@ManyToOne
	@JoinColumn(name = "estado_Id", referencedColumnName = "id",nullable = false)
	private Estado estado;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;
	
	
	@Deprecated
	public Cliente() {
	}

	public Cliente(@NotBlank String nome, @NotBlank String sobrenome, @Email @NotBlank String email,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Pais pais, 
			@NotBlank String telefone, @NotBlank String cep) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.telefone = telefone;
		this.cep = cep;
	}
	
	public Cliente(@NotBlank String nome, @NotBlank String sobrenome, @Email @NotBlank String email,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Pais pais, Estado estado, 
			@NotBlank String telefone, @NotBlank String cep) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.estado = estado;
		this.telefone = telefone;
		this.cep = cep;
	}

	@OneToMany
	public Long getId() {
		return id;
	}
	
	
	
}
