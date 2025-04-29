package bits.current_savings_service.domain.Audit;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class Audit {
    @CreatedBy
    protected Long createdBy;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    protected Date createdDate;

    @LastModifiedBy
    protected Long lastModifiedBy;

    @LastModifiedDate
    protected Date lastModifiedDate;
}
