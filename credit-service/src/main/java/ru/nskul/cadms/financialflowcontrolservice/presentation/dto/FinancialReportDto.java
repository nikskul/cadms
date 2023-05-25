package ru.nskul.cadms.financialflowcontrolservice.presentation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO финансового отчета.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public final class FinancialReportDto extends BaseDomainDto {

    /**
     * Начало периода отчета.
     */
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate startDate;

    /**
     * Конец периода отчета.
     */
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate endDate;

    /**
     * Доходы за период.
     */
    private BigDecimal income;

    /**
     * Траты за период.
     */
    private BigDecimal expenses;

    /**
     * Долговая нагрузка на конец периода.
     */
    private BigDecimal loans;

    /**
     * Сумма накоплений за период.
     */
    private BigDecimal savings;

    /**
     * Общая стоимость активов на конец периода.
     */
    private BigDecimal totalAssets;

    /**
     * Общая сумма долгов на конец периода.
     */
    private BigDecimal totalLiabilities;

    /**
     * Чистая стоимость капитала на конец периода.
     * {@summary netWorth = totalAssets - totalLiabilities}
     */
    private BigDecimal netWorth;
}
