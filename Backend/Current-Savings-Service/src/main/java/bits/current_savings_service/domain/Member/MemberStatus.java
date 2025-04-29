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
@Table(name = "member_status")
public class MemberStatus extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "name", length = 255, nullable = false, unique = true)
    private String name;
}

