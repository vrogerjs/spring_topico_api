package regionancash.gob.pe.topico.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.topico.model.Atencion;
import regionancash.gob.pe.topico.model.Paciente;

import java.time.LocalDate;
import java.util.List;

public interface IPacienteService extends ICRUD<Paciente, Integer> {
    Page<Paciente> findAllPagination(Pageable page);

    Page<Paciente> searchByParams(String search, Pageable page);

    List<Paciente> searchByModalidadContrato(String modalidadContrato);

    List<String> findAllModalidadContrato();

    List<Paciente> ListAllByEdad(Integer edadIni, Integer edadFin);

}
