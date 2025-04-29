package bits.current_savings_service.domain.Office;

import bits.current_savings_service.domain.Audit.Audit;
import bits.current_savings_service.domain.Enums.OfficeOperationType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "office_type")
public class OfficeType extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "office_type_code", length = 10, nullable = false, unique = true)
    private String officeTypeCode;

    @Column(name = "office_type_name", length = 100, nullable = false, unique = true)
    private String officeTypeName;

    @Column(name = "hierarchy_level", nullable = false, unique = true)
    private Integer hierarchyLevel;

    @Column(name = "description")
    private String description;


    @Column(name = "office_op_type")
    @Enumerated(EnumType.STRING)
    private OfficeOperationType officeOpType;
}

