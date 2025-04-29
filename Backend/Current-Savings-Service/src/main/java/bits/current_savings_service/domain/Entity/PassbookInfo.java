package bits.current_savings_service.domain.Entity;

import bits.current_savings_service.domain.Audit.Audit;
import bits.current_savings_service.domain.Member.MemberInfo;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "passbook_info")
public class PassbookInfo extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "passbook_no", length = 20, nullable = true)
    private String passbookNo;

    @Column(name = "issue_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date issueDate;

    @ManyToOne
    @JoinColumn(name = "passbook_status_id", nullable = false)
    private PassbookStatus passbookStatus;

    @Column(name = "passbook_price", nullable = false)
    private double passbookPrice = 0;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(name = "status_change")
    @Temporal(TemporalType.TIMESTAMP)
    private Date statusChange;

    @Column(name = "transaction_no", nullable = true)
    private String transactionNo;

    @ManyToOne
    @JoinColumn(name = "member_info_id")
    private MemberInfo memberInfo;

}
