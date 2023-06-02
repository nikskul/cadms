package ru.nskul.cadms.financialflowcontrolservice.presentation.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class LoginRequest {

    private String email;

    private String password;
}
