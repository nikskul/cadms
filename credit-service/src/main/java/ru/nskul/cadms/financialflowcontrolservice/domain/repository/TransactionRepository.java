package ru.nskul.cadms.financialflowcontrolservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.transaction.Transaction;

import java.util.UUID;

/**
 * Репозиторий транзакций.
 */
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}
