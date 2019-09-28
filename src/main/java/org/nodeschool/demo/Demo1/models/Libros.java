package org.nodeschool.demo.Demo1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "libros")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libros implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLibro;
    private String nombre;
    private String descripcion;
    private Integer numPagina;
    @ManyToOne
    @JoinColumn(name="escritor")
    private Escritor escritor;
    private Double precio;
}
