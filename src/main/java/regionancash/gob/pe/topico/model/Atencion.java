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
@Table(name = "atencions")
public class Atencion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "decimal(5,2)")
    private Double peso;

    @Column(columnDefinition = "decimal(5,2)")
    private Double imc;

    @Column(length = 32)
    private String frecuenciaCardiaca;

    @Column(length = 32)
    private String frecuenciaRespiratoria;

    @Column(columnDefinition = "decimal(5,2)")
    private Double talla;

    @Column(length = 32)
    private String temperatura;

    @Column(length =32)
    private String presion;

    @Column(length =32)
    private String saturacion;

    @Column(nullable = false)
    private LocalDate fechaEvaluacion;

    @Column(columnDefinition = "TEXT")
    private String anamnesis;

    @Column(columnDefinition = "TEXT")
    private String evolucionMedica;

    @Column(columnDefinition = "TEXT")
    private String ordenMedica;

    @Column(columnDefinition = "TEXT")
    private String notaEnfermeria;

    @Column(columnDefinition = "TEXT")
    private String interConsulta;

    @Column(length =32)
    private String edadGestacion;

    @Column(length =32)
    private String pulsoMaterno;

    @Column(length =32)
    private String alturaUterina;

    @Column(length =32)
    private String situacion;

    @Column(length =32)
    private String presentacion;

    @Column(length =32)
    private String posicion;

    @Column(length =32)
    private String fcf;

    @Column(length =32)
    private String movimientoFetal;

    @Column(length =32)
    private String cualitativa;

    @Column(length =32)
    private String edema;

    @Column(length =32)
    private String reflejo;

    @Column(length =32)
    private String examenPezon;

    @Column(length =32)
    private String indicadorFierro;

    @Column(length =32)
    private String indicadorCalcio;

    @Column(length =32)
    private String indicadorAcido;

    @Column(length =32)
    private String ecoControl;

    @Column(length =32)
    private String perfilBiofisico;

    @Column(length =32)
    private String cita;

    @Column(length =32)
    private String visitaDomiciliaria;

    @Column(length =32)
    private String planParto;

    @Column(length =32)
    private String lugarAtencion;

    @Column(length =32)
    private String responsableAtencion;

    @Column(length =32)
    private String numeroSis;

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
