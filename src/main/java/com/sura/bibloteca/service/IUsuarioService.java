package com.sura.bibloteca.service;


import com.sura.bibloteca.dto.EmpleadoDTO;
import com.sura.bibloteca.dto.UsuarioDTO;

public interface IUsuarioService {

    UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO);

    UsuarioDTO actualizarUsuario(UsuarioDTO usuarioDTO);

    UsuarioDTO buscarUsuario(Integer idUsuarioDTO);

    String borrarUsuario(UsuarioDTO usuarioDTO);
}
