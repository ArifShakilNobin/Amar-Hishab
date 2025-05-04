package bits.current_savings_service.dto.requests;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaginationRequest implements Serializable {
    private Integer pageNumber = 0;
    private Integer pageSize = 10;
    private String sortBy = "id";
    private String sortOrder = "desc";
}
