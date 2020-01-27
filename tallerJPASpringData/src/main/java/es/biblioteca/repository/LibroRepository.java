package es.biblioteca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import es.biblioteca.entity.Libro;



@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer>, QueryByExampleExecutor<Libro> {

    public List<Libro> findByFavoriteTrue();

    public Optional<Libro> findByTitulo(String titulo);

    public  List<Libro> findByAutor_nombre(String nombre);

    public  List<Libro> findByAutor_nombreIgnoreCase(String nombre);

    public  List<Libro> findByAutor_id(Integer id);

    public  List<Libro> findByAutor_nombreAndCategoria_nombre(String autor, String categoria);

    public  List<Libro> findByCategoria_nombreIn(List<String> categorias);

    public  List<Libro> findByCategoria_nombreNotIn(List<String> categorias);

    public List<Libro> findByEditorial_nombreStartsWith(String editorial);

    public List<Libro> findByTituloLike(String titulo);
}