package ru.nskul.cadms.financialflowcontrolservice.application.loan.criteria;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.nskul.cadms.financialflowcontrolservice.application.loan.LoanFetchUseCase;
import ru.nskul.cadms.financialflowcontrolservice.domain.repository.LoanCriteriaRepository;
import ru.nskul.cadms.financialflowcontrolservice.infrastructure.mapper.LoanCriteriaMapper;
import ru.nskul.cadms.financialflowcontrolservice.presentation.dto.LoanCriteriaDto;
import ru.nskul.cadms.financialflowcontrolservice.presentation.response.BaseOperationResponse;

import java.util.List;
import java.util.UUID;

/**
 * Сервис для работы с критериями оценки кредита.
 */
@Component
@RequiredArgsConstructor
public class LoanCriteriaService {

    private final LoanCriteriaRepository repository;
    private final LoanCriteriaMapper mapper;

    private final LoanCriteriaCreateUseCase createUseCase;
    private final LoanFetchUseCase loanFetchUseCase;

    public BaseOperationResponse createLoanCriteria(UUID loanId) {
        var loan = loanFetchUseCase.exec(loanId);
        var saved = createUseCase.exec(loan);
        if (saved == null) {
            return BaseOperationResponse.failed("Не удалось сохранить критерии оценки.");
        }
        return BaseOperationResponse.ok();
    }

    public LoanCriteriaDto getByLoanId(UUID id) {
        return mapper.convert(
            repository.findByLoanId(id)
                .orElseGet(() -> createUseCase.exec(loanFetchUseCase.exec(id)))
        );
    }
}
