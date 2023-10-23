package com.sura.bibloteca.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")

public class UsuarioEntity {

    @Id
    @Column(name = "id_usuario",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(name = "limite_prestamos",nullable = false)
    private Integer limitePrestamos;
}
