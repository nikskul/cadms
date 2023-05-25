package ru.nskul.cadms.financialflowcontrolservice.domain.model.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.BaseDomainEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Модель пользователя.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder(setterPrefix = "with")
@EqualsAndHashCode(callSuper = true)
@Table(name = "users")
public final class User extends BaseDomainEntity {

    /**
     * Имя пользователя.
     */
    private String name;

    /**
     * Почта.
     */
    private String email;

    /**
     * Доходы в мес.
     */
    private BigDecimal income;

    /**
     * Дата рождения.
     */
    private LocalDate birthDate;

    /**
     * Дата рождения.
     */
    private Integer lastWorkExperience;
}
