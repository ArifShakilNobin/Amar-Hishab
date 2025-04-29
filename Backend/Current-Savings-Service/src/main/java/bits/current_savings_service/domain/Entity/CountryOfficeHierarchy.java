package bits.current_savings_service.domain.Entity;

import bits.current_savings_service.domain.Audit.Audit;
import bits.current_savings_service.domain.Office.OfficeType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "country_office_hierarchy")
public class CountryOfficeHierarchy extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "office_hierarchy_level")
    private Integer officeHierarchyLevel;

    @ManyToOne
    @JoinColumn(name = "country_of_office_id", nullable = false)
    private Country countryOfOffice;

    @Column(name = "effective_date")
    private Timestamp effectiveDate;

    @ManyToOne
    @JoinColumn(name = "hierarchy_status_id", nullable = false)
    private DomainStatus hierarchyStatus;

    @ManyToOne
    @JoinColumn(name = "office_type_id", nullable = false)
    private OfficeType officeType;

    @Column(name = "setup_date")
    private Timestamp setupDate;

    @Column(name = "office_code", length = 10)
    private String officeCode;

    @Column(name = "office_name", length = 100)
    private String officeName;

    @Column(name = "description", length = 255)
    private String description;
}
