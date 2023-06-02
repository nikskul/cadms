package ru.nskul.cadms.financialflowcontrolservice.domain.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseDomainEntity {

    /**
     * Идентификатор сущности.
     */
    @Id
    @GeneratedValue
    @UuidGenerator
    protected UUID id;

    /**
     * Версия.
     */
    @Version
    protected Integer version;

    /**
     * Кем создан.
     */
    @CreatedBy
    protected String createdBy;

    /**
     * Время создания.
     */
    @CreatedDate
    protected Instant createdAt;

    /**
     * Время обновления.
     */
    @LastModifiedDate
    protected Instant updatedAt;

}
