package ru.nskul.cadms.financialflowcontrolservice.domain.model.transaction;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.BaseDomainEntity;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.user.User;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Модель транзакции.
 */
@Entity
@Getter
@Setter
@SuperBuilder(setterPrefix = "with")
@EqualsAndHashCode(callSuper = true)
@Table(name = "transactions")
public final class Transaction extends BaseDomainEntity {

    /**
     * Размер транзакции.
     */
    private BigDecimal amount;

    /**
     * Тип транзакции.
     */
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    /**
     * Дата и время транзакции.
     */
    private Instant transactionTimestamp;

    /**
     * Описание транзакции.
     */
    private String description;

    /**
     * Пользователь.
     */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
