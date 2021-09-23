package one.digitalinnovation.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {
    HOME("HOME"),
    MOBILE("MOBILE"),
    COMMERCIAL("COMMERCIAL");

    private final String description; 




}
