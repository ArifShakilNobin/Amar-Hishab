package bits.current_savings_service.repository.redis;

import bits.current_savings_service.domain.redis.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageRepository extends CrudRepository<Message, String> {
    Optional<Message> findByKeyAndLocale(String key, String locale);
}
