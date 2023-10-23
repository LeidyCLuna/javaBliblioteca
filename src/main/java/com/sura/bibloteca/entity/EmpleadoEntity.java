package com.sura.bibloteca.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empleado")

public class EmpleadoEntity {

    @Id
    @Column(name = "id_empleado",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpleado;

    @Column(name = "nombre",nullable = false)
    private String nombre;

}
