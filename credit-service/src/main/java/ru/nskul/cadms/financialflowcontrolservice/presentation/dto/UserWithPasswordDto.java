package ru.nskul.cadms.financialflowcontrolservice.presentation.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public final class UserWithPasswordDto extends UserDto {

    private String password;
}
