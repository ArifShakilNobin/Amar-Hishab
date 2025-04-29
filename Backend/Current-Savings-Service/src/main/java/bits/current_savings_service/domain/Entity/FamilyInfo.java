package bits.current_savings_service.domain.Entity;

import bits.current_savings_service.domain.Audit.Audit;
import bits.current_savings_service.domain.Member.MemberInfo;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "family_info")
public class FamilyInfo extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "daughter_no")
    private Integer daughterNo;

    @Column(name = "earning_member_no")
    private Integer earningMemberNo;

    @Column(name = "female_no")
    private Integer femaleNo;

    @Column(name = "is_family_loan")
    private Boolean isFamilyLoan;

    @Column(name = "is_tax_payer")
    private Boolean isTaxPayer;

    @Column(name = "male_no")
    private Integer maleNo;

    @Column(name = "other_org_member_no")
    private Integer otherOrgMemberNo;

    @Column(name = "son_no")
    private Integer sonNo;


    @Column(name = "house_hold_head_name", length = 50)
    private String houseHoldHeadName;

    @ManyToOne
    @JoinColumn(name = "member_info_id", referencedColumnName = "id")
    private MemberInfo memberInfo;
}

