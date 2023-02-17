package regionancash.gob.pe.topico.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "examens")
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length =1024, nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String descripcion;

    @Column(length =1024, nullable = false)
    private String urlDocumento;

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
