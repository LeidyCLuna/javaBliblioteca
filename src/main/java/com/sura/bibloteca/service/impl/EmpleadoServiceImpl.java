package com.sura.bibloteca.service.impl;


import com.sura.bibloteca.dto.ElementoPrestableBaseDTO;
import com.sura.bibloteca.dto.EmpleadoDTO;
import com.sura.bibloteca.entity.ElementoPrestableBaseEntity;
import com.sura.bibloteca.entity.EmpleadoEntity;
import com.sura.bibloteca.mapping.ElementoPrestableBaseMapping;
import com.sura.bibloteca.mapping.EmpleadoMapping;
import com.sura.bibloteca.repository.IEmpleadoRepository;
import com.sura.bibloteca.service.IEmpleadoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmpleadoServiceImpl implements IEmpleadoService {

    private final IEmpleadoRepository iEmpleadoRepository;

    @Override
    public EmpleadoDTO crearEmpleado(EmpleadoDTO empleadoDTO) {
        Optional<EmpleadoEntity> buscarEmpleado = iEmpleadoRepository.findById(empleadoDTO.getIdEmpleado());
        if (Objects.nonNull(buscarEmpleado.get())) {
            EmpleadoEntity crearEmpleado = iEmpleadoRepository.saveAndFlush(new EmpleadoMapping().empleadoDtoToEmpleadoEntity(empleadoDTO));
            if (Objects.nonNull(crearEmpleado)) {
                EmpleadoDTO empleadoDTO2 = new EmpleadoMapping().empleadoEntityToEmpleadoDTO(crearEmpleado);
                return empleadoDTO2;
            }
        }
        return null;
    }

    @Override
    public EmpleadoDTO actualizarEmpleado(EmpleadoDTO empleadoDTO) {
        Optional<EmpleadoEntity> buscarElemento = iEmpleadoRepository
                .findById(empleadoDTO.getIdEmpleado());

        if (Objects.nonNull(buscarElemento.get())) {
            EmpleadoEntity actualizarEmpleado = iEmpleadoRepository
                    .saveAndFlush(new EmpleadoMapping()
                            .empleadoDtoToEmpleadoEntity(empleadoDTO));
            if (Objects.nonNull(actualizarEmpleado)) {
                EmpleadoDTO actualizarEmpleadoDTO = new EmpleadoMapping()
                        .empleadoEntityToEmpleadoDTO(actualizarEmpleado);
                return actualizarEmpleadoDTO;
            }

        } else if (Objects.isNull(buscarElemento)) {

        }
        return null;
    }

    @Override
    public EmpleadoDTO buscarEmpleado(Integer idEmpleadoDTO) {
        Optional<EmpleadoEntity> buscarEmpleado = iEmpleadoRepository
                .findById(idEmpleadoDTO);
        if (Objects.nonNull(buscarEmpleado)) {
            EmpleadoDTO buscarEmpleadoDTO = new EmpleadoMapping()
                    .empleadoEntityToEmpleadoDTO(buscarEmpleado.get());
            return buscarEmpleadoDTO;
        }
        return null;
    }

    @Override
    public String borrarEmpleado(EmpleadoDTO empleadoDTO) {
        EmpleadoDTO buscarEmpleadoDTO = buscarEmpleado(
                empleadoDTO.getIdEmpleado());
        if (Objects.nonNull(buscarEmpleadoDTO)) {
            iEmpleadoRepository
                    .delete(new EmpleadoMapping()
                            .empleadoDtoToEmpleadoEntity(empleadoDTO));
            return "Empleado borrado exitosamente";
        }

        return null;
    }
}
