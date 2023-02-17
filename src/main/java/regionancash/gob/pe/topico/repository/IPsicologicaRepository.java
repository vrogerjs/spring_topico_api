package regionancash.gob.pe.topico.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import regionancash.gob.pe.topico.model.Psicologica;

public interface IPsicologicaRepository extends IGenericRepo<Psicologica, Integer> {
    @Query("SELECT p FROM Psicologica p WHERE p.historiaclinica.id = :id")
    Page<Psicologica> searchByIdHistoriaclinica(@Param("id") Integer IdHistoriaclinica, Pageable page);
}
