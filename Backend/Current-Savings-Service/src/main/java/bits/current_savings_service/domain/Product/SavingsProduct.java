package bits.current_savings_service.domain.Product;

import bits.current_savings_service.domain.Audit.Audit;
import bits.current_savings_service.domain.Entity.Country;
import bits.current_savings_service.domain.Entity.InterestRateType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "savings_product")
public class SavingsProduct extends Audit implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    private Country country;

    @Column(name = "product_code", nullable = false)
    private String productCode;

    @Column(name = "product_ref_code")
    private String productRefCode;

    @Column(name = "product_name", nullable = false, length = 150)
    private String productName;

    @Column(name = "setup_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date setupDate;

    @ManyToOne
    @JoinColumn(name = "product_type_id", referencedColumnName = "id", nullable = false)
    private SavingsProductType productType;

    @Column(name = "interest_rate", nullable = false)
    private double interestRate;

    @ManyToOne
    @JoinColumn(name = "rate_type_id", referencedColumnName = "id", nullable = false)
    private InterestRateType rateType;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "savings_product_sub_type_id")
    private long savingsProductSubTypeId;

    @Column(name = "savings_product_category_id", nullable = false)
    private int savingsProductCategoryId; // 0: Unknown, 1: MoneyPlant

    @Column(name = "client_percentage_lower", nullable = false)
    private int clientPercentageLower;

    @Column(name = "client_percentage_upper", nullable = false)
    private int clientPercentageUpper;

    @Column(name = "profit_payment_day")
    private Integer profitPaymentDay;

    @Column(name = "has_match_fund", nullable = false)
    private boolean hasMatchFund;

    @Column(name = "domain_status_id")
    private long domainStatusId;

}

