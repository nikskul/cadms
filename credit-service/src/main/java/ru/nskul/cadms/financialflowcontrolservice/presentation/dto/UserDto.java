package ru.nskul.cadms.financialflowcontrolservice.presentation.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO пользователя.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserDto extends BaseDomainDto {

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
     * Стаж работы.
     */
    private Integer lastWorkExperience;
}
