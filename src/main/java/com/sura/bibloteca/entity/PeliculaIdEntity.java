package com.sura.bibloteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PeliculaIdEntity {

    @Column(name = "id_pelicula",nullable = false)
    private Integer idPelicula;

    @Column(name = "idElementoPrestableBase",nullable = false)
    private Integer idElementoPrestableBase;
}
