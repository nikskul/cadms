package ru.nskul.cadms.financialflowcontrolservice.infrastructure.mapper;

import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.BaseDomainEntity;
import ru.nskul.cadms.financialflowcontrolservice.presentation.dto.BaseDomainDto;

@MapperConfig
public interface AuditFieldsConfigMapper {

    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    BaseDomainDto convert(BaseDomainEntity entity);

    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    BaseDomainEntity convert(@MappingTarget BaseDomainEntity entity, BaseDomainDto dto);
}
