package regionancash.gob.pe.topico.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import regionancash.gob.pe.topico.model.File;

public interface IFileRepository extends IGenericRepo<File, Integer>{
    @Query("SELECT f FROM File f WHERE f.historiaclinica.id = :id")
    Page<File> searchByIdHistoriaclinica(Pageable page, @Param("id") Integer IdHistoriaclinica);
}
