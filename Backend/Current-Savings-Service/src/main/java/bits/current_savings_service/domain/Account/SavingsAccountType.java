package bits.current_savings_service.domain.Account;


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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "savings_account_type")
public class SavingsAccountType extends Audit implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "type_name")
    private String typeName;

    @Column(name = "description")
    private String description;
}