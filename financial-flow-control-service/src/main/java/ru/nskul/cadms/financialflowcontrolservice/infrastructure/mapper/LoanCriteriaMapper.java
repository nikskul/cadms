package ru.nskul.cadms.financialflowcontrolservice.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.loan.criteria.LoanCriteria;
import ru.nskul.cadms.financialflowcontrolservice.presentation.dto.LoanCriteriaDto;

@Mapper(
        config = AuditFieldsConfigMapper.class,
        componentModel = "spring"
)
public interface LoanCriteriaMapper {

    /**
     * Конвертация в DTO.
     *
     * @param entity сущность
     * @return DTO
     */
    LoanCriteriaDto convert(LoanCriteria entity);

    /**
     * Конвертация в Entity.
     *
     * @param entity модель пользователя
     * @param dto    DTO пользователя
     * @return Entity пользователя
     */
    LoanCriteria convert(@MappingTarget LoanCriteria entity, LoanCriteriaDto dto);
}
