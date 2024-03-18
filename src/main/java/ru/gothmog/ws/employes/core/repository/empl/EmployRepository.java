package ru.gothmog.ws.employes.core.repository.empl;

import org.springframework.stereotype.Repository;
import ru.gothmog.ws.employes.core.model.empl.Employ;
import ru.gothmog.ws.employes.core.repository.BaseRepository;

@Repository
public interface EmployRepository extends BaseRepository<Employ, Long> {}
