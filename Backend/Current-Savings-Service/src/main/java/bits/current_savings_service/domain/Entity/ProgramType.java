package bits.current_savings_service.domain.Entity;


import bits.current_savings_service.domain.Audit.Audit;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "program_type")
public class ProgramType extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type_name")
    private String typeName;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "domain_status_id", nullable = false)
    private DomainStatus domainStatus;
}
