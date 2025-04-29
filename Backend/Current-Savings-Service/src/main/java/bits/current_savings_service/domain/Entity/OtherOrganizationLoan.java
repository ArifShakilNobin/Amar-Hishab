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
@Table(name = "other_organization_loan")
public class OtherOrganizationLoan extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "loan_amount")
    private Float loanAmount;

    @ManyToOne
    @JoinColumn(name = "family_info_id")
    private FamilyInfo familyInfo; // Assuming FamilyInfo is another entity


    @Column(name = "organization_name")
    private String organizationName;
}

