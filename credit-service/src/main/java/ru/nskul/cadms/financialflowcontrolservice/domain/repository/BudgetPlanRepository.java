package ru.nskul.cadms.financialflowcontrolservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.budget.plan.BudgetPlan;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * Репозиторий планов бюджета.
 */
public interface BudgetPlanRepository extends JpaRepository<BudgetPlan, UUID> {
    List<BudgetPlan> findAllByUserId(UUID userId);
}
