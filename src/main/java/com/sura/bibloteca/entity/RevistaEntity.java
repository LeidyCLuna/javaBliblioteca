package com.sura.bibloteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class RevistaEntity {

    @EmbeddedId
    private RevistaIdEntity revistaId;

    @Column(name = "numero",nullable = false)
    private Integer numero;

    @Column(name = "periocidad",nullable = false)
    private String periocidad;


}
