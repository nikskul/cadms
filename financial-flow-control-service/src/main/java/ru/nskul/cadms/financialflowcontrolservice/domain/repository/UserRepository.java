package ru.nskul.cadms.financialflowcontrolservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.user.User;

import java.util.UUID;

/**
 * Репозиторий пользователей.
 */
public interface UserRepository extends JpaRepository<User, UUID> {
}
