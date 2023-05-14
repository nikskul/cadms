package ru.nskul.cadms.financialflowcontrolservice.domain.loan;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.nskul.cadms.financialflowcontrolservice.domain.BaseDomainEntity;
import ru.nskul.cadms.financialflowcontrolservice.domain.user.User;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Модель займа.
 */
@Entity
@Getter
@Setter
@SuperBuilder(setterPrefix = "with")
@EqualsAndHashCode(callSuper = true)
@Table(name = "loans")
public final class Loan extends BaseDomainEntity {

    /**
     * Наименование банка.
     */
    private String bankName;

    /**
     * Размер займа.
     */
    private BigDecimal amount;

    /**
     * Коэффициент займа.
     */
    private BigDecimal interestRate;

    /**
     * Срок займа.
     */
    private Integer term;

    /**
     * Статус займа.
     */
    @Enumerated(EnumType.STRING)
    private LoanStatus status;

    /**
     * Дата открытия займа.
     */
    private LocalDate startDate;

    /**
     * Дата погашения займа.
     */
    private LocalDate endDate;

    /**
     * Пользователь.
     */
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
