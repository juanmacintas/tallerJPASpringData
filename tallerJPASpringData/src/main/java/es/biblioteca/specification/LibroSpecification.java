package es.biblioteca.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

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
}