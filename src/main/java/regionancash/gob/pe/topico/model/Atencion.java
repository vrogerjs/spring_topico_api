package regionancash.gob.pe.topico.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "atencions")
public class Atencion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "decimal(5,2)", nullable = false)
    private Double peso;

    @Column(columnDefinition = "decimal(5,2)", nullable = false)
    private Double imc;

    @Column(length =8, nullable = false)
    private String frecuenciaCardiaca;

    @Column(length =8, nullable = false)
    private String frecuenciaRespiratoria;

    @Column(columnDefinition = "decimal(5,2)", nullable = false)
    private Double talla;

    @Column(length =8, nullable = false)
    private String temperatura;

    @Column(length =16, nullable = false)
    private String presion;

    @Column(length =16, nullable = false)
    private String saturacion;

    @Column(nullable = false)
    private LocalDate fechaEvaluacion;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String anamnesis;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String evolucionMedica;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String ordenMedica;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String notaEnfermeria;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String examenComplementario;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String interConsulta;

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
