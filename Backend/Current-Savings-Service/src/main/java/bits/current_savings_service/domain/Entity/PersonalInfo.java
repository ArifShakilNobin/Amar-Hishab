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
@Table(name = "personal_info")
public class PersonalInfo extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "salutation_id", referencedColumnName = "id", nullable = true)
    private Salutation salutation;

    @Column(name = "national_id", length = 17, nullable = true)
    private String nationalId;

    @Column(name = "smart_card_id", length = 10, nullable = true)
    private String smartCardId;

    @Column(name = "passport_no", length = 30, nullable = true)
    private String passportNo;

    @Column(name = "driving_license_no", length = 30, nullable = true)
    private String drivingLicenseNo;

    @Column(name = "photo_id_no", length = 30, nullable = true)
    private String photoIdNo;

    @Column(name = "gender_id", nullable = false)
    private Long genderId;

    @Column(name = "marital_status_id", nullable = false)
    private Long maritalStatusId;

    @Column(name = "age", nullable = true)
    private int age;

    @Column(name = "biometric_status", nullable = true)
    private int biometricStatus;

    @ManyToOne
    @JoinColumn(name = "occupation_id", referencedColumnName = "id", nullable = true)
    private Occupation occupation;

    @Column(name = "date_of_birth", nullable = true)
    private Date dateOfBirth;

    @Column(name = "father_name", length = 50, nullable = true)
    private String fatherName; // Father or husband name

    @Column(name = "mother_name", length = 50, nullable = true)
    private String motherName;

    @Column(name = "spouse_name", length = 50, nullable = true)
    private String spouseName;

    @Column(name = "sp_date_of_birth", nullable = true)
    private Date spDateOfBirth;

    @Column(name = "sp_national_id", length = 17, nullable = true)
    private String spNationalId;

    @Column(name = "sp_smart_card_id", length = 10, nullable = true)
    private String spSmartCardId;

    @Column(name = "sp_passport_no", length = 30, nullable = true)
    private String spPassportNo;

    @Column(name = "sp_photo_id_no", length = 30, nullable = true)
    private String spPhotoIdNo;

    @Column(name = "bikash_wallet_no", nullable = true)
    private String bikashWalletNo;

    @Column(name = "rocket_wallet_no", nullable = true)
    private String rocketWalletNo;

    @Column(name = "referral_info_id", nullable = true)
    private Long referralInfoId;

    @Column(name = "photo_reference", nullable = true)
    private String photoReference;

    @Column(name = "other_id_type_id", nullable = true)
    private Byte otherIdTypeId;

    @Column(name = "other_id_type_no", nullable = true)
    private String otherIdTypeNo;

    @Column(name = "expiry_date", nullable = true)
    private Date expiryDate;

    @Column(name = "place_of_issuing_country", nullable = true)
    private String placeOfIssuingCountry;

    @Column(name = "is_person_with_disability", nullable = true)
    private boolean isPersonWithDisability;

    @ManyToOne
    @JoinColumn(name = "member_info_id", referencedColumnName = "id")
    private MemberInfo memberInfo;


}
