package es.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.biblioteca.entity.Editorial;




@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Integer> {

	@Query("select e from Editorial e where e.nombre like %?1")
	List<Editorial> findByNombreEndsWith(String nombre);

	@Query(value = "SELECT * FROM EDITORIAL WHERE NOMBRE LIKE %?1", nativeQuery = true)
	List<Editorial> findNativeByNombreEndsWith(String nombre);

	@Query("select e from Editorial e where e.nombre = :nombreEditorial")
	Editorial findNamedParameterByName(@Param("nombreEditorial") String nombreEditorial);
}