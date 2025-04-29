package bits.current_savings_service.domain.Member;

import bits.current_savings_service.domain.Audit.Audit;
import bits.current_savings_service.domain.Common.AddressTitle;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member_address")
public class MemberAddress extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "address_title_id", nullable = false)
    private AddressTitle addressTitle;

    @Column(name = "address", nullable = true)
    private String address;

    @Column(name = "country_id", nullable = true)
    private Long countryId;

    @Column(name = "city_id", nullable = true)  // city id becomes district id
    private Long cityId;

    @Column(name = "thana_id", nullable = true)
    private Long thanaId;

    @Column(name = "zip_code", nullable = true, length = 8)
    private String zipCode;

    @Transient
    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "contact_info_id")
    private ContactInfo contactInfo;
}
