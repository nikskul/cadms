package ru.nskul.cadms.financialflowcontrolservice.presentation.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.transaction.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO транзакции.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public final class TransactionDto extends BaseDomainDto {

    /**
     * Размер транзакции.
     */
    private BigDecimal amount;

    /**
     * Тип транзакции.
     */
    private TransactionType type;

    /**
     * Дата транзакции.
     */
    private LocalDate date;

    /**
     * Описание транзакции.
     */
    private String description;

    /**
     * Пользователь.
     */
    private UserDto user;
}
