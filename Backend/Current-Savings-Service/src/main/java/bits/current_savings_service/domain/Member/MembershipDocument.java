package bits.current_savings_service.domain.Member;

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
@Table(name = "membership_document")
public class MembershipDocument extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "driving_license_reference", length = 255)
    private String drivingLicenseReference;

    @Column(name = "membership_form_reference", length = 255)
    private String membershipFormReference;

    @Column(name = "national_id_reference", length = 255)
    private String nationalIdReference;

    @Column(name = "other_form_reference", length = 255)
    private String otherFormReference;

    @Column(name = "passport_reference", length = 255)
    private String passportReference;

    @Column(name = "photo_id_reference", length = 255)
    private String photoIdReference;

    @Column(name = "survey_form_reference", length = 255)
    private String surveyFormReference;

    @ManyToOne
    @JoinColumn(name = "member_info_id", referencedColumnName = "id")
    private MemberInfo memberInfo; // Assuming MemberInfo is another entity
}

