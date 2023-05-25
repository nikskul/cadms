package ru.nskul.cadms.financialflowcontrolservice.domain.model.loan.criteria.enums;

import lombok.Getter;

/**
 * Кредитный рейтинг.
 */
@Getter
public enum CreditRating {

    EXCELLENT(5),
    GOOD(4),
    FAIR(3),
    POOR(2),
    INFERIOR(1);

    private final Integer weight;

    CreditRating(Integer weight) {
        this.weight = weight;
    }
}
