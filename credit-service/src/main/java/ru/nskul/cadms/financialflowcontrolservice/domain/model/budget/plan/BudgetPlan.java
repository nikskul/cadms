package ru.nskul.cadms.financialflowcontrolservice.domain.model.budget.plan;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.BaseDomainEntity;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.user.User;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder(setterPrefix = "with")
@EqualsAndHashCode(callSuper = true)
@Table(name = "budget_plans")
public final class BudgetPlan extends BaseDomainEntity {

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
    private LocalDate startDate;

    /**
     * Сумма планируемых расходов/доходов.
     */
    private LocalDate endDate;

    /**
     * Пользователь.
     */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
