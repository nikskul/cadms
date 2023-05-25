package ru.nskul.cadms.financialflowcontrolservice.application.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.user.User;
import ru.nskul.cadms.financialflowcontrolservice.domain.repository.UserRepository;
import ru.nskul.cadms.financialflowcontrolservice.infrastructure.mapper.UserMapper;
import ru.nskul.cadms.financialflowcontrolservice.presentation.dto.UserDto;

/**
 * Use case создания на основе DTO.
 */
@Component
@RequiredArgsConstructor
public class UserCreateUseCase {

    private final UserRepository repository;

    private final UserMapper mapper;

    /**
     * Основной метод.
     *
     * @param dto DTO
     * @return модель сохраненную в бд
     */
    public User exec(UserDto dto) {
        return repository.save(mapper.convert(new User(), dto));
    }
}
