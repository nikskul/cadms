package ru.nskul.cadms.financialflowcontrolservice.application.transactions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.budget.plan.BudgetPlan;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.transaction.Transaction;
import ru.nskul.cadms.financialflowcontrolservice.domain.repository.BudgetPlanRepository;
import ru.nskul.cadms.financialflowcontrolservice.domain.repository.TransactionRepository;
import ru.nskul.cadms.financialflowcontrolservice.domain.repository.UserRepository;
import ru.nskul.cadms.financialflowcontrolservice.infrastructure.mapper.BudgetPlanMapper;
import ru.nskul.cadms.financialflowcontrolservice.infrastructure.mapper.TransactionMapper;
import ru.nskul.cadms.financialflowcontrolservice.presentation.dto.TransactionDto;

/**
 * Use case создания займа.
 */
@Component
@RequiredArgsConstructor
public class TransactionCreateUserCase {
    private final TransactionRepository repository;
    private final TransactionMapper mapper;

    private final UserRepository userRepository;

    public Transaction exec(TransactionDto dto) {

        if (dto.getUser() == null) {
            throw new IllegalArgumentException("User не должен быть пустым!");
        }
        var user = userRepository.getReferenceById(dto.getUser().getId());

        var transaction = mapper.convert(new Transaction(), dto);
        transaction.setUser(user);

        return repository.save(transaction);
    }
}
