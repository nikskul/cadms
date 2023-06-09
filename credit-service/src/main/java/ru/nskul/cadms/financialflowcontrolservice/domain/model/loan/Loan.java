package ru.nskul.cadms.financialflowcontrolservice.domain.model.loan;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.BaseDomainEntity;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.user.User;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Модель займа.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
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
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
