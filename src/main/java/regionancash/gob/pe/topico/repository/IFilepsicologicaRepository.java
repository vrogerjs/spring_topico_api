package regionancash.gob.pe.topico.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import regionancash.gob.pe.topico.model.File;
import regionancash.gob.pe.topico.model.Filepsicologica;

public interface IFilepsicologicaRepository extends IGenericRepo<Filepsicologica, Integer> {
    @Query("SELECT f FROM Filepsicologica f WHERE f.psicologica.id = :id")
    Page<Filepsicologica> searchByIdPsicologica(Pageable page, @Param("id") Integer IdPsicologica);
}
