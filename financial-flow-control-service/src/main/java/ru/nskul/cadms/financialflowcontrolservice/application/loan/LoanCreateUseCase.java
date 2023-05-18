package ru.nskul.cadms.financialflowcontrolservice.application.loan;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.loan.Loan;
import ru.nskul.cadms.financialflowcontrolservice.domain.repository.LoanRepository;
import ru.nskul.cadms.financialflowcontrolservice.domain.repository.UserRepository;
import ru.nskul.cadms.financialflowcontrolservice.infrastructure.mapper.LoanMapper;
import ru.nskul.cadms.financialflowcontrolservice.presentation.dto.LoanDto;

/**
 * Use case создания займа.
 */
@Component
@RequiredArgsConstructor
public class LoanCreateUseCase {

    private final LoanRepository repository;
    private final LoanMapper mapper;

    private final UserRepository userRepository;

    public Loan exec(LoanDto dto) {

        if (dto.getUser() == null) {
            throw new IllegalArgumentException("User не должен быть пустым!");
        }
        var user = userRepository.getReferenceById(dto.getUser().getId());

        var loan = mapper.convert(new Loan(), dto);
        loan.setUser(user);

        return repository.save(loan);
    }
}
