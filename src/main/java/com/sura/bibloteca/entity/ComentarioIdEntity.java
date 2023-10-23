package com.sura.bibloteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ComentarioIdEntity {

    @Column(name = "id_comentario",nullable = false)
    private Integer idComentario;

    @Column(name = "idElementoPrestableBase",nullable = false)
    private Integer idElementoPrestableBase;
}
