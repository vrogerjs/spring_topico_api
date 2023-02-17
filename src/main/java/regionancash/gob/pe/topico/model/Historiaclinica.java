package regionancash.gob.pe.topico.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "historiaclinicas")
public class Historiaclinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length =8, nullable = false, unique = true)
    private Integer numero;

    @Column(nullable = false, length = 1)
    private Integer activo=1;

    @Column(nullable = false, length = 1)
    private Integer borrado=0;

    @ManyToOne
    @JoinColumn(name="paciente_id", nullable=false)
    private Paciente paciente;

    @JsonIgnore
    @OneToMany(mappedBy="historiaclinica")
    private Set<Psicologica> psicologicas;

    @JsonIgnore
    @OneToMany(mappedBy="historiaclinica")
    private Set<Atencion> atencions;

    @JsonIgnore
    @OneToMany(mappedBy="historiaclinica")
    private Set<Examen> examens;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = true)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;
}
