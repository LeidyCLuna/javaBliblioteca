package com.sura.bibloteca.mapping;

import com.sura.bibloteca.dto.EmpleadoDTO;
import com.sura.bibloteca.dto.UsuarioDTO;
import com.sura.bibloteca.entity.EmpleadoEntity;
import com.sura.bibloteca.entity.UsuarioEntity;
import com.sura.bibloteca.util.LocalDateFomatter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UsuarioMapping {

    private LocalDateFomatter localDateFomatter;

    public UsuarioEntity usuarioDtoToUsuarioEntity(
            UsuarioDTO usuarioDTO) {
        return UsuarioEntity.builder()
                .idUsuario(usuarioDTO.getIdUsuario())
                .limitePrestamos(usuarioDTO.getLimitePrestamos())
                .build();
    }

    public UsuarioDTO usuarioEntityToUsuarioDTO(
            UsuarioEntity usuarioEntity) {
        return UsuarioDTO.builder()
                .idUsuario(usuarioEntity.getIdUsuario())
                .limitePrestamos(usuarioEntity.getLimitePrestamos())
                .build();
    }
}
