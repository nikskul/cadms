package ru.nskul.cadms.financialflowcontrolservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.loan.criteria.LoanCriteria;

import java.util.Optional;
import java.util.UUID;

public interface LoanCriteriaRepository extends JpaRepository<LoanCriteria, UUID> {

    /**
     * Поиск критерия по займу.
     *
     * @param loanId идентификатор займа
     * @return критерии оценки
     */
    Optional<LoanCriteria> findByLoanId(UUID loanId);
}
