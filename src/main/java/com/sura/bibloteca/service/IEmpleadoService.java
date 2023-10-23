package com.sura.bibloteca.service;


import com.sura.bibloteca.dto.EmpleadoDTO;

public interface IEmpleadoService {

    EmpleadoDTO crearEmpleado(EmpleadoDTO empleadoDTO);

    EmpleadoDTO actualizarEmpleado(EmpleadoDTO empleadoDTO);

    EmpleadoDTO buscarEmpleado(Integer idEmpleadoDTO);

    String borrarEmpleado(EmpleadoDTO empleadoDTO);


}
