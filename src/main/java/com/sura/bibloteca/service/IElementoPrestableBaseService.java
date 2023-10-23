package com.sura.bibloteca.service;

import java.util.List;

import com.sura.bibloteca.dto.ElementoPrestableBaseDTO;

public interface IElementoPrestableBaseService {

	ElementoPrestableBaseDTO crearElementoPrestableBase(ElementoPrestableBaseDTO elementoPrestableBaseDTO);

	ElementoPrestableBaseDTO actualizarElementoPrestableBase(ElementoPrestableBaseDTO elementoPrestableBaseDTO);

	ElementoPrestableBaseDTO buscarElementoPrestableBase(Integer idElementoPrestableBaseDTO);

	String borrarElementoPrestableBase(ElementoPrestableBaseDTO elementoPrestableBaseDTO);

	List<ElementoPrestableBaseDTO> buscarTodosElementosBaseDTO(List<ElementoPrestableBaseDTO> elementoPrestableBaseDTO);

}
