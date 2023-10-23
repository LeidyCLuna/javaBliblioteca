package com.sura.bibloteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;

public class LibroEntity {

    @EmbeddedId
    private LibroIdEntity LibroId;

    @Column(name = "autor",nullable = false)
    private String director;

    @Column(name = "ediccion",nullable = false)
    private String reparto;
}
