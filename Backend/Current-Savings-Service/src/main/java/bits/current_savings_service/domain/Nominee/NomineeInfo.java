package bits.current_savings_service.domain.Nominee;

import bits.current_savings_service.domain.Audit.Audit;
import bits.current_savings_service.domain.Member.MemberInfo;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "nominee_info")
public class NomineeInfo extends Audit implements Serializable {

    @Id
    private Long id;

    @Column(name = "age")
    private Integer age;

    @Column(name = "share_percent")
    private Double sharePercent;

    @Column(name = "date_of_birth")
    private LocalDateTime dateOfBirth;


    @Column(name = "contact_no", length = 255)
    private String contactNo;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "national_id", length = 255)
    private String nationalId;

    @Column(name = "passport_no", length = 255)
    private String passportNo;

    @Column(name = "photo_id_no", length = 255)
    private String photoIdNo;

    @Column(name = "photo_reference", length = 255)
    private String photoReference;

    @Column(name = "smart_card_id", length = 255)
    private String smartCardId;

    @ManyToOne
    @JoinColumn(name = "member_info_id", referencedColumnName = "id")
    private MemberInfo memberInfo;

    @ManyToOne
    @JoinColumn(name = "relationship_id", referencedColumnName = "id")
    private Relationship relationship;
}

