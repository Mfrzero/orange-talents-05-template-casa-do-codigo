package br.com.zupacademy.matheusfernandes.casadocodigo.paisestado;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EstadoRepository extends CrudRepository<Estado, Long>{


	@Query(value = "Select * from estado WHERE pais_id = :id and nome = :nome", nativeQuery = true)
	Optional<Estado> findByNomeAndPaisId(@Param("id") Long idPais, @Param("nome") String nome);

	Optional<?> findByNome(String nome);
	
}
