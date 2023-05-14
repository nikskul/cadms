package ru.nskul.cadms.financialflowcontrolservice.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@MappedSuperclass
@EqualsAndHashCode
public abstract class BaseDomainEntity {

    /**
     * Идентификатор сущности.
     */
    @Id
    @GeneratedValue(generator = "UUIDGenerator",
    strategy = GenerationType.UUID)
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
