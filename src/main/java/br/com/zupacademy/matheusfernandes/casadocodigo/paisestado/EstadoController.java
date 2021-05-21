package br.com.zupacademy.matheusfernandes.casadocodigo.paisestado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstadoController {
	
	@PersistenceContext
	private EntityManager manager;

	@PostMapping("/estado")
	public ResponseEntity<EstadoForm> criar(@RequestBody @Valid EstadoForm form){
		
		if (form.getNome() == null || form.getNome().isBlank()) {
			return ResponseEntity.badRequest().build();
		}
		Estado estado = form.converter(manager);
		manager.persist(estado);
		return ResponseEntity.ok(form);
	}
}
