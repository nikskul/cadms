package ru.nskul.cadms.financialflowcontrolservice.application.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nskul.cadms.financialflowcontrolservice.application.user.UserCreateUseCase;
import ru.nskul.cadms.financialflowcontrolservice.domain.repository.UserRepository;
import ru.nskul.cadms.financialflowcontrolservice.infrastructure.mapper.UserMapper;
import ru.nskul.cadms.financialflowcontrolservice.presentation.dto.UserDto;
import ru.nskul.cadms.financialflowcontrolservice.presentation.dto.UserWithPasswordDto;
import ru.nskul.cadms.financialflowcontrolservice.presentation.request.LoginRequest;
import ru.nskul.cadms.financialflowcontrolservice.presentation.response.BaseOperationResponse;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final UserCreateUseCase createUseCase;

    public UserDto login(LoginRequest request) {
        var user = repository.findByEmailIgnoreCase(request.getEmail());

        if (user.isEmpty() || !request.getPassword().equals(user.get().getPassword()))
            return null;

        return mapper.convert(user.get());
    }

    public BaseOperationResponse register(UserWithPasswordDto dto) {
        if (repository.findByEmailIgnoreCase(dto.getEmail()).isPresent())
            return BaseOperationResponse.failed("Email already exist!");

        if (createUseCase.exec(dto) == null)
            return BaseOperationResponse.failed("Error when create user: " + dto);

        return BaseOperationResponse.ok();
    }
}
