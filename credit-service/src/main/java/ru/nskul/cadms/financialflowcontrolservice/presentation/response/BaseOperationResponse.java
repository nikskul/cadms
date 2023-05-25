package ru.nskul.cadms.financialflowcontrolservice.presentation.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * Базовый класс для ответа на запрос.
 */
@Data
@SuperBuilder
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BaseOperationResponse {

    private OperationStatus status;

    private String message;

    public static BaseOperationResponse ok() {
        return BaseOperationResponse.builder()
            .status(OperationStatus.OK)
            .build();
    }

    public static BaseOperationResponse failed(String message) {
        return BaseOperationResponse.builder()
            .status(OperationStatus.FAILED)
            .message(message)
            .build();
    }
}
