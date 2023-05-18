package ru.nskul.cadms.financialflowcontrolservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.loan.Loan;

import java.util.List;
import java.util.UUID;

/**
 * Репозиторий займов.
 */
public interface LoanRepository extends JpaRepository<Loan, UUID> {

    List<Loan> findAllByUserId(UUID userId);
}
