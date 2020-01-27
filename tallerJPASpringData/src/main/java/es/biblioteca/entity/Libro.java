package es.biblioteca.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Categoria categoria;

    /**
     * Autores.
     */
    @ManyToMany
    @JoinTable(name = "autor_libro",
    		   joinColumns = @JoinColumn(name = "libro_id"),
    		   inverseJoinColumns = @JoinColumn(name = "autor_id")
    		  )
    private List<Autor> autores;

    /**
     * Editorial.
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
