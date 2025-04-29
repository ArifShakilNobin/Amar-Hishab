package bits.current_savings_service.domain.Member;

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
@Table(name = "contact_info")
public class ContactInfo extends Audit implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "contact_no", nullable = false, length = 20)
    private String contactNo;

    @Column(name = "contact_no_optional", length = 255)
    private String contactNoOptional;

    @ManyToOne
    @JoinColumn(name = "member_info_id", referencedColumnName = "id")
    private MemberInfo memberInfo;

}
