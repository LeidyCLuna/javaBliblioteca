package com.sura.bibloteca.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sura.bibloteca.dto.ElementoPrestableBaseDTO;
import com.sura.bibloteca.service.IElementoPrestableBaseService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

import java.awt.*;

@AllArgsConstructor
@RestController
@RequestMapping("/biblioteca")
@CrossOrigin(origins = "*")
@Log4j2
public class ElementoPrestableBaseController {

    private final IElementoPrestableBaseService iElementoPrestableBaseService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok. se guardo correctamente el elemento", response = ElementoPrestableBaseDTO.class),
            @ApiResponse(code = 400, message = "no llenaste los datos correctamente", response = String.class),
            @ApiResponse(code = 500, message = "error inesperado del sistema")
    })

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> guardarElementoPrestableBase(@RequestBody @Validated ElementoPrestableBaseDTO elementoPrestableBaseDTO) {
        ElementoPrestableBaseDTO elementoPrestableBaseResponse = iElementoPrestableBaseService.crearElementoPrestableBase(elementoPrestableBaseDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(elementoPrestableBaseResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> actualizarElementoPrestableBase(@RequestBody @Validated ElementoPrestableBaseDTO elementoPrestableBaseDTO) {
        ElementoPrestableBaseDTO elementoPrestableBaseResponse = iElementoPrestableBaseService.actualizarElementoPrestableBase(elementoPrestableBaseDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(elementoPrestableBaseResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    //value = "/{idElementoPrestableBaseDTO}",
    //value = "/{idElementoPrestableBaseDTO}/{id}",
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> buscarElementoPrestableBase(@RequestParam(value = "idElementoPrestableBaseDTO") Integer idElementoPrestableBaseDTO ) {
        ElementoPrestableBaseDTO elementoPrestableBaseResponse = iElementoPrestableBaseService.buscarElementoPrestableBase(idElementoPrestableBaseDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(elementoPrestableBaseResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> borrarElementoPrestableBase(@RequestBody @Validated ElementoPrestableBaseDTO elementoPrestableBaseDTO) {
        String elementoPrestableBaseResponse = iElementoPrestableBaseService.borrarElementoPrestableBase(elementoPrestableBaseDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(elementoPrestableBaseResponse));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
