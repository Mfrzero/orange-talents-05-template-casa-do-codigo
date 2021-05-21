package br.com.zupacademy.matheusfernandes.casadocodigo.paisestado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaisController {
	
	@PersistenceContext
	private EntityManager manager;
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping("/cadastrarPais")
	@Transactional
	public ResponseEntity<PaisForm> criar(@RequestBody @Valid PaisForm form){
		if (form.getNome() == null || form.getNome().isBlank() || paisRepository.findByNome(form.getNome()).isPresent()) {
			return ResponseEntity.badRequest().build();
		}
		Pais pais = form.converter(manager);
		manager.persist(pais);
		return ResponseEntity.ok(form);
	}

}
