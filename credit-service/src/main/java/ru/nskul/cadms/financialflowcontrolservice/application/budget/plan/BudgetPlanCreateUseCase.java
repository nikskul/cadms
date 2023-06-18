package ru.nskul.cadms.financialflowcontrolservice.application.budget.plan;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.budget.plan.BudgetPlan;
import ru.nskul.cadms.financialflowcontrolservice.domain.repository.BudgetPlanRepository;
import ru.nskul.cadms.financialflowcontrolservice.domain.repository.UserRepository;
import ru.nskul.cadms.financialflowcontrolservice.infrastructure.mapper.BudgetPlanMapper;
import ru.nskul.cadms.financialflowcontrolservice.presentation.dto.BudgetPlanDto;

/**
 * Use case создания займа.
 */
@Component
@RequiredArgsConstructor
public class BudgetPlanCreateUseCase {
    private final BudgetPlanRepository repository;
    private final BudgetPlanMapper mapper;

    private final UserRepository userRepository;

    public BudgetPlan exec(BudgetPlanDto dto) {

        if (dto.getUser() == null) {
            throw new IllegalArgumentException("User не должен быть пустым!");
        }
        var user = userRepository.getReferenceById(dto.getUser().getId());

        var budgetPlan = mapper.convert(new BudgetPlan(), dto);
        budgetPlan.setUser(user);

        return repository.save(budgetPlan);
    }
}
