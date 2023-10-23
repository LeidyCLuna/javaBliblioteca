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

public class ElementoReservaEntity {

    @Id
    @Column(name = "id_reserva",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReserva;

    @Column(name = "id_elemento_prestable_base",nullable = false)
    private Integer idElementoPrestableBase;

    @Column(name = "id_empleado",nullable = false)
    private Integer idEmpleado;

    @Column(name = "id_usuario",nullable = false)
    private Integer idUsuario;

    @Column(name = "reservado",nullable = false)
    private Boolean reservado;

    @Column(name = "fecha_reserva",nullable = false)
    private Date fechaReserva;
}
