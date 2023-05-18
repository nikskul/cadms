package ru.nskul.cadms.financialflowcontrolservice.application.loan.criteria;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.loan.criteria.LoanCriteria;
import ru.nskul.cadms.financialflowcontrolservice.domain.repository.LoanCriteriaRepository;

import java.util.UUID;

/**
 * Use case поиска займа по id.
 */
@Component
@RequiredArgsConstructor
public class LoanCriteriaFetchUseCase {

    private final LoanCriteriaRepository repository;

    public LoanCriteria exec(UUID id) {
      return repository.findById(id).orElseThrow(
              // TODO: Заменить на кастомное исключение
              () -> new RuntimeException("Не существует критерия займа с id: " + id)
      );
    }
}
