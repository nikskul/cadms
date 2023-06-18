package ru.nskul.cadms.financialflowcontrolservice.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.user.User;
import ru.nskul.cadms.financialflowcontrolservice.presentation.dto.UserDto;
import ru.nskul.cadms.financialflowcontrolservice.presentation.dto.UserWithPasswordDto;

@Mapper(
        config = AuditFieldsConfigMapper.class,
        componentModel = "spring"
)
public interface UserMapper {

    /**
     * Конвертация в DTO.
     *
     * @param user пользователь
     * @return DTO пользователя
     */
    UserDto convert(User user);

    /**
     * Конвертация в Entity.
     *
     * @param entity модель пользователя
     * @param dto    DTO пользователя
     * @return Entity пользователя
     */
    User convert(@MappingTarget User entity, UserWithPasswordDto dto);
}
