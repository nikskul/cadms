package ru.nskul.cadms.financialflowcontrolservice.application.loan.rating;

import org.springframework.stereotype.Component;
import ru.nskul.cadms.financialflowcontrolservice.presentation.response.BaseOperationResponse;

import java.util.UUID;

/**
 * Use case оценки кредитоспособности.
 */
@Component
public class LoanRatingAnalyzeUseCase {

    /**
     * Основной метод.
     * @param strategy стратегия оценки кредита
     * @param loanId идентификатор кредита
     */
    public BaseOperationResponse exec(LoanRatingStrategy strategy, UUID loanId) {
        return strategy.evaluateLoan(loanId);
    }
}
