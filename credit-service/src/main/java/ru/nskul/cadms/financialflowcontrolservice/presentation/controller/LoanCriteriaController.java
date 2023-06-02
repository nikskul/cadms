package ru.nskul.cadms.financialflowcontrolservice.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.nskul.cadms.financialflowcontrolservice.application.loan.criteria.LoanCriteriaService;
import ru.nskul.cadms.financialflowcontrolservice.presentation.dto.LoanCriteriaDto;
import ru.nskul.cadms.financialflowcontrolservice.presentation.response.BaseOperationResponse;

import java.util.List;
import java.util.UUID;

/**
 * API займов.
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/loan-criteria")
public class LoanCriteriaController {

    private final LoanCriteriaService service;

    /**
     * Создание критериев по займу.
     *
     * @param id
     * @return
     */
    @PostMapping("/create/loan/{id}")
    public BaseOperationResponse create(@PathVariable UUID id) {
        return service.createLoanCriteria(id);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/loan/{id}")
    public LoanCriteriaDto getByLoanId(@PathVariable UUID id) {
        return service.getByLoanId(id);
    }
}
