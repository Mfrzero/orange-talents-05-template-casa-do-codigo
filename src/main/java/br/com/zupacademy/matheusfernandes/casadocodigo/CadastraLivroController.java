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

//	@PostMapping("/cadastrarLivro")
//	public ResponseEntity<LivroForm> cadastrar(@RequestBody @Valid LivroForm livroForm) {
//		Livro livro = livroForm.converter(livroRepository);
//		livroRepository.save(livro);
//		if (livroForm.getAutor() == null) {
//			return ResponseEntity.badRequest().build();
//		}
//		return ResponseEntity.ok().build();
//	}
	@GetMapping(value = "/listaLivros")
	public List<Livro> lista(){
		List<Livro> categoria = (List<Livro>) livroRepository.findAll();
		return categoria;
	}

//	@PostMapping("/cadastrarLivro")
//	@Transactional
//	public String cadastrar(@RequestBody @Valid LivroForm livroForm) {
//		Livro livro = livroForm.converter(manager);
//		manager.persist(livro);
//
//		return "ta chegando";
//	}
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
