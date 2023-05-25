package ru.nskul.cadms.financialflowcontrolservice.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.nskul.cadms.financialflowcontrolservice.application.loan.LoanService;
import ru.nskul.cadms.financialflowcontrolservice.presentation.dto.LoanDto;
import ru.nskul.cadms.financialflowcontrolservice.presentation.response.BaseOperationResponse;

import java.util.List;
import java.util.UUID;

/**
 * API займов.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/loans")
public class LoanController {

    private final LoanService loanService;

    /**
     * Сохранение займа.
     *
     * @param dto
     * @return
     */
    @PostMapping("/create")
    public BaseOperationResponse createLoan(@RequestBody LoanDto dto) {
        return loanService.create(dto);
    }

    /**
     * Оценка займа.
     *
     * @param id
     * @return
     */
    @GetMapping("/analyze/{id}")
    public BaseOperationResponse analyzeLoan(@PathVariable UUID id) {
        return loanService.evaluateLoan(id);
    }


    /**
     * Оценка займа.
     *
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public List<LoanDto> findByUserId(@PathVariable UUID id) {
        return loanService.findByUserId(id);
    }
}
