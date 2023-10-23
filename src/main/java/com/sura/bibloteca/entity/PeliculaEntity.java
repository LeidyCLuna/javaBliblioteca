package com.sura.bibloteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;

public class PeliculaEntity {
    @EmbeddedId
    private PeliculaIdEntity peliculaId;

    @Column(name = "director",nullable = false)
    private String director;

    @Column(name = "reparto",nullable = false)
    private String reparto;

    @Column(name = "duracion",nullable = false)
    private Float duracion;
}
