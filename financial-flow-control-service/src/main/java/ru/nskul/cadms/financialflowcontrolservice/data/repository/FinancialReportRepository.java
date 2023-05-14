package ru.nskul.cadms.financialflowcontrolservice.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nskul.cadms.financialflowcontrolservice.domain.financial.report.FinancialReport;
import ru.nskul.cadms.financialflowcontrolservice.domain.user.User;

import java.util.UUID;

/**
 * Репозиторий финансовызх отчетов.
 */
public interface FinancialReportRepository extends JpaRepository<FinancialReport, UUID> {
}
