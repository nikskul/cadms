package ru.nskul.cadms.financialflowcontrolservice.application.transactions;

import jakarta.persistence.LockModeType;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import ru.nskul.cadms.financialflowcontrolservice.domain.model.transaction.Transaction;
import ru.nskul.cadms.financialflowcontrolservice.domain.repository.TransactionRepository;
import ru.nskul.cadms.financialflowcontrolservice.infrastructure.mapper.TransactionMapper;
import ru.nskul.cadms.financialflowcontrolservice.presentation.dto.TransactionDto;
import ru.nskul.cadms.financialflowcontrolservice.presentation.request.TransactionFetchParams;
import ru.nskul.cadms.financialflowcontrolservice.presentation.response.BaseOperationResponse;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionCreateUserCase createUserCase;
    private final TransactionRepository repository;

    private final TransactionMapper mapper;

    @Transactional
    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    public BaseOperationResponse create(TransactionDto dto) {
        createUserCase.exec(dto);
        return BaseOperationResponse.ok();
    }

    public List<TransactionDto> getByPeriod(TransactionFetchParams params) {
        if (params.getUserId() == null) {
            throw new RuntimeException("UserId не должен быть null!");
        }

        return repository.findAllByDateBetweenAndUserId(
                        params.getStartDate(),
                        params.getEndDate(),
                        params.getUserId()
                ).stream()
                .map(mapper::convert)
                .toList();
    }

    public List<TransactionDto> getByUserId(UUID userId) {
        return repository.findAllByUserId(userId)
                .stream()
                .map(mapper::convert)
                .toList();
    }
}
