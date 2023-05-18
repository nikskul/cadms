package ru.nskul.cadms.financialflowcontrolservice.application.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.user.User;
import ru.nskul.cadms.financialflowcontrolservice.domain.repository.UserRepository;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserFetchUseCase {

    private final UserRepository repository;

    public User exec(UUID id) {
        return repository.findById(id).orElseThrow(
                // TODO: Заменить на кастомное исключение
                () -> new RuntimeException("Не существует займа с id: " + id)
        );
    }
}
