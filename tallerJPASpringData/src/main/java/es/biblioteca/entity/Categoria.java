package es.biblioteca.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Juan Manuel Cintas
 *
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    /**
     * Id.
     */
    @Id
    private int id;

    /**
     * Nombre de la categoria.
     */
    private String nombre;


    /**
     * Libros de la categoría
     */
    @OneToMany(mappedBy="categoria")
    private List<Libro> libros;
}
