package ru.nskul.cadms.financialflowcontrolservice.domain.model.loan.criteria;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.BaseDomainEntity;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.loan.Loan;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.loan.criteria.enums.CreditRating;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.loan.criteria.enums.IncomeLevel;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.loan.criteria.enums.CreditWorthiness;

/**
 * Модель пользователя.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder(setterPrefix = "with")
@EqualsAndHashCode(callSuper = true)
@Table(name = "loan_criteria")
public class LoanCriteria extends BaseDomainEntity {

    /**
     * Уровень дохода.
     */
    @Enumerated(EnumType.STRING)
    private IncomeLevel incomeLevel;

    /**
     * Кредитная история.
     */
    @Enumerated(EnumType.STRING)
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
    @Enumerated(EnumType.STRING)
    private CreditWorthiness worthiness;

    /**
     * Кредит.
     */
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "loan_id", referencedColumnName = "id")
    private Loan loan;

}
