package ru.nskul.cadms.financialflowcontrolservice.presentation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.loan.LoanStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO займа.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public final class LoanDto extends BaseDomainDto {

    /**
     * Наименование банка.
     */
    private String bankName;

    /**
     * Размер займа.
     */
    private BigDecimal amount;

    /**
     * Коэффициент займа.
     */
    private BigDecimal interestRate;

    /**
     * Срок займа.
     */
    private Integer term;

    /**
     * Статус займа.
     */
    private LoanStatus status;

    /**
     * Дата открытия займа.
     */
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate startDate;

    /**
     * Дата погашения займа.
     */
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate endDate;

    /**
     * Пользователь.
     */
    private UserDto user;
}
