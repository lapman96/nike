package com.nike.dto.localstorage.purpose_limitations.guest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserLicenseDTO {
    @JsonProperty("permission")
    private String permission;

    @JsonProperty("principal")
    private String principal;

    @JsonProperty("isEnabled")
    private boolean isEnabled;

    @JsonProperty("isDefault")
    private boolean isDefault;

    void enableUserLicense() {
        isEnabled = true;
        isDefault = false;
    }
}
