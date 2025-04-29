package bits.current_savings_service.domain.Employee;

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
@Table(name = "entity_category")
public class EntityCategory extends Audit implements Serializable {

    @Column(name = "domain_status")
    private Long domainStatus;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "entity_name", length = 255)
    private String entityName;
}

