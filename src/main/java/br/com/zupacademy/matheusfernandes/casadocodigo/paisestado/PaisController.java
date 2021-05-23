package br.com.zupacademy.matheusfernandes.casadocodigo.paisestado;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.matheusfernandes.casadocodigo.livro.Livro;
import br.com.zupacademy.matheusfernandes.casadocodigo.livro.LivroDto;

@RestController
@Validated
public class PaisController {
	
	@PersistenceContext
	private EntityManager manager;
	@Autowired
	private PaisRepository paisRepository;
	
	@GetMapping("/listarPais")
	public List<Pais> lista(){
		Iterable<Pais> livro = paisRepository.findAll();
		
		return (List<Pais>) livro;
		
	}
	
	@PostMapping("/cadastrarPais")
	@Transactional
	public ResponseEntity<PaisForm> criarPais(@RequestBody @Valid PaisForm form){
		if (form.getNome() == null || form.getNome().isBlank() || paisRepository.findByNome(form.getNome()).isPresent()) {
			return ResponseEntity.badRequest().build();
		}
		Pais pais = form.converter(manager);
		manager.persist(pais);
		return ResponseEntity.ok().build();
	}

}
