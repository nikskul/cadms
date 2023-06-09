package ru.nskul.cadms.financialflowcontrolservice.application.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nskul.cadms.financialflowcontrolservice.domain.repository.UserRepository;
import ru.nskul.cadms.financialflowcontrolservice.infrastructure.mapper.UserMapper;
import ru.nskul.cadms.financialflowcontrolservice.presentation.dto.UserDto;
import ru.nskul.cadms.financialflowcontrolservice.presentation.response.BaseOperationResponse;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    private final UserCreateUseCase createUseCase;
    private final UserFetchUseCase<UUID> fetchByIdUseCase;

    public BaseOperationResponse create(UserDto userDto) {
        var saved = createUseCase.exec(userDto);
        if (saved == null) {
            return BaseOperationResponse.failed("Не удалось сохранить пользователя");
        }
        return BaseOperationResponse.ok();
    }

    public UserDto getById(UUID id) {
        return mapper.convert(fetchByIdUseCase.exec(id));
    }

    public List<UserDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::convert)
                .toList();
    }
}
