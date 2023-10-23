package com.sura.bibloteca.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


import com.sura.bibloteca.dto.ElementoPrestableBaseDTO;
import com.sura.bibloteca.entity.ElementoPrestableBaseEntity;
import com.sura.bibloteca.mapping.ElementoPrestableBaseMapping;
import com.sura.bibloteca.repository.IelementoPrestableBaseRepository;
import com.sura.bibloteca.service.IElementoPrestableBaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ElementoPrestableBaseServiceImpl implements IElementoPrestableBaseService {

    private final IelementoPrestableBaseRepository iElementoPrestableBaseRepository;

    @Override
    public ElementoPrestableBaseDTO crearElementoPrestableBase(ElementoPrestableBaseDTO elementoPrestableBaseDTO) {
        ElementoPrestableBaseEntity buscarTitulo = iElementoPrestableBaseRepository
                .findByTitulo(elementoPrestableBaseDTO.getTitulo());
        if (Objects.isNull(buscarTitulo)) {
            ElementoPrestableBaseEntity crearElemento = iElementoPrestableBaseRepository
                    .saveAndFlush(new ElementoPrestableBaseMapping()
                            .elementoPrestableBaseDtoToElementoPrestableBaseEntity(elementoPrestableBaseDTO));
            if (Objects.nonNull(crearElemento)) {
                ElementoPrestableBaseDTO elementoPrestableDTO = new ElementoPrestableBaseMapping()
                        .elementoPrestableBaseEntityToElementoPrestableBaseDTO(crearElemento);
                return elementoPrestableDTO;
            }

        }
        return null;

    }

    @Override
    public ElementoPrestableBaseDTO actualizarElementoPrestableBase(ElementoPrestableBaseDTO elementoPrestableBaseDTO) {
        Optional<ElementoPrestableBaseEntity> buscarElemento = iElementoPrestableBaseRepository
                .findById(elementoPrestableBaseDTO.getIdElementoPrestableBase());

        if (Objects.nonNull(buscarElemento.get())) {
            ElementoPrestableBaseEntity actualizarElemento = iElementoPrestableBaseRepository
                    .saveAndFlush(new ElementoPrestableBaseMapping()
                            .elementoPrestableBaseDtoToElementoPrestableBaseEntity(elementoPrestableBaseDTO));
            if (Objects.nonNull(actualizarElemento)) {
                ElementoPrestableBaseDTO actualizarElementoPrestableDTO = new ElementoPrestableBaseMapping()
                        .elementoPrestableBaseEntityToElementoPrestableBaseDTO(actualizarElemento);
                return actualizarElementoPrestableDTO;
            }

        } else if (Objects.isNull(buscarElemento)) {

        }
        return null;
    }

    @Override
    public ElementoPrestableBaseDTO buscarElementoPrestableBase(Integer idElementoPrestableBaseDTO) {
        Optional<ElementoPrestableBaseEntity> buscarElemento = iElementoPrestableBaseRepository
                .findById(idElementoPrestableBaseDTO);
        if (Objects.nonNull(buscarElemento)) {
            ElementoPrestableBaseDTO buscarElementoPrestableDTO = new ElementoPrestableBaseMapping()
                    .elementoPrestableBaseEntityToElementoPrestableBaseDTO(buscarElemento.get());
            return buscarElementoPrestableDTO;
        }
        return null;
    }

    @Override
    public String borrarElementoPrestableBase(ElementoPrestableBaseDTO elementoPrestableBaseDTO) {
        ElementoPrestableBaseDTO buscarElementoPrestableDTO = buscarElementoPrestableBase(
                elementoPrestableBaseDTO.getIdElementoPrestableBase());
        if (Objects.nonNull(buscarElementoPrestableDTO)) {
            iElementoPrestableBaseRepository
                    .delete(new ElementoPrestableBaseMapping()
                            .elementoPrestableBaseDtoToElementoPrestableBaseEntity(elementoPrestableBaseDTO));
            return "Elemento borrado exitosamente";
        }

        return null;
    }

    @Override
    public List<ElementoPrestableBaseDTO> buscarTodosElementosBaseDTO(
            List<ElementoPrestableBaseDTO> elementoPrestableBaseDTO) {

        List<ElementoPrestableBaseEntity> elementosPrestableEntity = iElementoPrestableBaseRepository.findAll();

        if (!elementosPrestableEntity.isEmpty() && elementosPrestableEntity.size() > 0) {
            List<ElementoPrestableBaseDTO> elementosPrestableDTO = new ElementoPrestableBaseMapping()
                    .listElementoPrestableBaseEntityToElementoPrestableBaseDTO(elementosPrestableEntity);
            return elementosPrestableDTO;
        }
        return null;
    }
}
