package ru.nskul.cadms.financialflowcontrolservice.application.loan;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.nskul.cadms.financialflowcontrolservice.application.loan.rating.LoanRatingAnalyzeUseCase;
import ru.nskul.cadms.financialflowcontrolservice.application.loan.rating.LoanRatingStrategy;
import ru.nskul.cadms.financialflowcontrolservice.domain.repository.LoanRepository;
import ru.nskul.cadms.financialflowcontrolservice.infrastructure.mapper.LoanMapper;
import ru.nskul.cadms.financialflowcontrolservice.presentation.dto.LoanDto;
import ru.nskul.cadms.financialflowcontrolservice.presentation.response.BaseOperationResponse;

import java.util.List;
import java.util.UUID;

/**
 * Сервис для работы с займом.
 */
@Component
@RequiredArgsConstructor
public class LoanService {

    private final LoanMapper mapper;
    private final LoanRepository repository;

    private final LoanCreateUseCase createUseCase;

    private final LoanRatingAnalyzeUseCase analyzeUseCase;

    private final LoanRatingStrategy strategy;

    public BaseOperationResponse evaluateLoan(UUID loanId) {
        return analyzeUseCase.exec(strategy, loanId);
    }

    public List<LoanDto> findByUserId(UUID id) {
        return repository.findAllByUserId(id).stream()
                .map(mapper::convert)
                .toList();
    }

    public BaseOperationResponse create(LoanDto dto) {
        var saved = createUseCase.exec(dto);
        if (saved == null) {
            return BaseOperationResponse.failed("Не удалось сохранить займ");
        }
        return BaseOperationResponse.ok();
    }
}
