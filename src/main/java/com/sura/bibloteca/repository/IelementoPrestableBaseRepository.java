package com.sura.bibloteca.repository;

import com.sura.bibloteca.entity.ElementoPrestableBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IelementoPrestableBaseRepository extends JpaRepository<ElementoPrestableBaseEntity, Integer> {

    @Query("Select e from ElementoPrestableBaseEntity e where titulo = :titulo")
    ElementoPrestableBaseEntity findByTitulo(String titulo);


}
