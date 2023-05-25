package ru.nskul.cadms.financialflowcontrolservice.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.loan.Loan;
import ru.nskul.cadms.financialflowcontrolservice.presentation.dto.LoanDto;

/**
 * Конвертер займов.
 */
@Mapper(
        config = AuditFieldsConfigMapper.class,
        componentModel = "spring"
)
public interface LoanMapper {

    /**
     * Конвертация в DTO.
     *
     * @param entity сущность
     * @return DTO
     */
    LoanDto convert(Loan entity);

    /**
     * Конвертация в Entity.
     *
     * @param entity модель пользователя
     * @param dto    DTO пользователя
     * @return Entity пользователя
     */
    Loan convert(@MappingTarget Loan entity, LoanDto dto);
}
