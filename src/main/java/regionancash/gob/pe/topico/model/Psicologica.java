package regionancash.gob.pe.topico.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.cglib.core.Local;
import org.w3c.dom.Text;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "psicologicas")
public class Psicologica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String motivo;

    @Column(columnDefinition = "TEXT")
    private String problemaActual;

    @Column(columnDefinition = "TEXT")
    private String anamnesis;

    @Column(columnDefinition = "TEXT")
    private String diagnostico;

    @Column(columnDefinition = "TEXT")
    private String recomendacion;

    private LocalDate proximaCita;

    @Column(nullable = false)
    private LocalDate fechaEvaluacion;

    @Column(nullable = false, length = 1)
    private Integer activo=1;

    @Column(nullable = false, length = 1)
    private Integer borrado=0;

    @ManyToOne
    @JoinColumn(name="historiaclinica_id", nullable=false)
    private Historiaclinica historiaclinica;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = true)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;
}
