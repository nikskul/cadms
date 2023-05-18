package ru.nskul.cadms.financialflowcontrolservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.financial.report.FinancialReport;

import java.util.UUID;

/**
 * Репозиторий финансовых отчетов.
 */
public interface FinancialReportRepository extends JpaRepository<FinancialReport, UUID> {
}
