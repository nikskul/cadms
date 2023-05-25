package ru.nskul.cadms.financialflowcontrolservice.application.loan.rating;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.loan.criteria.LoanCriteria;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.loan.criteria.enums.CreditWorthiness;
import ru.nskul.cadms.financialflowcontrolservice.domain.repository.LoanCriteriaRepository;
import ru.nskul.cadms.financialflowcontrolservice.presentation.response.BaseOperationResponse;

import java.util.UUID;

/**
 * Стратегия оценки кредита на основе многокритериального анализа.
 */
@Component
@RequiredArgsConstructor
public class MultiCriteriaLoanRatingStrategy implements LoanRatingStrategy {

    private final LoanCriteriaRepository repository;

    @Override
    public BaseOperationResponse evaluateLoan(UUID loanId) {
        var criteria = repository.findByLoanId(loanId)
                .orElseThrow(() -> new RuntimeException("Нет займа с id: " + loanId));

        if (criteria.getWorthiness() != null) {
            return BaseOperationResponse.ok();
        }

        CreditWorthiness worthiness = analyzeCredit(criteria);
        criteria.setWorthiness(worthiness);

        LoanCriteria saved = repository.save(criteria);
        if (saved.getWorthiness() == null) {
            return BaseOperationResponse.failed("Не удалось обновить кредитный рейтинг!");
        }

        return BaseOperationResponse.ok();
    }

    private CreditWorthiness analyzeCredit(LoanCriteria criteria) {
        final int maxWeight = 5;
        final int minWeight = 0;

        final int maxAge = 60;
        final int minAge = 20;

        final int maxExperience = 15;
        final int minExperience = 2;

        final double creditRatingCoefficient = 0.3;
        final double incomeLevelCoefficient = 0.3;
        final double personAgeCoefficient = 0.15;
        final double workExperienceCoefficient = 0.25;

        double creditRating = criteria.getCreditRating().getWeight();
        double incomeLevel = criteria.getIncomeLevel().getWeight();
        double personAge = criteria.getPersonAge();
        double workExperience = criteria.getWorkExperience();

        creditRating = normalize(creditRating, minWeight, maxWeight);
        incomeLevel = normalize(incomeLevel, minWeight, maxWeight);
        personAge = normalize(personAge, minAge, maxAge);
        workExperience = normalize(workExperience, minExperience, maxExperience);

        var creditRate = creditRating * creditRatingCoefficient
                + incomeLevel * incomeLevelCoefficient
                + personAge * personAgeCoefficient
                + workExperience * workExperienceCoefficient;

        if (creditRate > 0.7) {
            return CreditWorthiness.SOLVENT;
        }
        if (creditRate <= 0.3) {
            return CreditWorthiness.INSOLVENT;
        }
        return CreditWorthiness.MEDIUM;
    }

    private double normalize(double value, double min, double max) {
        return (value - min) / (max - min);
    }
}
