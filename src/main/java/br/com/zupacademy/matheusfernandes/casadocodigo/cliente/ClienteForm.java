package br.com.zupacademy.matheusfernandes.casadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.matheusfernandes.casadocodigo.UniqueValue;
import br.com.zupacademy.matheusfernandes.casadocodigo.paisestado.Estado;
import br.com.zupacademy.matheusfernandes.casadocodigo.paisestado.Pais;
import br.com.zupacademy.matheusfernandes.casadocodigo.paisestado.PaisRepository;

public class ClienteForm {
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@Email
	@NotBlank
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;
	@NotBlank
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento")
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull
	private Long idPais;
	private Long estadoId;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;

	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Long getEstadoId() {
		return estadoId;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}


	public Cliente converter(EntityManager manager) {
		Pais pais = manager.find(Pais.class, idPais);
		Estado estado = manager.find(Estado.class, estadoId);
		return new Cliente(nome, sobrenome, email, documento, endereco, complemento, cidade, pais, estado, telefone, cep);


		
		
	}

}
