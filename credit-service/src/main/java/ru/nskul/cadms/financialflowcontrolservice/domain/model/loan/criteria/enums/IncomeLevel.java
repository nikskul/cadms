package ru.nskul.cadms.financialflowcontrolservice.domain.model.loan.criteria.enums;

import lombok.Getter;

/**
 * Уровень дохода.
 */
@Getter
public enum IncomeLevel {


    HIGH(5),
    MEDIUM(4),
    SMALL(3);

    private final Integer weight;

    IncomeLevel(Integer weight) {
        this.weight = weight;
    }
}
