package com.sura.bibloteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class RevistaIdEntity {

    @Column(name = "id_revista",nullable = false)
    private Integer idRevista;

    @Column(name = "idElementoPrestableBase",nullable = false)
    private Integer idElementoPrestableBase;
}
