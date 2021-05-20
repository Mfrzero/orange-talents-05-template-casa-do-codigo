package br.com.zupacademy.matheusfernandes.casadocodigo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadastraLivroController {

	@Autowired
	private LivroRepository livroRepository;
	@PersistenceContext
	private EntityManager manager;

	@GetMapping(value = "/listaLivros")
	public List<LivroDto> lista(){
		Iterable<Livro> livro = livroRepository.findAll();
		
		return LivroDto.converter((List<Livro>) livro);
		
	}

	@PostMapping("/cadastrarLivro")
	@Transactional
	public ResponseEntity<LivroForm> cadastrar(@RequestBody @Valid LivroForm livroForm) {
		if (livroForm.getAutor() == null || livroForm.getCategoria() == null) {
			return ResponseEntity.badRequest().build();
		}
		Livro livro = livroForm.converter(manager);
		manager.persist(livro);

		return ResponseEntity.ok().build();
	}
}
