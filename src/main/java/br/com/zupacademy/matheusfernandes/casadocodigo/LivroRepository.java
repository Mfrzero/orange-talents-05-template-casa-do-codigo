package br.com.zupacademy.matheusfernandes.casadocodigo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long>{

	Long findById(String value);

}
