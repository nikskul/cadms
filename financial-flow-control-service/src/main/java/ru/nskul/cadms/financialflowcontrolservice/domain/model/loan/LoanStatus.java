package ru.nskul.cadms.financialflowcontrolservice.domain.model.loan;

/**
 * Статус займа.
 */
public enum LoanStatus {

    /**
     * Ожидание одобрения займа.
     */
    PENDING,

    /**
     * Займ одобрен.
     */
    APPROVED,

    /**
     * Займ отклонен.
     */
    REJECTED,

    /**
     * Займ активен, выплаты по займу производятся регулярно.
     */
    ACTIVE,

    /**
     * Займ не выплачен вовремя и находится в просроченном состоянии.
     */
    OVERDUE,

    /**
     * Займ полностью выплачен.
     */
    PAID,
}
