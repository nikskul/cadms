package ru.nskul.cadms.financialflowcontrolservice.application.budget.plan;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.budget.plan.BudgetPlan;
import ru.nskul.cadms.financialflowcontrolservice.domain.repository.BudgetPlanRepository;
import ru.nskul.cadms.financialflowcontrolservice.infrastructure.mapper.BudgetPlanMapper;
import ru.nskul.cadms.financialflowcontrolservice.presentation.dto.BudgetPlanDto;
import ru.nskul.cadms.financialflowcontrolservice.presentation.response.BaseOperationResponse;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BudgetPlanService {

    private final BudgetPlanRepository repository;

    private final BudgetPlanMapper mapper;

    private final BudgetPlanCreateUseCase createUseCase;

    public List<BudgetPlanDto> getAllByUser(UUID userId) {
        return repository.findAllByUserId(userId)
                .stream()
                .map(mapper::convert)
                .toList();
    }

    public BudgetPlanDto getById(UUID id) {
        return mapper.convert(repository.findById(id).orElseThrow(
                () -> new RuntimeException("Budget plan with id " + id + " not exist")
        ));
    }

    @Transactional
    public BaseOperationResponse create(BudgetPlanDto dto) {
        createUseCase.exec(dto);
        return BaseOperationResponse.ok();
    }
}
