package regionancash.gob.pe.topico.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import regionancash.gob.pe.topico.model.Atencion;

public interface IAtencionRepository extends IGenericRepo<Atencion, Integer> {
    @Query("SELECT a FROM Atencion a WHERE a.historiaclinica.id = :id")
    Page<Atencion> searchByIdHistoriaclinica(Pageable page, @Param("id") Integer IdHistoriaclinica);
}
