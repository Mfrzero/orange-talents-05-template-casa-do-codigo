package br.com.zupacademy.matheusfernandes.casadocodigo;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long>{

	Optional<Livro> findById(Livro id);

}
