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
@Table(name = "collection_frequency")
public class CollectionFrequency extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "country_id", nullable = false)
    private Long countryId;

    @Column(name = "frequency_id", nullable = false)
    private Long frequencyId;

    @Column(name = "project_info_id", nullable = false)
    private Long projectInfoId;

    @Column(name = "status_id")
    private Long statusId;

    @Column(name = "description", length = 255)
    private String description;
}
