package com.sura.bibloteca.service.impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sura.bibloteca.dto.EmpleadoDTO;
import com.sura.bibloteca.dto.UsuarioDTO;
import com.sura.bibloteca.entity.EmpleadoEntity;
import com.sura.bibloteca.entity.UsuarioEntity;
import com.sura.bibloteca.mapping.EmpleadoMapping;
import com.sura.bibloteca.mapping.UsuarioMapping;
import com.sura.bibloteca.repository.IUsuarioRepository;
import com.sura.bibloteca.service.IUsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements IUsuarioService {

    private final IUsuarioRepository iUsuarioRepository;

    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
        Optional<UsuarioEntity> buscarUsuario = iUsuarioRepository.findById(usuarioDTO.getIdUsuario());
        if (Objects.nonNull(buscarUsuario)) {
            UsuarioEntity crearUsuario = iUsuarioRepository.saveAndFlush(new UsuarioMapping().usuarioDtoToUsuarioEntity(usuarioDTO));
            if (Objects.nonNull(crearUsuario)) {
                UsuarioDTO usuarioDTO2 = new UsuarioMapping().usuarioEntityToUsuarioDTO(crearUsuario);
                return usuarioDTO2;
            }
        }
        return null;
    }

    @Override
    public UsuarioDTO actualizarUsuario(UsuarioDTO usuarioDTO) {
        Optional<UsuarioEntity> buscarUsuario = iUsuarioRepository
                .findById(usuarioDTO.getIdUsuario());

        if (Objects.nonNull(buscarUsuario.get())) {
            UsuarioEntity actualizarUsuario = iUsuarioRepository
                    .saveAndFlush(new UsuarioMapping()
                            .usuarioDtoToUsuarioEntity(usuarioDTO));
            if (Objects.nonNull(actualizarUsuario)) {
                UsuarioDTO actualizarUsuarioDTO = new UsuarioMapping()
                        .usuarioEntityToUsuarioDTO(actualizarUsuario);
                return actualizarUsuarioDTO;
            }

        } else if (Objects.isNull(buscarUsuario)) {

        }
        return null;
    }

    @Override
    public UsuarioDTO buscarUsuario(Integer idUsuarioDTO) {
        Optional<UsuarioEntity> buscarUsuario = iUsuarioRepository
                .findById(idUsuarioDTO);
        if (Objects.nonNull(buscarUsuario)) {
            UsuarioDTO buscarUsuarioDTO = new UsuarioMapping()
                    .usuarioEntityToUsuarioDTO(buscarUsuario.get());
            return buscarUsuarioDTO;
        }
        return null;
    }

    @Override
    public String borrarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioDTO buscarUsuarioDTO = buscarUsuario(
                usuarioDTO.getIdUsuario());
        if (Objects.nonNull(buscarUsuarioDTO)) {
            iUsuarioRepository
                    .delete(new UsuarioMapping()
                            .usuarioDtoToUsuarioEntity(usuarioDTO));
            return "Usuario borrado exitosamente";
        }

        return null;
    }

}
