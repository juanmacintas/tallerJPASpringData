package es.biblioteca.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;

import es.biblioteca.entity.Categoria;
import es.biblioteca.entity.Libro;
import es.biblioteca.specification.LibroSpecification;
import lombok.extern.slf4j.Slf4j;

@DataJpaTest
@Slf4j
@DisplayName("JUnit Test unitario repositorio Libro")
public class LibroRepositoryTest {

	@Autowired
	LibroRepository libroRepository;


	@Test
	@DisplayName("Test unitario buscar todos")
	public void testFindAll() {

		  List<Libro> libros = libroRepository.findAll();

		  assertEquals(libros.size(),26);
	}


	@Test
	@DisplayName("Test unitario buscar por id")
	public void testFindById() {

		  Optional<Libro> libro = libroRepository.findById(1);

		  assertEquals(libro.isPresent(), true);
		  assertEquals(libro.get().getTitulo(),"Los Pilares de la Tierra");

	}

	@Test
	@DisplayName("Test unitario buscar libros favoritos")
	public void testFindFavoritos() {
		  List<Libro> libros = libroRepository.findByFavoriteTrue();

		  assertEquals(libros.size(),5);

	}

	@Test
	@DisplayName("Test unitario buscar libro por titulo")
	public void testFindByTitulo() {
		Optional<Libro> libro = libroRepository.findByTitulo("Los Pilares de la Tierra");

		  assertEquals(libro.isPresent(), true);
		  assertEquals(libro.get().getId(),1);
	}

	@Test
	@DisplayName("Test unitario buscar libros nombre de autor")
	public void testFindLibrosNombreAutor() {
		  List<Libro> libros = libroRepository.findByAutores_nombre("Ken Follett");

		  assertEquals(libros.size(),3);

	}

	@Test
	@DisplayName("Test unitario buscar libros nombre de autor Ignore Case")
	public void testFindLibrosNombreAutorIgnoreCase() {
		  List<Libro> libros = libroRepository.findByAutores_nombreIgnoreCase("ken follett");

		  assertEquals(libros.size(),3);

	}

	@Test
	@DisplayName("Test unitario buscar libros id de autor")
	public void testFindLibrosIdAutor() {
		  List<Libro> libros = libroRepository.findByAutores_id(1);

		  assertEquals(libros.size(),3);

	}

	@Test
	@DisplayName("Test unitario buscar libros nombre de autor y categoria")
	public void testFindLibrosNombreAutorCategoria() {
		  List<Libro> libros = libroRepository.findByAutores_nombreAndCategoria_nombre("Ken Follett", "Ficcion Historica");
		  log.debug("Libros de Ken Follet de Ficción Histórica:" + libros.size());
		  assertEquals(libros.size(),3);

		  libros = libroRepository.findByAutores_nombreAndCategoria_nombre("Ken Follett", "Terror");
		  log.debug("Libros de Ken Follet de Terror:" + libros.size());
		  assertEquals(libros.size(),0);


	}

	@Test
	@DisplayName("Test unitario buscar libros nombre de editorial")
	public void testFindLibrosNombreEditorial() {
		  List<Libro> libros = libroRepository.findByEditorial_nombreStartsWith("Planeta");

		  assertEquals(libros.size(),7);

	}

	@Test
	@DisplayName("Test unitario buscar libros titulo like")
	public void testFindLibrosTituloLike() {
		  List<Libro> libros = libroRepository.findByTituloLike("%anillos%");

		  assertEquals(libros.size(),3);

	}

	@Test
	@DisplayName("Test unitario buscar libros cateogorias")
	public void testFindLibrosCategorias() {
		List<String> categorias = Arrays. asList("Terror", "Policiaca");
		List<Libro> libros = libroRepository.findByCategoria_nombreIn(categorias);

		 assertEquals(libros.size(),4);

	}

	@Test
	@DisplayName("Test unitario buscar libros cateogorias not")
	public void testFindLibrosCategoriasNot() {
		List<String> categorias = Arrays. asList("Terror", "Policiaca");
		List<Libro> libros = libroRepository.findByCategoria_nombreNotIn(categorias);

		 assertEquals(libros.size(),22);

	}


	@Test
	@DisplayName("Test unitario buscar libros example titulo")
	public void testFindLibrosExampleTitulo() {

		Libro libro = Libro.builder()
						.titulo("Dracula")
						.favorite(false)
						.build();

		Example<Libro> exLibro = Example.of(libro);

		List<Libro> libros = libroRepository.findAll(exLibro);

		 assertEquals(libros.size(),1);
		 assertEquals(libros.get(0).getAutores().get(0).getNombre(),"Bram Stoker");

	}

	@Test
	@DisplayName("Test unitario buscar libros example categoria")
	public void testFindLibrosExampleCategoria() {

		Categoria categoria = Categoria.builder()
									.id(4)
									.nombre("Romantica")
									.build();
		Libro libro = Libro.builder()
						.categoria(categoria)
						.build();

		Example<Libro> exLibro = Example.of(libro);

		List<Libro> libros = libroRepository.findAll(exLibro);
		log.debug("Libros de categoría Romantica:" + libros.size());
		 assertEquals(libros.size(),1);
		 assertEquals(libros.get(0).getTitulo(),"Orgullo y Prejuicio");

	}

	@Test
	@DisplayName("Test unitario borrar libro")
	public void testDeleteLibro() {
		libroRepository.deleteById(26);
		libroRepository.flush();
	}

	@Test
	@DisplayName("Test unitario buscar libros specification titulo")
	public void testFindLibrosSpecificationTitulo() {
		String sTituloLibro = "Orgullo y Prejuicio";
		Specification<Libro> specificationTituloLibro = Specification.where(LibroSpecification.filterTitulo(sTituloLibro));


		List<Libro> libros = libroRepository.findAll(specificationTituloLibro);

		 assertEquals(libros.size(),1);
		 assertEquals(libros.get(0).getTitulo(),"Orgullo y Prejuicio");

	}


	@Test
	@DisplayName("Test unitario buscar libros specification año publicacion mayor")
	public void testFindLibrosSpecificationAnioPublicacionMayor() {
		Integer iAnioPublicacion = 2016;
		Specification<Libro> specificationAnioPublicacion = Specification.where(LibroSpecification.filterAnioPublicacionMayor(iAnioPublicacion));


		List<Libro> libros = libroRepository.findAll(specificationAnioPublicacion);

		 assertEquals(libros.size(),4);


	}

	@Test
	@DisplayName("Test unitario buscar libros specification año publicacion menor o igual")
	public void testFindLibrosSpecificationAnioPublicacionMenorIgual() {
		Integer iAnioPublicacion = 2016;
		Specification<Libro> specificationAnioPublicacion = Specification.where(LibroSpecification.filterAnioPublicacionMenorOIgual(iAnioPublicacion));

		List<Libro> libros = libroRepository.findAll(specificationAnioPublicacion);

		 assertEquals(libros.size(),21);

	}

}


