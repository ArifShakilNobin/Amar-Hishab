package bits.current_savings_service.domain.Payment;

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
@Table(name = "mode_of_payment", schema = "public")
public class ModeOfPayment extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mode_description", length = 255)
    private String modeDescription;

    @Column(name = "mode_name", length = 255, nullable = false, unique = true)
    private String modeName;
}
