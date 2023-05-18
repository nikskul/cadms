package ru.nskul.cadms.financialflowcontrolservice.application.loan.rating;

import ru.nskul.cadms.financialflowcontrolservice.presentation.response.BaseOperationResponse;

import java.util.UUID;

/**
 * Стратегия оценки кредита.
 */
public interface LoanRatingStrategy {

    BaseOperationResponse evaluateLoan(UUID loanId);
}
