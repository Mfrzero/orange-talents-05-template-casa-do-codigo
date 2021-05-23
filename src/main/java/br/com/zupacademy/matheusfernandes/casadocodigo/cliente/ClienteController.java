package br.com.zupacademy.matheusfernandes.casadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.matheusfernandes.casadocodigo.paisestado.Pais;
import br.com.zupacademy.matheusfernandes.casadocodigo.paisestado.PaisRepository;

@RestController
public class ClienteController {
	
	@PersistenceContext
	private EntityManager manager;

	@PostMapping("/cadastraCliente")
	@Transactional
	public ResponseEntity<ClienteForm> criar(@RequestBody @Valid ClienteForm form) {
		if (form.getNome().isBlank()){
			return ResponseEntity.badRequest().build();
		}
		Cliente cliente = form.converter(manager);
		manager.persist(cliente);
		return ResponseEntity.ok().build();
		
	}
}
