package bits.current_savings_service.domain.Entity;

import bits.current_savings_service.domain.Audit.Audit;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "organization_department")
public class OrganizationDepartment extends Audit implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dept_code")
    private String deptCode;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;
}

