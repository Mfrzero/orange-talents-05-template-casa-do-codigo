package br.com.zupacademy.matheusfernandes.casadocodigo.cliente;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.zupacademy.matheusfernandes.casadocodigo.paisestado.Pais;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{

	@Query(value = "Select id from pais WHERE id = :id", nativeQuery = true)
	Pais findByIdPais(@Param("id") Long idPais);
	
	Optional<Cliente> findByEmail(String value);
	Optional<Cliente> findByDocumento(String value);

}
