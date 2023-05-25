package ru.nskul.cadms.financialflowcontrolservice.application.loan.criteria;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.loan.Loan;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.loan.criteria.LoanCriteria;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.loan.criteria.enums.CreditRating;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.loan.criteria.enums.IncomeLevel;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.user.User;
import ru.nskul.cadms.financialflowcontrolservice.domain.repository.LoanCriteriaRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;

/**
 * Use case создания критериев анализа займа.
 */
@Component
@RequiredArgsConstructor
public class LoanCriteriaCreateUseCase {

    private final LoanCriteriaRepository repository;

    public LoanCriteria exec(Loan loan) {

        if (loan == null) {
            throw new IllegalArgumentException("Займ не может быть пустым!");
        }

        LoanCriteria criteria = LoanCriteria.builder()
                .withIncomeLevel(defineIncomeLevel(loan))
                .withCreditRating(CreditRating.EXCELLENT)
                .withPersonAge(defineAge(loan.getUser()))
                .withWorkExperience(loan.getUser().getLastWorkExperience())
                .withLoan(loan)
                .build();

        return repository.save(criteria);
    }

    private Integer defineAge(User user) {
        return Period.between(user.getBirthDate(), LocalDate.now()).getYears();
    }

    private IncomeLevel defineIncomeLevel(Loan loan) {
        int monthInYear = 12;
        BigDecimal userIncome = loan.getUser().getIncome();

        var yearIncome = userIncome.multiply(BigDecimal.valueOf(monthInYear));
        var loanAmount = loan.getAmount();

        BigDecimal incomeCoefficientHigh = BigDecimal.valueOf(0.5);
        BigDecimal incomeCoefficientLow = BigDecimal.valueOf(0.2);

        if (yearIncome.divide(loanAmount, 2, RoundingMode.HALF_UP).compareTo(incomeCoefficientHigh) > 0) {
            return IncomeLevel.HIGH;
        }

        if (yearIncome.divide(loanAmount, 2, RoundingMode.HALF_UP).compareTo(incomeCoefficientLow) < 0) {
            return IncomeLevel.SMALL;
        }

        return IncomeLevel.MEDIUM;
    }
}
