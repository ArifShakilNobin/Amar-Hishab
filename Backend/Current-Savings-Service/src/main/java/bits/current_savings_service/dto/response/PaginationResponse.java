package bits.current_savings_service.dto.response;

import lombok.*;

import java.util.List;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaginationResponse<T> {
    private List<T> items;

    @Builder.Default
    private Pagination pagination = new Pagination();

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Pagination {
        private int currentPage;
        private int pageSize;
        private long totalItems;
        private int totalPages;
    }
}