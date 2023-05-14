package ru.nskul.cadms.financialflowcontrolservice.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nskul.cadms.financialflowcontrolservice.domain.loan.Loan;

import java.util.UUID;

/**
 * Репозиторий займов.
 */
public interface LoanRepository extends JpaRepository<Loan, UUID> {
}
