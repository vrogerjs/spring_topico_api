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
@Table(name = "files")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDate fechaRegistro;

    @Column(length =256, nullable = false)
    private String name;

    @Column(length =512, nullable = false)
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
