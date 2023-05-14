package ru.nskul.cadms.financialflowcontrolservice.domain.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import ru.nskul.cadms.financialflowcontrolservice.domain.BaseDomainEntity;

import java.math.BigDecimal;

/**
 * Модель пользователя.
 */
@Entity
@SuperBuilder(setterPrefix = "with")
@EqualsAndHashCode(callSuper = true)
@Table(name = "users")
public final class User extends BaseDomainEntity {

    private String name;

    private String email;

    private BigDecimal income;

    private BigDecimal expenses;
}
