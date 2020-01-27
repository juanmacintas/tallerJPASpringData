package es.biblioteca.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
public class Libro {

    /**
     * Id.
     */
    @Id
    private Integer id;

    /**
     * Titulo del libro.
     */
    private String titulo;

    /**
     * Descripcion.
     */
    private String descripcion;

    /**
     * Categoria ID.
     */
    @ManyToOne
    @JoinColumn(name = "categoria")
    private Categoria categoria;

    /**
     * Autor ID.
     */
    @ManyToOne
    @JoinColumn(name = "autor")
    private Autor autor;

    /**
     * Editorial ID.
     */
    @ManyToOne
    @JoinColumn(name = "editorial")
    private Editorial editorial;

    /**
     * Favorite
     */
    private Boolean favorite;

    @OneToOne(mappedBy="libro")
    private InfoAdicional informacion;

}
