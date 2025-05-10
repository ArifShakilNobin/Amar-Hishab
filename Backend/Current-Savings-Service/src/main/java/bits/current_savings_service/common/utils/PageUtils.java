package bits.current_savings_service.common.utils;

import bits.current_savings_service.dto.requests.PaginationRequest;
import bits.current_savings_service.dto.response.PaginationResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.ObjectUtils;

public class PageUtils {

    public static <E> PaginationResponse<E> mapToPaginationResponseDto(
            Page<E> page, PaginationRequest paginationRequest) {

        PaginationResponse.Pagination pagination = PaginationResponse.Pagination.builder()
                .currentPage(page.getNumber() + 1)
                .pageSize(paginationRequest.getPageSize())
                .totalItems(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .build();

        return PaginationResponse.<E>builder()
                .items(page.getContent())
                .pagination(pagination)
                .build();
    }


    public static Pageable getPageable(PaginationRequest request) {

        Sort sortOrder = getSort(request.getSortOrder(), request.getSortBy());
        Pageable pageable;
        Integer pageSize = request.getPageSize();
        if (request.getPageSize().equals(-1)) {
            pageSize = Integer.MAX_VALUE;
        }
        if (Boolean.FALSE.equals(ObjectUtils.isEmpty(sortOrder))) {
            pageable = PageRequest.of(request.getPageNumber(), pageSize, sortOrder);
        } else {
            pageable = PageRequest.of(request.getPageNumber(), pageSize);
        }
        return pageable;
    }

    private static Sort getSort(String sortOrder, String sortBy) {
        if (ObjectUtils.isEmpty(sortOrder) || ObjectUtils.isEmpty(sortBy)) {
            return null;
        }
        Sort sort;
        switch (sortOrder.toLowerCase()) {
            case "asc":
                sort = Sort.by(Sort.Order.asc(sortBy));
                break;
            case "desc":
                sort = Sort.by(Sort.Order.desc(sortBy));
                break;
            default:
                sort = null;
        }
        return sort;
    }


    public static PaginationRequest mapToPaginationRequest(final Integer pageNumber, final Integer pageSize, final String sortBy, final String sortOrder) {
        final PaginationRequest paginationRequest = new PaginationRequest();
        paginationRequest.setPageNumber(pageNumber);
        paginationRequest.setPageSize(pageSize);
        paginationRequest.setSortBy(sortBy);
        paginationRequest.setSortOrder(sortOrder);
        return paginationRequest;
    }
}