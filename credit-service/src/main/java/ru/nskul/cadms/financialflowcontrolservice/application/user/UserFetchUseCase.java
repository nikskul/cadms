package ru.nskul.cadms.financialflowcontrolservice.application.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.user.User;
import ru.nskul.cadms.financialflowcontrolservice.domain.repository.UserRepository;

import java.util.UUID;

@Component
public interface UserFetchUseCase<T> {

    User exec(T value);
}
