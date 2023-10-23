package com.sura.bibloteca.mapping;


import com.sura.bibloteca.dto.EmpleadoDTO;
import com.sura.bibloteca.entity.EmpleadoEntity;
import com.sura.bibloteca.util.LocalDateFomatter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoMapping {

    private LocalDateFomatter localDateFomatter;

    public EmpleadoEntity empleadoDtoToEmpleadoEntity(
            EmpleadoDTO empleadoDTO) {
        return EmpleadoEntity.builder()
                .idEmpleado(empleadoDTO.getIdEmpleado())
                .nombre(empleadoDTO.getNombre())
                .build();
    }

    public EmpleadoDTO empleadoEntityToEmpleadoDTO(
            EmpleadoEntity empleadoEntity) {
        return EmpleadoDTO.builder()
                .idEmpleado(empleadoEntity.getIdEmpleado())
                .nombre(empleadoEntity.getNombre())
                .build();
    }


}
