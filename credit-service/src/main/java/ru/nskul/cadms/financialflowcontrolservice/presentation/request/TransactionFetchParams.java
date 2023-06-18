package ru.nskul.cadms.financialflowcontrolservice.presentation.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.UUID;

@Data
@SuperBuilder
@NoArgsConstructor
public class TransactionFetchParams {

    private LocalDate startDate;

    private LocalDate endDate;

    private UUID userId;
}
