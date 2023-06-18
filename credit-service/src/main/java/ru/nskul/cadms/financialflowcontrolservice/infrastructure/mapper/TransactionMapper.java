package ru.nskul.cadms.financialflowcontrolservice.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.transaction.Transaction;
import ru.nskul.cadms.financialflowcontrolservice.presentation.dto.TransactionDto;

@Mapper(
        config = AuditFieldsConfigMapper.class,
        componentModel = "spring"
)
public interface TransactionMapper {

    /**
     * Конвертация в DTO.
     *
     * @param entity
     * @return DTO
     */
    TransactionDto convert(Transaction entity);

    /**
     * Конвертация в Entity.
     *
     * @param entity модель
     * @param dto    DTO
     * @return Entity
     */
    Transaction convert(@MappingTarget Transaction entity, TransactionDto dto);

}
