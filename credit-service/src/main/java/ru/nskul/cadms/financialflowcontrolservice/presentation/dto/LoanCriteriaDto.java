package ru.nskul.cadms.financialflowcontrolservice.presentation.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.loan.criteria.enums.CreditRating;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.loan.criteria.enums.CreditWorthiness;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.loan.criteria.enums.IncomeLevel;

/**
 * DTO займа.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public final class LoanCriteriaDto extends BaseDomainDto {

    /**
     * Уровень дохода.
     */
    private IncomeLevel incomeLevel;

    /**
     * Кредитная история.
     */
    private CreditRating creditRating;

    /**
     * Возраст.
     */
    private Integer personAge;

    /**
     * Стаж работы.
     */
    private Integer workExperience;

    /**
     * Оценка кредита.
     */
    private CreditWorthiness worthiness;

    /**
     * Кредит.
     */
    private LoanDto loan;
}
