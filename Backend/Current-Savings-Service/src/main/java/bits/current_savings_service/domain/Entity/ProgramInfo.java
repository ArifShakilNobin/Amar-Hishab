package bits.current_savings_service.domain.Entity;


import bits.current_savings_service.domain.Audit.Audit;
import bits.current_savings_service.domain.Employee.EntityCategory;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "program_info")
public class ProgramInfo extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "program_code")
    private String programCode;

    @Column(name = "program_ref_code")
    private String programRefCode;

    @Column(name = "program_name", nullable = false, unique = true, length = 150)
    private String programName;

    @Column(name = "program_short_name", length = 150)
    private String programShortName;

    @Column(name = "program_description", length = 255)
    private String programDescription;

    @ManyToOne
    @JoinColumn(name = "operation_type_id")
    private OperationType operationType;

    @ManyToOne
    @JoinColumn(name = "program_type_id")
    private ProgramType programType;

    @ManyToOne
    @JoinColumn(name = "entity_category_id")
    private EntityCategory entityCategory;

    @Column(name = "has_field_office")
    private boolean hasFieldOffice;

    @Column(name = "setup_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date setupDate;

    @Column(name = "effective_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date effectiveDate;

    @Column(name = "domain_status_id")
    private long domainStatusId;


}
