package ru.nskul.cadms.financialflowcontrolservice.presentation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.budget.plan.BudgetPlanType;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO плана бюджета.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public final class BudgetPlanDto extends BaseDomainDto {

    /**
     * Название плана.
     */
    private String name;

    /**
     * Тип плана.
     */
    private BudgetPlanType planType;

    /**
     * Сумма планируемых расходов/доходов.
     */
    private BigDecimal amount;

    /**
     * Сумма планируемых расходов/доходов.
     */
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate startDate;

    /**
     * Сумма планируемых расходов/доходов.
     */
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate endDate;

    /**
     * Пользователь.
     */
    private UserDto user;
}
