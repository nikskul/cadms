package ru.nskul.cadms.financialflowcontrolservice.application.loan;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.loan.Loan;
import ru.nskul.cadms.financialflowcontrolservice.domain.repository.LoanRepository;

import java.util.UUID;

/**
 * Use case поиска займа по id.
 */
@Component
@RequiredArgsConstructor
public class LoanFetchUseCase {

    private final LoanRepository repository;

    public Loan exec(UUID id) {
      return repository.findById(id).orElseThrow(
              // TODO: Заменить на кастомное исключение
              () -> new RuntimeException("Не существует займа с id: " + id)
      );
    }
}
