package com.sura.bibloteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;

public class ComentarioEntity {

    @EmbeddedId
    private ComentarioIdEntity comentarioId;

    @Column(name = "id_usuario",nullable = false)
    private Integer idUsuario;

    @Column(name = "comentario",nullable = false)
    private String comentario;

    @Column(name = "clasificacion",nullable = false)
    private String clasificacion;
}
