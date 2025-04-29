package bits.current_savings_service.repository;

import bits.current_savings_service.domain.Office.PhysicalOfficeInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysicalOfficeRepository extends JpaRepository<PhysicalOfficeInfo, Long> {

    Page<PhysicalOfficeInfo> findAll(Pageable pageable);
}
