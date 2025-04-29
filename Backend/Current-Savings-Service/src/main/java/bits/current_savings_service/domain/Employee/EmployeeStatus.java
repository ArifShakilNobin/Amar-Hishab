package bits.current_savings_service.domain.Employee;

import bits.current_savings_service.domain.Audit.Audit;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "employee_status")
public class EmployeeStatus extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name; // Provision, Permanent, Inactive

    @Column(name = "description")
    private String description;

    @Column(name = "short_name")
    private String shortName;
}