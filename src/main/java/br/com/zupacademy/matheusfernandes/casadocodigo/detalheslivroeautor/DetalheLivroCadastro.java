package br.com.zupacademy.matheusfernandes.casadocodigo.detalheslivroeautor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.matheusfernandes.casadocodigo.livro.Livro;

@RestController
public class DetalheLivroCadastro {
	
	@PersistenceContext
	private EntityManager manager;
	
	@GetMapping(value = "/detalhes/{id}")
	public ResponseEntity<DetalheLivro> listaId(@PathVariable Long id){
		
		Livro livro = manager.find(Livro.class, id);
		
		if(livro==null) {
			return ResponseEntity.notFound().build();
		}
		DetalheLivro detalheLivro = new DetalheLivro(livro);
		return ResponseEntity.ok(detalheLivro);
	}

}
