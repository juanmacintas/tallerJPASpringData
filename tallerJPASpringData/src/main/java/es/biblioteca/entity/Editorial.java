package es.biblioteca.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

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
public class Editorial {

    /**
     * Id.
     */
    @Id
    private int id;

    /**
     * Nombre de la editorial.
     */
    private String nombre;


}
