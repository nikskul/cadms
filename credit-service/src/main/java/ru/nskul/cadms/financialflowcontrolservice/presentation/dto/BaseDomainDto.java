package ru.nskul.cadms.financialflowcontrolservice.presentation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.UUID;

@Data
@SuperBuilder
@NoArgsConstructor
public abstract class BaseDomainDto {

    /**
     * Идентификатор сущности.
     */
    protected UUID id;

    /**
     * Версия.
     */
    @JsonIgnore
    protected Integer version;

    /**
     * Кем создан.
     */
    @JsonIgnore
    protected String createdBy;

    /**
     * Время создания.
     */
    @JsonIgnore
    protected Instant createdAt;

    /**
     * Время обновления.
     */
    @JsonIgnore
    protected Instant updatedAt;

}
