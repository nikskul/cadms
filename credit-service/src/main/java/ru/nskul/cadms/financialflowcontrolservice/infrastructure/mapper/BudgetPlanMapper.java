package ru.nskul.cadms.financialflowcontrolservice.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.budget.plan.BudgetPlan;
import ru.nskul.cadms.financialflowcontrolservice.presentation.dto.BudgetPlanDto;

@Mapper(
        config = AuditFieldsConfigMapper.class,
        componentModel = "spring"
)
public interface BudgetPlanMapper {

    /**
     * Конвертация в DTO.
     *
     * @param entity
     * @return DTO
     */
    BudgetPlanDto convert(BudgetPlan entity);

    /**
     * Конвертация в Entity.
     *
     * @param entity модель
     * @param dto    DTO
     * @return Entity
     */
    BudgetPlan convert(@MappingTarget BudgetPlan entity, BudgetPlanDto dto);
}
