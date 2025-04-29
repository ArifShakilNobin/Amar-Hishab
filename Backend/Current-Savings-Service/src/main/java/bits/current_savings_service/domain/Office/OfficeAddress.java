package bits.current_savings_service.domain.Office;

import bits.current_savings_service.domain.Audit.Audit;
import bits.current_savings_service.domain.Entity.City;
import bits.current_savings_service.domain.Entity.DomainStatus;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "office_address")
public class OfficeAddress extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "address_line1")
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "zip_code")
    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private DomainStatus status;

    @Column(name = "province_info_id")
    private Long provinceInfoId;

    @Column(name = "division_info_id")
    private Long divisionInfoId;

    @Column(name = "district_info_id")
    private Long districtInfoId;

    @Column(name = "tehsil_info_id")
    private Long tehsilInfoId;
}
