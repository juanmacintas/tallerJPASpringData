package es.biblioteca.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import es.biblioteca.entity.Autor;
import es.biblioteca.entity.Libro;

public class LibroSpecification {

    public static Specification<Libro> filterTitulo(String titulo) {

        return new Specification<Libro>() {

            @Override
            public Predicate toPredicate(Root<Libro> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                return cb.equal(root.get("titulo"), titulo);
            }

        };
    }

    public static Specification<Libro> filterAnioPublicacionMayor(Integer anio) {

        return new Specification<Libro>() {

            @Override
            public Predicate toPredicate(Root<Libro> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                return cb.greaterThan(root.get("informacion").get("fechaPublicacion"), anio);
            }

        };
    }

    public static Specification<Libro> filterAnioPublicacionMenorOIgual(Integer anio) {

        return new Specification<Libro>() {

            @Override
            public Predicate toPredicate(Root<Libro> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                return cb.lessThanOrEqualTo(root.get("informacion").get("fechaPublicacion"), anio);
            }

        };
    }

    public static Specification<Libro> filterMasDeUnAutor() {

        return new Specification<Libro>() {

            @Override
            public Predicate toPredicate(Root<Libro> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
            	return cb.greaterThan(cb.size(root.get("autores")), 1);
            }

        };
    }

    public static Specification<Libro> filterAutor(String autor) {

        return new Specification<Libro>() {

            @Override
            public Predicate toPredicate(Root<Libro> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
            	 ListJoin<Libro, Autor> autores = root.joinList("autores", JoinType.INNER);
                return cb.equal(autores.get("nombre"), autor);
            }

        };
    }

    public static Specification<Libro> filterIdioma(String idioma) {

        return new Specification<Libro>() {

            @Override
            public Predicate toPredicate(Root<Libro> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
            	return cb.equal(root.get("informacion").get("idioma"), idioma);
            }

        };
    }
}