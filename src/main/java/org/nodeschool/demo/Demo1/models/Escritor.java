package org.nodeschool.demo.Demo1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "escritores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Escritor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEscritor;
    private String nombre;
    private String apellido;
    private String pais;
    private String twitter;
    private String fb;

}
