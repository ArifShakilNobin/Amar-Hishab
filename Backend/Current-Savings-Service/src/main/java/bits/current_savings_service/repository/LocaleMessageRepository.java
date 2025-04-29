package bits.current_savings_service.repository;

import bits.current_savings_service.domain.Entity.LocaleMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocaleMessageRepository extends JpaRepository<LocaleMessage, Long> {
    LocaleMessage findLocaleMessageByLocale(String locale);
}
