package ru.nskul.cadms.financialflowcontrolservice.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nskul.cadms.financialflowcontrolservice.application.budget.plan.BudgetPlanService;
import ru.nskul.cadms.financialflowcontrolservice.presentation.dto.BudgetPlanDto;
import ru.nskul.cadms.financialflowcontrolservice.presentation.response.BaseOperationResponse;

import java.util.List;
import java.util.UUID;

/**
 * API .
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/budget-plans")
public final class BudgetPlanController {

    private final BudgetPlanService budgetPlanService;

    @GetMapping("/{id}")
    public ResponseEntity<BudgetPlanDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(budgetPlanService.getById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BudgetPlanDto>> getByUser(@PathVariable UUID userId) {
       return ResponseEntity.ok(budgetPlanService.getAllByUser(userId));
    }

    @PostMapping("/create")
    public BaseOperationResponse create(@RequestBody BudgetPlanDto dto) {
        return budgetPlanService.create(dto);
    }
}
