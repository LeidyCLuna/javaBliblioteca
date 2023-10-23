package com.sura.bibloteca.repository;



import com.sura.bibloteca.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

    @Query("Select e from UsuarioEntity e where e.idUsuario = :idUsuario")
    Optional<UsuarioEntity> findById(Integer idUsuario);
}
