package bits.current_savings_service.domain.Entity;

import bits.current_savings_service.domain.Audit.Audit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "interest_calculation_frequency")
public class InterestCalculationFrequency extends Audit implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "frequency_name", length = 255, unique = true, nullable = false)
    private String frequencyName;
}

