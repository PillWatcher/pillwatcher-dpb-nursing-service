package br.com.pillwatcher.dpb.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {

    @CreatedDate
    @CreationTimestamp
    @Column(name = "INCLUSION_DATE", columnDefinition = "TIMESTAMP")
    protected LocalDateTime inclusionDate;

    @LastModifiedDate
    @UpdateTimestamp
    @Column(name = "UPDATE_DATE", columnDefinition = "TIMESTAMP")
    protected LocalDateTime updateDate;

}
