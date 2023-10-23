package com.sura.bibloteca.mapping;

import com.sura.bibloteca.entity.ElementoPrestableBaseEntity;

import java.util.ArrayList;
import java.util.List;

import com.sura.bibloteca.dto.ElementoPrestableBaseDTO;
import com.sura.bibloteca.util.LocalDateFomatter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ElementoPrestableBaseMapping {

    private LocalDateFomatter localDateFomatter;

    public ElementoPrestableBaseEntity elementoPrestableBaseDtoToElementoPrestableBaseEntity(
            ElementoPrestableBaseDTO elementoPrestableBaseDTO) {
        return ElementoPrestableBaseEntity.builder()
                .idElementoPrestableBase(elementoPrestableBaseDTO.getIdElementoPrestableBase())
                .tipoElementoPrestable(elementoPrestableBaseDTO.getTipoElementoPrestable())
                .genero(elementoPrestableBaseDTO.getGenero())
                .categoria(elementoPrestableBaseDTO.getCategoria())
                .inventario(elementoPrestableBaseDTO.getInventario())
                .titulo(elementoPrestableBaseDTO.getTitulo())
                .anoPublicacion(new LocalDateFomatter().dateStringtoLocalDate(elementoPrestableBaseDTO.getAnoPublicacion()))
                .build();
    }

    public ElementoPrestableBaseDTO elementoPrestableBaseEntityToElementoPrestableBaseDTO(
            ElementoPrestableBaseEntity elementoPrestableBaseEntity) {
        return ElementoPrestableBaseDTO.builder()
                .idElementoPrestableBase(elementoPrestableBaseEntity.getIdElementoPrestableBase())
                .anoPublicacion(new LocalDateFomatter().LocalDateToStringDate(elementoPrestableBaseEntity.getAnoPublicacion()))
                .categoria(elementoPrestableBaseEntity.getCategoria())
                .genero(elementoPrestableBaseEntity.getGenero())
                .inventario(elementoPrestableBaseEntity.getInventario())
                .tipoElementoPrestable(elementoPrestableBaseEntity.getTipoElementoPrestable())
                .titulo(elementoPrestableBaseEntity.getTitulo()).build();
    }

    public List<ElementoPrestableBaseDTO> listElementoPrestableBaseEntityToElementoPrestableBaseDTO(
            List<ElementoPrestableBaseEntity> elementosPrestableBaseEntity) {
        List<ElementoPrestableBaseDTO> elementosPrestableBaseDTO = new ArrayList<>();
        elementosPrestableBaseEntity.forEach(elementoPrestableBaseEntity -> {
            elementosPrestableBaseDTO
                    .add(elementoPrestableBaseEntityToElementoPrestableBaseDTO(elementoPrestableBaseEntity));

        });

        return elementosPrestableBaseDTO;
    }

}
