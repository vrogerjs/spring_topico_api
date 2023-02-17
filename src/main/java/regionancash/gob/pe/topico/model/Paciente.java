package regionancash.gob.pe.topico.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length =512, nullable = false, unique = true)
    private String apeNomb;

    @Column(length =32, nullable = false)
    private String tipoDocumento;

    @Column(length =8, nullable = false, unique = true)
    private String nroDocumento;

    @Column(length =16, nullable = false)
    private String genero;

    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    @Column(length =256, nullable = false)
    private String modalidadContrato;

    @Column(length =16, nullable = false)
    private String celular;

   @Column(nullable = false, length = 1)
    private Integer activo=1;

    @Column(nullable = false, length = 1)
    private Integer borrado=0;

    @ManyToOne
    @JoinColumn(name="oficina_id", nullable=false)
    private Oficina oficina;

    @JsonIgnore
    @OneToMany(mappedBy="paciente")
    private Set<Historiaclinica> historiaclinicas;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = true)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;
}
