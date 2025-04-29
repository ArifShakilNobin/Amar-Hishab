package bits.current_savings_service.domain.Entity;

import bits.current_savings_service.domain.Audit.Audit;
import bits.current_savings_service.domain.Member.MemberInfo;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "signature")
public class Signature extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "signature_reference", nullable = false)
    private String signatureReference;

    @ManyToOne
    @JoinColumn(name = "member_info_id")
    private MemberInfo memberInfo;

}
