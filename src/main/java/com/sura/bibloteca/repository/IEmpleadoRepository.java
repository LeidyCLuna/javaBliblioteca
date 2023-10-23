package com.sura.bibloteca.repository;

import com.sura.bibloteca.entity.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IEmpleadoRepository extends JpaRepository<EmpleadoEntity, Integer> {

    @Query("Select e from EmpleadoEntity e where e.idEmpleado = :idEmpleado")
    Optional<EmpleadoEntity> findById(Integer idEmpleado);

}
