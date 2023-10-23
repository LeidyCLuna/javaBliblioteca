package com.sura.bibloteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class LibroIdEntity {

    @Column(name = "id_libro",nullable = false)
    private Integer idLibro;

    @Column(name = "idElementoPrestableBase",nullable = false)
    private Integer idElementoPrestableBase;
}
