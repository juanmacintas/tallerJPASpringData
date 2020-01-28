package es.biblioteca.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import es.biblioteca.entity.Autor;

public class AutorSpecification {

    public static Specification<Autor> filterMasDeUnLibro() {

        return new Specification<Autor>() {

            @Override
            public Predicate toPredicate(Root<Autor> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
            	return cb.greaterThan(cb.size(root.get("libros")), 1);
            }

        };
    }

}