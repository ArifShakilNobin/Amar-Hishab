package bits.current_savings_service.domain.Nominee;

import bits.current_savings_service.domain.Audit.Audit;
import bits.current_savings_service.domain.Entity.DomainStatus;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "relationship")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Relationship extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 50)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "is_relative")
    private Boolean isRelative;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private DomainStatus status;
}
