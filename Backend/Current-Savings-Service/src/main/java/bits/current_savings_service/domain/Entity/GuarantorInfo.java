package bits.current_savings_service.domain.Entity;

import bits.current_savings_service.domain.Audit.Audit;
import bits.current_savings_service.domain.Member.MemberInfo;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "guarantor_info")
public class GuarantorInfo extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer age;

    @Column(name = "domain_status_id")
    private Integer domainStatusId;

    @Column(name = "date_of_birth")
    private LocalDateTime dateOfBirth;

    @Column(name = "guarantor_name", nullable = false, length = 50)
    private String guarantorName;

    @Column(name = "national_id", length = 255)
    private String nationalId;

    @Column(name = "scanned_file_name", length = 255)
    private String scannedFileName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_info_id", referencedColumnName = "id")
    private MemberInfo memberInfo;

    @Column(name = "relationship_id")
    private Long relationshipId;
}
