package com.sura.bibloteca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class ElementoPrestamoEntity {
    @Id
    @Column(name = "id_prestamo",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPrestamo;

    @Column(name = "id_elemento_prestable_base",nullable = false)
    private Integer idElementoPrestableBase;

    @Column(name = "id_empleado",nullable = false)
    private Integer idEmpleado;

    @Column(name = "fecha_prestamo",nullable = false)
    private Date fechaPrestamo;

    @Column(name = "fehca_devolucion",nullable = false)
    private Date fechaDevolucion;

    @Column(name = "id_usuario",nullable = false)
    private Integer idUsuario;

}
