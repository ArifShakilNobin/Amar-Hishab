package bits.current_savings_service.domain.Entity;

import bits.current_savings_service.domain.Audit.Audit;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "country")
public class Country extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // Assuming City is another entity, creating a one-to-many relationship
    @OneToMany(mappedBy = "country")
    private Set<City> nCities;

    @Column(name = "name", nullable = false, length = 50, unique = true)
    private String name;

    @Column(name = "code", nullable = false, length = 10, unique = true)
    private String code;

    @Column(name = "short_name", length = 3)
    private String shortName;

    @Column(name = "short_code")
    private String shortCode;

    @Column(name = "calling_code", nullable = false, length = 10)
    private String callingCode;

    @Column(name = "has_operation")
    private boolean hasOperation = true;

    @Column(name = "local_currency_name", nullable = false, length = 50)
    private String localCurrencyName;

    @Column(name = "foreign_currency_name", nullable = false, length = 50)
    private String foreignCurrencyName;

    @Column(name = "minimum_denomination", nullable = false)
    private float minimumDenomination;

    @Column(name = "time_zone", nullable = false)
    private String timeZone;

}

