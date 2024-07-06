package ru.gothmog.ws.employes.core.service.empl.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gothmog.ws.employes.core.dto.empl.EmployDto;
import ru.gothmog.ws.employes.core.mapper.empl.EmployMapper;
import ru.gothmog.ws.employes.core.repository.empl.EmployRepository;
import ru.gothmog.ws.employes.core.service.empl.EmployService;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployServiceImpl implements EmployService {

    private final EmployMapper employMapper;
    private final EmployRepository employRepository;

    @Override
    public EmployDto create(final @NonNull EmployDto dto) {
        return null;
    }

    @Override
    public EmployDto getById(long id) {
        return null;
    }

    @Override
    public EmployDto delete(long id) {
        return null;
    }

    @Override
    public EmployDto update(long id, EmployDto dto) {
        return null;
    }

    @Override
    public List<EmployDto> getListPageToLimit(int page, int limit) {
        return null;
    }

    @Override
    public List<EmployDto> getList() {
        return null;
    }
}
