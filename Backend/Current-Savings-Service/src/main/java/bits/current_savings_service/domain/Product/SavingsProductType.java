package bits.current_savings_service.domain.Product;

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
@Table(name = "savings_product_type")
public class SavingsProductType extends Audit implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "type_name", nullable = true)
    private String typeName;

    @Column(name = "description", nullable = true)
    private String description;

}
