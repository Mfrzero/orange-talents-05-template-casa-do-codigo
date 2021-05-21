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
public class EstadoController {
	
	@PersistenceContext
	private EntityManager manager;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping("/estado")
	@Transactional
	public ResponseEntity<EstadoForm> criar(@RequestBody @Valid EstadoForm form){
		
		if (form.getNome().isBlank() || estadoRepository.findByNomeAndPaisId(form.getIdPais(), form.getNome()).isPresent()
				|| paisRepository.findById(form.getIdPais()).isEmpty()){
			return ResponseEntity.badRequest().build();
		}
			
		Estado estado = form.converter(manager);
		manager.persist(estado);
		return ResponseEntity.ok(form);
	}
}
