package ru.gothmog.ws.employes.core.mapper;




import ru.gothmog.ws.employes.core.dto.AbstractDto;
import ru.gothmog.ws.employes.core.model.AbstractEntity;

import java.util.List;

public interface Mapper<E extends AbstractEntity, D extends AbstractDto> {

  E toEntity(D dto);

  D toDto(E entity);

  List<D> toArraysToDto(List<E> inArray);
}
