package ru.nskul.cadms.financialflowcontrolservice.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nskul.cadms.financialflowcontrolservice.domain.budget.plan.BudgetPlan;

import java.util.UUID;

/**
 * Репозиторий планов бюджета.
 */
public interface BudgetPlanRepository extends JpaRepository<BudgetPlan, UUID> {
}
