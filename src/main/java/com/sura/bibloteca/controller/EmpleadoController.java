package com.sura.bibloteca.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sura.bibloteca.dto.ElementoPrestableBaseDTO;
import com.sura.bibloteca.dto.EmpleadoDTO;
import com.sura.bibloteca.service.IEmpleadoService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/empleado")
@CrossOrigin(origins = "*")
@Log4j2
public class EmpleadoController {

    private final IEmpleadoService iEmpleadoService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok. se guardo correctamente el empleado", response = EmpleadoDTO.class),
            @ApiResponse(code = 400, message = "no llenaste los datos correctamente", response = String.class),
            @ApiResponse(code = 500, message = "error inesperado del sistema")
    })

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> guardarEmpleado(@RequestBody @Validated EmpleadoDTO empleadoDTO) {
        EmpleadoDTO empleadoResponse = iEmpleadoService.crearEmpleado(empleadoDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(empleadoResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> actualizarEmpleado(@RequestBody @Validated EmpleadoDTO empleadoDTO) {
        EmpleadoDTO empleadoResponse = iEmpleadoService.actualizarEmpleado(empleadoDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(empleadoResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> buscarEmpleado(@RequestParam(value = "idEmpleadoDTO") Integer idEmpleadoDTO ) {
        EmpleadoDTO empleadoResponse = iEmpleadoService.buscarEmpleado(idEmpleadoDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(empleadoResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> borrarEmpleado(@RequestBody @Validated EmpleadoDTO empleadoDTO) {
        String empleadoResponse = iEmpleadoService.borrarEmpleado(empleadoDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(empleadoResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
