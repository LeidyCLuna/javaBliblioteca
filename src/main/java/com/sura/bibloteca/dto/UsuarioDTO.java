package com.sura.bibloteca.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    @JsonProperty("id_usuario")
    private Integer idUsuario;

    @JsonProperty("limite_prestamos")
    private Integer limitePrestamos;
}
