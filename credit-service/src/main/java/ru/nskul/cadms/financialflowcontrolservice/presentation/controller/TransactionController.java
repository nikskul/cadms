package ru.nskul.cadms.financialflowcontrolservice.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.nskul.cadms.financialflowcontrolservice.application.transactions.TransactionService;
import ru.nskul.cadms.financialflowcontrolservice.presentation.dto.TransactionDto;
import ru.nskul.cadms.financialflowcontrolservice.presentation.request.TransactionFetchParams;
import ru.nskul.cadms.financialflowcontrolservice.presentation.response.BaseOperationResponse;

import java.util.List;
import java.util.UUID;

/**
 * API .
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/transactions")
public final class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/create")
    public BaseOperationResponse create(@RequestBody TransactionDto dto) {
        return transactionService.create(dto);
    }

    @PostMapping("/by-period")
    public List<TransactionDto> getByPeriod(@RequestBody TransactionFetchParams params) {
        return transactionService.getByPeriod(params);
    }

    @GetMapping("/user/{userId}")
    public List<TransactionDto> getByPeriod(@PathVariable UUID userId) {
        return transactionService.getByUserId(userId);
    }
}
