package ru.nskul.cadms.financialflowcontrolservice.domain.financial.report;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import ru.nskul.cadms.financialflowcontrolservice.domain.BaseDomainEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Модель финансового отчета.
 */
@Entity
@SuperBuilder(setterPrefix = "with")
@EqualsAndHashCode(callSuper = true)
@Table(name = "financial_reports")
public final class FinancialReport extends BaseDomainEntity {

    /**
     * Начало периода отчета.
     */
    private LocalDate startDate;

    /**
     * Конец периода отчета.
     */
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
