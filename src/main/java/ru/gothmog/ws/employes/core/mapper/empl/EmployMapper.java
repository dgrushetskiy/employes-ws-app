package ru.gothmog.ws.employes.core.mapper.empl;

import ru.gothmog.ws.employes.core.dto.empl.EmployDto;
import ru.gothmog.ws.employes.core.mapper.AbstractMapper;
import ru.gothmog.ws.employes.core.mapper.MapperConverter;
import ru.gothmog.ws.employes.core.model.empl.Employ;

@MapperConverter
public class EmployMapper extends AbstractMapper<Employ, EmployDto> {

    public EmployMapper() {
        super(Employ.class, EmployDto.class);
    }
}
